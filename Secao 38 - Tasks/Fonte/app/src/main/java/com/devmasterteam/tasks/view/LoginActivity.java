package com.devmasterteam.tasks.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.databinding.ActivityLoginBinding;
import com.devmasterteam.tasks.service.listener.Feedback;
import com.devmasterteam.tasks.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left + binding.getRoot().getPaddingStart(),
                    systemBars.top,
                    systemBars.right + binding.getRoot().getPaddingEnd(),
                    systemBars.bottom);
            return insets;
        });

        // Incializa as variáveis
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        // Eventos
        setListeners();

        // Cria observadores
        loadObservers();

        // Verifica se o usuário está logado
        verifyUserLogged();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_login) {
            String email = binding.editEmail.getText().toString();
            String password = binding.editPassword.getText().toString();

            loginViewModel.login(email, password);
        }
        else if (id == R.id.text_register) {
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
        }
    }

    private void verifyUserLogged() {
        loginViewModel.verifyUserLogged();
    }

    private void setListeners() {
        binding.buttonLogin.setOnClickListener(this);
        binding.textRegister.setOnClickListener(this);
    }

    private void loadObservers() {
        loginViewModel.login.observe(this, new Observer<Feedback>() {
            @Override
            public void onChanged(Feedback feedback) {
                if (feedback.isSuccess()) {
                    startMain();
                } else {
                    Toast.makeText(getApplicationContext(), feedback.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginViewModel.userLogged.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean logged) {
                if (logged) {
                    startMain();
                }
            }
        });
    }

    private void startMain() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}