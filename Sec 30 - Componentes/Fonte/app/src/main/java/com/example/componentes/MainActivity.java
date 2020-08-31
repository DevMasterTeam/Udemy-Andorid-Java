package com.example.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
        , AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener
        , CompoundButton.OnCheckedChangeListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mapeia elementos
        this.mViewHolder.buttonToast = findViewById(R.id.button_toast);
        this.mViewHolder.buttonSnack = findViewById(R.id.button_snack);
        this.mViewHolder.buttonGetSpinner = findViewById(R.id.button_get_spinner);
        this.mViewHolder.buttonSetSpinner = findViewById(R.id.button_set_spinner);
        this.mViewHolder.buttonGetSeek = findViewById(R.id.button_get_seek);
        this.mViewHolder.buttonSetSeek = findViewById(R.id.button_set_seek);
        this.mViewHolder.linearRoot = findViewById(R.id.linear_root);
        this.mViewHolder.spinnerDynamic = findViewById(R.id.spinner_dynamic);
        this.mViewHolder.textSeekbar = findViewById(R.id.text_seekbar_value);
        this.mViewHolder.seekBar = findViewById(R.id.seekbar);
        this.mViewHolder.switchOnOff = findViewById(R.id.switch_on_off);
        this.mViewHolder.checkOnOff = findViewById(R.id.check_on_off);
        this.mViewHolder.radioYes = findViewById(R.id.radio_yes);
        this.mViewHolder.radioNo = findViewById(R.id.radio_no);

        // Carrega spinner dinâmico
        this.loadSpinner();

        // Eventos
        this.setListeners();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_toast) {
            Toast toast = Toast.makeText(this, "Toast", Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.TOP, 200, 200);
            toast.show();
        } else if (id == R.id.button_snack) {
            Snackbar snackbar = Snackbar.make(this.mViewHolder.linearRoot, "Snack", Snackbar.LENGTH_SHORT);

            snackbar.setAction("Desfazer", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(mViewHolder.linearRoot, "Desfeito!", Snackbar.LENGTH_SHORT).show();
                }
            });

            snackbar.setBackgroundTint(Color.GREEN);
            snackbar.setActionTextColor(Color.BLACK);

            snackbar.show();
        } else if (id == R.id.button_get_spinner) {
            String selectec = this.mViewHolder.spinnerDynamic.getSelectedItem().toString();
            int position = this.mViewHolder.spinnerDynamic.getSelectedItemPosition();
            long itemId = this.mViewHolder.spinnerDynamic.getSelectedItemId();
        } else if (id == R.id.button_set_spinner) {
            this.mViewHolder.spinnerDynamic.setSelection(0);
        } else if (id == R.id.button_set_seek) {
            this.mViewHolder.seekBar.setProgress(12);
        } else if (id == R.id.button_get_seek) {
            int progress = this.mViewHolder.seekBar.getProgress();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String item = adapterView.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.mViewHolder.textSeekbar.setText(String.valueOf(progress * 5));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        toast("Start tracking");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        toast("Stop tracking");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if (compoundButton.getId() == R.id.switch_on_off) {
            this.mViewHolder.switchOnOff.isChecked();
            this.mViewHolder.switchOnOff.setChecked(false);
        } else if (compoundButton.getId() == R.id.check_on_off) {
            this.mViewHolder.checkOnOff.isChecked();
            this.mViewHolder.checkOnOff.setChecked(false);
        } else if (compoundButton.getId() == R.id.radio_no) {
            this.mViewHolder.radioNo.isChecked();
            this.mViewHolder.radioNo.setChecked(true);
        } else if (compoundButton.getId() == R.id.radio_yes) {
            this.mViewHolder.radioYes.isChecked();
            this.mViewHolder.radioYes.setChecked(true);
        }
    }

    /**
     * Facilita uso de ToastNotification
     */
    private void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    /**
     * Carrega spinner dinâmico
     */
    private void loadSpinner() {
        // lista
        List<String> lst = Arrays.asList("Euro", "Libra", "Real", "Dólar");

        // adapter
        SpinnerAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lst);

        // elemento - spinner
        this.mViewHolder.spinnerDynamic.setAdapter(adapter);
    }

    /**
     * Atribui eventos
     */
    private void setListeners() {
        this.mViewHolder.buttonToast.setOnClickListener(this);
        this.mViewHolder.buttonSnack.setOnClickListener(this);
        this.mViewHolder.buttonGetSpinner.setOnClickListener(this);
        this.mViewHolder.buttonSetSpinner.setOnClickListener(this);
        this.mViewHolder.buttonGetSeek.setOnClickListener(this);
        this.mViewHolder.buttonSetSeek.setOnClickListener(this);

        this.mViewHolder.spinnerDynamic.setOnItemSelectedListener(this);

        this.mViewHolder.seekBar.setOnSeekBarChangeListener(this);

        this.mViewHolder.switchOnOff.setOnCheckedChangeListener(this);
        this.mViewHolder.checkOnOff.setOnCheckedChangeListener(this);
        this.mViewHolder.radioYes.setOnCheckedChangeListener(this);
        this.mViewHolder.radioNo.setOnCheckedChangeListener(this);
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        Button buttonToast;
        Button buttonSnack;
        Button buttonGetSpinner;
        Button buttonSetSpinner;
        Button buttonGetSeek;
        Button buttonSetSeek;
        Spinner spinnerDynamic;
        SeekBar seekBar;
        TextView textSeekbar;
        LinearLayout linearRoot;
        Switch switchOnOff;
        CheckBox checkOnOff;
        RadioButton radioYes;
        RadioButton radioNo;
    }
}