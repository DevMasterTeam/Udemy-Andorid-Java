package com.example.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class DateActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        // this.showTimepicker();
        // this.showDatepicker();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        // Data selecionada dividida em partes - ano, mês e dia do mês
        // Possível de instanciar uma variável do tipo Calendar com os dados escolhidos
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        // Hora e minuto selectionado
    }

    /**
     * Mostra DatePickerDialog
     */
    private void showDatepicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this, this, year, month, dayOfMonth).show();
    }

    /**
     * Mostra TimePickerDialog
     */
    private void showTimepicker() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        new TimePickerDialog(this, this, hour, minute, true).show();
    }

}