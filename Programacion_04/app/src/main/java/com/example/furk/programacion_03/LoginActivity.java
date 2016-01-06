package com.example.furk.programacion_03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class LoginActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Comprobamos que la activity este usando un fragment container que no sea null
        if (findViewById(R.id.login_container) != null) {
            //Comprobamos que no volvamos de un estado anterior donde no sea necesario crear esto de nuevo
            if (savedInstanceState != null) {
                return;
            }

            //Creamos un nuevo fragment
            StartEmptyFragment emptyFragment = new StartEmptyFragment();


            //Añadimos el fragment creado en nuestro contenedor de fragments dinamicos y lo lanzamos
            getFragmentManager().beginTransaction().add(R.id.login_container, emptyFragment).commit();
        }

    }
}
