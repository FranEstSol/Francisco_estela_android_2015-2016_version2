package com.example.furk.programacion_03;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivitySmall extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_small);

        GameFragment gameFragment = new GameFragment();
        //Creamos un objeto "transaction" que recoge el fragment manager y inicia la transaccion
        FragmentTransaction transaction = getFragmentManager().beginTransaction();


        //Remplaza lo que haya en el contenedor por el "gameFragment"
        transaction.replace(R.id.fragment_container_full_screen, gameFragment);
        //Esto permite que el usuario pueda volver atras

            /* ------ */
        //Esta parte es un problema ya que manda todos los fragments creados detras de forma que
        //si inicias 20 juegos nuevos, tienes 21 fragments escondidos detras
            /* ------ */
        transaction.addToBackStack(null);

        //Lanzamos la transaccion
        transaction.commit();
    }
}
