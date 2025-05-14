package com.devmasterteam.tasks.view;

import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.databinding.ActivityTaskBinding;
import com.devmasterteam.tasks.viewmodel.TaskViewModel;
import com.devmasterteam.tasks.service.constants.TaskConstants;
import com.devmasterteam.tasks.service.model.TaskModel;

public class TaskActivity extends AppCompatActivity implements View.OnClickListener {

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
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

        viewModel.save(task);
    }

    private void showDatePicker() {

    }

    /**
     * Observadores
     */
    private void loadObservers() {

    }

    private void createEvents() {
        binding.buttonDate.setOnClickListener(this);
        binding.buttonSave.setOnClickListener(this);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}