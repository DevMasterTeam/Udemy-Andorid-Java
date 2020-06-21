package com.example.relogio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private Runnable mRunnable;
    private boolean mTicker = false;
    private boolean mLandscape = false;

    // Método para recebimento de evento de alteração de bateria
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            mViewHolder.textBattery.setText(String.format("%s%%", level));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Inicializa elementos de interface
        this.mViewHolder.textHourMinute = findViewById(R.id.text_hour_minute);
        this.mViewHolder.textSeconds = findViewById(R.id.text_seconds);
        this.mViewHolder.textBattery = findViewById(R.id.text_battery);
        this.mViewHolder.textNight = findViewById(R.id.text_night);

        // Tratamento para caso o usuário não consiga deixar a tela full screen com swipe
        this.mViewHolder.textHourMinute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSystemUI();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Registra lógica para ouvir alterações no nível da bateria
        this.registerReceiver(this.mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        // Sinaliza que thread por ser executada
        this.mTicker = true;

        // Verifica se dispositivo está em modo landscape
        this.mLandscape = (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);

        // Inicializa thread
        this.startClock();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Quando a activity não está mais visível para o usuário
        // remove thread e também não responde mais aos eventos de nível de bateria
        this.mTicker = false;
        this.unregisterReceiver(this.mReceiver);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            // Esconde nav bar e status bar
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
            );
        }
    }

    /**
     * Retorna os elementos de navegação
     */
    private void showSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    /**
     * Inicializa o relógio de cabeceira
     */
    private void startClock() {

        // Inicializa o calendário
        final Calendar calendar = Calendar.getInstance();

        // Lida com a thread
        final Handler mHandler = new Handler();

        // Inicializa thread
        this.mRunnable = new Runnable() {
            @Override
            public void run() {

                if (!mTicker) {
                    return;
                }

                // Obtém o tempo do celular e atribui ao calendário criado
                calendar.setTimeInMillis(System.currentTimeMillis());

                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minutes = calendar.get(Calendar.MINUTE);
                int seconds = calendar.get(Calendar.SECOND);

                // Converte e atribui
                mViewHolder.textHourMinute.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minutes));
                mViewHolder.textSeconds.setText(String.format(Locale.getDefault(), "%02d", seconds));

                // Só executa se dispositivo está em modo landscape
                if (mLandscape) {
                    if (hour >= 18) {
                        mViewHolder.textNight.setVisibility(View.VISIBLE);
                    } else {
                        mViewHolder.textNight.setVisibility(View.GONE);
                    }
                }

                // Cálculo de quando a thread vai rodar novamente
                long now = SystemClock.elapsedRealtime();
                long next = now + (1000 - (now % 1000));
                mHandler.postAtTime(mRunnable, next);
            }
        };

        // Faz com que a thread rode pela primeira vez
        this.mRunnable.run();
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        TextView textHourMinute;
        TextView textSeconds;
        TextView textBattery;
        TextView textNight;
    }
}