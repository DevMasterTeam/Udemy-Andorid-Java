package com.devmasterteam.tasks.view;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.databinding.ActivityTaskBinding;
import com.devmasterteam.tasks.viewmodel.TaskViewModel;
import com.devmasterteam.tasks.service.constants.TaskConstants;
import com.devmasterteam.tasks.service.listener.Feedback;
import com.devmasterteam.tasks.service.model.PriorityModel;
import com.devmasterteam.tasks.service.model.TaskModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TaskActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private final List<Integer> listPriorityId = new ArrayList<>();
    private TaskViewModel viewModel;
    private int taskId = 0;
    private ActivityTaskBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left + binding.getRoot().getPaddingStart(),
                    systemBars.top + binding.getRoot().getPaddingTop(),
                    systemBars.right + binding.getRoot().getPaddingEnd(),
                    systemBars.bottom + binding.getRoot().getPaddingBottom());
            return insets;
        });

        // ViewModel
        viewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        createEvents();

        // Cria observadores
        loadObservers();

        // Listagem de tarefas
        viewModel.getList();

        // Carrega parâmetros passados na chamada da Activity
        loadDataFromActivity();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_date) {
            showDatePicker();
        } else if (id == R.id.button_save) {
            handleSave();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, dayOfMonth);

        String date = dateFormat.format(c.getTime());
        binding.buttonDate.setText(date);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadDataFromActivity() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            taskId = bundle.getInt(TaskConstants.BUNDLE.TASKID);
            binding.buttonSave.setText(this.getString(R.string.button_update_task));
            viewModel.load(taskId);
        }
    }

    private void handleSave() {
        TaskModel task = new TaskModel();

        task.setId(taskId);
        task.setDescription(binding.editDescription.getText().toString());
        task.setComplete(binding.checkComplete.isChecked());
        task.setDueDate(binding.buttonDate.getText().toString());
        task.setPriorityId(listPriorityId.get(binding.spinnerPriority.getSelectedItemPosition()));

        viewModel.save(task);
    }

    private void showDatePicker() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this, this, year, month, day).show();
    }

    /**
     * Observadores
     */
    private void loadObservers() {
        this.viewModel.listPriority.observe(this, new Observer<List<PriorityModel>>() {
            @Override
            public void onChanged(List<PriorityModel> list) {
                loadSpinner(list);
            }
        });

        this.viewModel.task.observe(this, new Observer<TaskModel>() {
            @Override
            public void onChanged(TaskModel taskModel) {
                binding.editDescription.setText(taskModel.getDescription());
                binding.checkComplete.setChecked(taskModel.isComplete());
                binding.spinnerPriority.setSelection(getIndex(taskModel.getPriorityId()));

                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(taskModel.getDueDate());
                    binding.buttonDate.setText(dateFormat.format(date));
                } catch (ParseException e) {
                    binding.buttonDate.setText("--");
                }
            }
        });

        this.viewModel.feedback.observe(this, new Observer<Feedback>() {
            @Override
            public void onChanged(Feedback feedback) {
                if (feedback.isSuccess()) {
                    if (taskId == 0) {
                        toast(getApplicationContext().getString(R.string.msg_task_created));
                    } else {
                        toast(getApplicationContext().getString(R.string.msg_task_updated));
                    }
                    finish();
                } else {
                    toast(feedback.getMessage());
                }
            }
        });
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private int getIndex(int priorityId) {
        int index = 0;
        for (int i = 0; i < listPriorityId.size(); i++) {
            if (listPriorityId.get(i) == priorityId) {
                index = i;
                break;
            }
        }

        return index;
    }

    private void loadSpinner(List<PriorityModel> list) {
        List<String> lstPriorities = new ArrayList<>();

        for (PriorityModel p : list) {
            lstPriorities.add(p.getDescription());
            listPriorityId.add(p.getId());
        }

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, lstPriorities);
        binding.spinnerPriority.setAdapter(adapter);
    }

    private void createEvents() {
        binding.buttonDate.setOnClickListener(this);
        binding.buttonSave.setOnClickListener(this);
    }
}