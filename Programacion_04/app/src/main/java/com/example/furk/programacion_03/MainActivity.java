package com.example.furk.programacion_03;

import android.app.Activity;
import android.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;


public class MainActivity extends Activity implements ListFragment.ListFragmentListener{

    String TAG = "examen";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Comprobamos que la activity este usando un fragment container que no sea null
        //Dispositivo grande
        if (findViewById(R.id.fragment_container) != null) {
            Toast.makeText(this,"TOSTADA GRANDE AL PODER!", Toast.LENGTH_LONG).show();
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

            //Creamos un nuevo fragment
            StartEmptyFragment emptyFragment = new StartEmptyFragment();

            //Recojemos los datos enviados desde el "StartEmptyFragment" los asignamos a unas nuevas
            //variables y lo imprimimos por log
            Bundle bundle = getIntent().getExtras();
            String nombre = bundle.getString("nombre");
            String edad = bundle.getString("edad");
            Log.v(TAG, "recibido nombre: " + nombre + " y edad: " + edad);

            //Recordatorio: el fragment lista se asigna de forma automatica "mediante el manifest"
            //ya que se trata de un fragment statico y no dinamico.

            //Añadimos el fragment creado en nuestro contenedor de fragments dinamicos y lo lanzamos
            getFragmentManager().beginTransaction().add(R.id.fragment_container, emptyFragment).commit();
        }

        //Dispositivo pequeño
        else {
            Toast.makeText(this,"TOSTADA PEQUEÑA AL PODER!", Toast.LENGTH_LONG).show();
        }
    }

    //Metodo que recibe los clicks en el menu de juego
    public void onListSelected(int position){
        //Perfil
        if (position == 0){
            Toast.makeText(this,"El perfil todavia no esta implementado", Toast.LENGTH_LONG).show();
        }
        //Juego
        else if (position == 1) {
            if(findViewById(R.id.fragment_container) != null){
                Toast.makeText(this,"1", Toast.LENGTH_LONG).show();
                // Create fragment and give it an argument specifying the article it should show
                //Creamos un nuevo fragment
                GameFragment gameFragment = new GameFragment();
                //Creamos un objeto "transaction" que recoge el fragment manager y inicia la transaccion
                FragmentTransaction transaction = getFragmentManager().beginTransaction();


                //Remplaza lo que haya en el contenedor por el "gameFragment"
                transaction.replace(R.id.fragment_container, gameFragment);
                //Esto permite que el usuario pueda volver atras

            /* ------ */
                //Esta parte es un problema ya que manda todos los fragments creados detras de forma que
                //si inicias 20 juegos nuevos, tienes 21 fragments escondidos detras
            /* ------ */
                transaction.addToBackStack(null);

                //Lanzamos la transaccion
                transaction.commit();

            }
            else {
                Toast.makeText(this,"2", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MainActivitySmall.class);
                startActivity(intent);
            }

        }
        //Instrucciones
        else if (position == 2){
            Toast.makeText(this,"Las instrucciones todavia no esta implementadas", Toast.LENGTH_LONG).show();
        }
        //Informacion
        else if (position == 3){
            Toast.makeText(this,"La informacion todavia no esta implementadas", Toast.LENGTH_LONG).show();
        }
        //else de seguridad. Esto no tendria que pasar nunca
        else{
            Toast.makeText(this,"No se donde habras hecho click, pero esto no tendria que pasar", Toast.LENGTH_LONG).show();
        }
    }
}
