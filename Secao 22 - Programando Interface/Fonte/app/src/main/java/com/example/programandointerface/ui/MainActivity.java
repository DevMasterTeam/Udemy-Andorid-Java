package com.example.programandointerface.ui;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.programandointerface.R;
import com.example.programandointerface.business.UserBusiness;
import com.example.programandointerface.constants.AppConstants;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final ViewHolder viewHolder = new ViewHolder();
    private final UserBusiness userBusiness = new UserBusiness();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Preenche as referências
        viewHolder.editEmail = findViewById(R.id.edittext_email);
        viewHolder.editPassword = findViewById(R.id.edittext_password);
        viewHolder.buttonLogin = findViewById(R.id.button_login);
        viewHolder.buttonRegister = findViewById(R.id.button_register);

        setEvents();
    }

    /**
     * Eventos dos elementos de interface
     * */
    private void setEvents() {
        viewHolder.buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        // Responde ao click
        if (id == R.id.button_login) {
            String email = viewHolder.editEmail.getText().toString();
            String password = viewHolder.editPassword.getText().toString();

            // Login com sucesso
            if (userBusiness.checkCredentials(email, password)) {

                // Cria a informação no Bundle
                Bundle bundle = new Bundle();
                bundle.putString(AppConstants.EMAIL_KEY, email);

                // Redireciona para tela Home
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                // Notifica erro
                Toast.makeText(this, R.string.error_preencha_os_dados, Toast.LENGTH_SHORT).show();
            }

        } else if (id == R.id.button_register) {
            // Responde ao click de registro
        }
    }

    /**
     * Mantém referência aos elementos
     */
    private static class ViewHolder {
        EditText editEmail;
        EditText editPassword;
        Button buttonLogin;
        Button buttonRegister;
    }

}