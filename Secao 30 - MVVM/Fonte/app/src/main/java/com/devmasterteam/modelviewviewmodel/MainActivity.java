package com.devmasterteam.modelviewviewmodel;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.devmasterteam.modelviewviewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        this.mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        EdgeToEdge.enable(this);
        setContentView(this.binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Eventos
        setListeners();

        // Observers
        createObservers();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_login) {
            String text = this.binding.edittextName.getText().toString();
            this.mainViewModel.login(text);
        }
    }

    /**
     * Eventos de interface
     */
    private void setListeners() {
        binding.buttonLogin.setOnClickListener(this);
    }

    /**
     * Observers - Escutam mudanças que acontecem nos dados
     */
    private void createObservers() {
        this.mainViewModel.welcome().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textviewWelcome.setText(s);
            }
        });

        this.mainViewModel.loginMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}