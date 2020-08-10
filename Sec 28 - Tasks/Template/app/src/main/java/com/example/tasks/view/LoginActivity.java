package com.example.tasks.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.tasks.R;
import com.example.tasks.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Incializa as variáveis
        this.mLoginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

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