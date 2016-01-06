package com.example.fran_.mathdice_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    //Variable que declara el tiempo de espera
    private static final long SPLASH_SCREEN_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Objeto task que luego se usa en el timer
        TimerTask task = new TimerTask() {
            @Override
            //metodo run para intentar ejecutar la nueva activity
            public void run() {
                Intent mainIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(mainIntent);
                //Destruimos esta activity para prevenir
                //que el usuario retorne aqui presionando el boton Atras.
                finish();
            }
        };

        //creacion del objeto timer
        Timer timer = new Timer();
        //Uso del objeto timer que recibe la tarea a realizar y el tiempo de retraso
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
