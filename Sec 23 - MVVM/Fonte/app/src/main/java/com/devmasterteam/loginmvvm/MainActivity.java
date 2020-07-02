package com.devmasterteam.loginmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainViewModel mMainViewModel;
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textWelcome = findViewById(R.id.textWelcome);
        this.mViewHolder.editName = findViewById(R.id.editName);
        this.mViewHolder.buttonLogin = findViewById(R.id.buttonLogin);

        this.mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Eventos
        this.mViewHolder.buttonLogin.setOnClickListener(this);

        // Inicializa observers
        this.createObservers();
    }

    @Override
    public void onClick(View view) {
        String name = this.mViewHolder.editName.getText().toString();
        this.mMainViewModel.doLogin(name);
    }

    private void createObservers() {
        this.mMainViewModel.welcome().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mViewHolder.textWelcome.setText(s);
            }
        });

        this.mMainViewModel.toastNotification().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        TextView textWelcome;
        EditText editName;
        Button buttonLogin;
    }
}