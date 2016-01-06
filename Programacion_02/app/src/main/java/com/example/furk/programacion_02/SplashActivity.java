package com.example.furk.programacion_02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    //Variable que declara el tiempo de espera
    private static final long SPLASH_SCREEN_DELAY = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Objeto task que luego se usa en el timer
        TimerTask task = new TimerTask() {
            @Override
            //metodo run para intentar ejecutar la nueva activity
            public void run() {
                Intent mainIntent = new Intent(getApplicationContext(),
                        MainActivity.class);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
