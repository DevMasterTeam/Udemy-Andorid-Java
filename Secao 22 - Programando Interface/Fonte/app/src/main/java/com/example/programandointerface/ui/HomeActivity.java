package com.example.programandointerface.ui;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.TextView;

import com.example.programandointerface.R;
import com.example.programandointerface.constants.AppConstants;

public class HomeActivity extends AppCompatActivity {

    private final ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtém elementos
        viewHolder.textEmail = findViewById(R.id.textEmail);

        // Busca informação recebida pela Intent
        getUserInformation();
    }

    /**
     * Busca informação recebida pela Intent
     */
    private void getUserInformation() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String email = bundle.getString(AppConstants.EMAIL_KEY);
            viewHolder.textEmail.setText(email);
        }
    }

    /**
     * Mantém referência aos elementos
     */
    private static class ViewHolder {
        TextView textEmail;
    }
}