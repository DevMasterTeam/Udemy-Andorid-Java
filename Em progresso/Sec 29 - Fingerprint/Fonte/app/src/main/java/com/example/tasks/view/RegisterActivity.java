package com.example.tasks.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tasks.R;
import com.example.tasks.service.listener.Feedback;
import com.example.tasks.viewmodel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

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

        this.mViewHolder.editName = findViewById(R.id.edit_name);
        this.mViewHolder.editEmail = findViewById(R.id.edit_email);
        this.mViewHolder.editPassword = findViewById(R.id.edit_password);
        this.mViewHolder.buttonCreate = findViewById(R.id.button_create);

        this.mViewHolder.buttonCreate.setOnClickListener(this);

        // Incializa variáveis
        this.mRegisterViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        // Cria observadores
        this.loadObservers();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_create) {

            String name = this.mViewHolder.editName.getText().toString();
            String email = this.mViewHolder.editEmail.getText().toString();
            String password = this.mViewHolder.editPassword.getText().toString();

            this.mRegisterViewModel.create(name, email, password);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadObservers() {
        this.mRegisterViewModel.create.observe(this, new Observer<Feedback>() {
            @Override
            public void onChanged(Feedback feedback) {
                if (feedback.isSuccess()) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), feedback.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        EditText editName;
        EditText editEmail;
        EditText editPassword;
        Button buttonCreate;
    }

}