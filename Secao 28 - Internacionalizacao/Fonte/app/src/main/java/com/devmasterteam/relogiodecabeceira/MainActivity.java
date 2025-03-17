package com.devmasterteam.relogiodecabeceira;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.devmasterteam.relogiodecabeceira.databinding.ActivityMainBinding;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // TAG usada para Log - Fácil identificação
    private static final String TAG = "MainActivity";
    private final Handler handler = new Handler();
    private ActivityMainBinding binding;
    private Runnable runner;

    /**
     * Recebimento de evento de alteração de bateria
     */
    private final BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            binding.textviewBattery.setText(getString(R.string.label_battery_level, level));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setFlags();

        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        // Eventos
        setListeners();

        // Faz com que o elemento animado fique deslocado na actvitity e assim não visível
        hideOptions();

        // Incializa a thread
        startBedside();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(batteryReceiver);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.checkbox_battery) {
            toggleBatteryLevel();
        } else if (id == R.id.image_options) {
            showOptions();
        } else if (id == R.id.imageview_close) {
            hideOptions();
        }
    }

    /**
     * Linguagem do dispositivo
     */
    private void getDeviceLanguage() {
        Locale.getDefault().getLanguage();          // en
        Locale.getDefault().getISO3Language();      // eng
        Locale.getDefault().getCountry();           // US
        Locale.getDefault().getISO3Country();       // USA
        Locale.getDefault().getDisplayCountry();    // United States
        Locale.getDefault().getDisplayName();       // English (United States)
        Locale.getDefault();                        // en_US
        Locale.getDefault().getDisplayLanguage();   // English
        Locale.getDefault().toLanguageTag();        // en-US
    }

    /**
     * Adiciona flags de Tela cheia e para não bloquear a tela.
     * */
    private void setFlags() {
        // Remove a barra superior
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Faz com que o dispositivo não bloqueie desde que permaneça nessa activity
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    /**
     * Exibe as opções na interface do usuário, animando os componentes para a posição visível.
     */
    private void showOptions() {
        int duration = 400;
        binding.checkboxBattery.animate().translationY(0).setDuration(400);
        binding.imageviewClose.animate().translationY(0).setDuration(400);
    }

    /**
     * Oculta as opções da interface do usuário, movendo os componentes para fora da tela.
     */
    private void hideOptions() {
        int duration = 400;

        // Aguarda a renderização dos componentes antes de calcular suas alturas e margens
        binding.checkboxBattery.post(new Runnable() {
            @Override
            public void run() {
                // Obtém a altura do CheckBox após o layout ter sido calculado
                int checkboxHeight = binding.checkboxBattery.getHeight();

                // Obtém os parâmetros de layout do CheckBox para acessar suas margens
                ViewGroup.MarginLayoutParams checkboxParams = (ViewGroup.MarginLayoutParams) binding.checkboxBattery.getLayoutParams();

                // Obtém a margem inferior do CheckBox
                int checkboxBottomMargin = checkboxParams.bottomMargin;

                // Calcula a altura total para ocultar o CheckBox (altura do componente + margem inferior)
                int totalCheckboxHideHeight = checkboxHeight + checkboxBottomMargin;

                // Aplica a animação para mover o CheckBox para fora da tela verticalmente
                binding.checkboxBattery.animate().translationY(totalCheckboxHideHeight).setDuration(duration);
            }
        });

        // Aguarda a renderização dos componentes antes de calcular suas alturas e margens
        // Uso de lambda para simplificar escrita de classe anônima
        binding.imageviewClose.post(() -> {
            // Obtém a altura do botão de fechar após o layout ter sido calculado
            int closeImageHeight = binding.imageviewClose.getHeight();

            // Obtém os parâmetros de layout do botão de fechar para acessar suas margens
            ViewGroup.MarginLayoutParams closeImageParams = (ViewGroup.MarginLayoutParams) binding.imageviewClose.getLayoutParams();

            // Obtém a margem inferior do botão de fechar
            int closeImageBottomMargin = closeImageParams.bottomMargin;

            // Calcula a altura total para ocultar o botão de fechar (altura do componente + margem inferior)
            int totalCloseImageHideHeight = closeImageHeight + closeImageBottomMargin;

            // Aplica a animação para mover o botão de fechar para fora da tela verticalmente
            binding.imageviewClose.animate().translationY(totalCloseImageHideHeight).setDuration(duration);
        });
    }

    /**
     * Mostra ou remove o nível da bateria
     */
    private void toggleBatteryLevel() {
        boolean isVisible = binding.textviewBattery.getVisibility() == View.VISIBLE;
        binding.textviewBattery.setVisibility(isVisible ? View.GONE : View.VISIBLE);
    }

    /**
     * Eventos
     */
    private void setListeners() {
        binding.checkboxBattery.setOnClickListener(this);
        binding.imageOptions.setOnClickListener(this);
        binding.imageviewClose.setOnClickListener(this);
    }

    /**
     * Inicializa o relógio de cabeceira
     */
    private void startBedside() {
        runner = new Runnable() {
            @Override
            public void run() {
                // Inicializa o calendário
                Calendar calendar = Calendar.getInstance();

                // Obtém o tempo do celular e atribui ao calendário criado
                calendar.setTimeInMillis(System.currentTimeMillis());

                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                int second = calendar.get(Calendar.SECOND);

                // Converte
                String hourMinutesFormat = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
                String secondsFormat = String.format(Locale.getDefault(), "%02d", second);

                // Atribui
                binding.textviewHourMinute.setText(hourMinutesFormat);
                binding.textviewSecond.setText(secondsFormat);

                // Cálculo de quando a thread vai rodar novamente
                long now = SystemClock.uptimeMillis();
                long next = now + (1000 - (now % 1000));
                handler.postAtTime(runner, next);

                // Uso de logs - Do menos crítico para o mais
                /* Log.v(TAG, "verbose");
                Log.d(TAG, "debug");
                Log.i(TAG, "info");
                Log.w(TAG, "warn");
                Log.e(TAG, "error");*/
            }
        };
        runner.run();
    }
}