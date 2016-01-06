package com.example.furk.programacion_02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DATOS
        //Creamos la Array de opciones
        String[] opciones = new String[]{"PERFIL", "JUEGO", "INSTRUCCIONES", "INFO"};
        //Transformamos la Array en un ArrayList tipo lista
        ArrayList<String> listaOpciones = new ArrayList<String>(Arrays.asList(opciones));
        //Creamos nuestro propio adapter al cual le metemos el contexto (this) y el ArrayList de opciones
        MenuAdapter adapter = new MenuAdapter(this,listaOpciones);

        //INTERFAZ
        //creacion del listView
        final ListView listView = (ListView) findViewById(R.id.listView);
        //Le damos al listView el adapter
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
