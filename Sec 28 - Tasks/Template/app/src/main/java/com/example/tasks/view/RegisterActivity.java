package com.example.tasks.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.tasks.R;
import com.example.tasks.viewmodel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private RegisterViewModel mRegisterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Botão de voltar nativo
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Incializa variáveis
        this.mRegisterViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        // Cria observadores
        this.loadObservers();
    }

    private void loadObservers() {}

    /**
     * ViewHolder
     */
    private static class ViewHolder {
    }

}