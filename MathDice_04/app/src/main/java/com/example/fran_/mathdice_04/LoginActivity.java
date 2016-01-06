package com.example.fran_.mathdice_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

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
            LoginFragment loginFragment = new LoginFragment();

            //Añadimos el fragment creado en nuestro contenedor de fragments dinamicos y lo lanzamos
            getFragmentManager().beginTransaction().add(R.id.login_container, loginFragment).commit();

        }
    }
}

