package com.example.furk.interfaces_1h;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    String selected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DATOS
        //Creamos la Array de contactos
        String[] contactos = new String[]{"Andres", "Magda", "Paco", "Loli", "Daniel", "Fran",
                "Happy", "Cynthia","Pedro","Sakimi","Miguel", "Ana", "MariaJose", "Kiko", "Pepe"};
        //Transformamos la Array en un ArrayList tipo lista
        ArrayList<String> listaContactos = new ArrayList<String>(Arrays.asList(contactos));
        //Creamos un adapter de strings al cual le metemos el contexto (this), un textView desde la clase R y la propia lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaContactos);

        //INTERFAZ
        //creacion del listView y le damos el adapter.
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        //Esto permite que se pueda hacer longClick en los elementos
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        //Creamos el menu con el inflater
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        //Una String, que usaremos para el nombre del contacto seleccionado
        String selectedWord=null;
        //Mediante el AdapterContextInfo conseguimos informacion extra y la insertamos en "info"
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        //del TextView, cogemos la informacion del targetView que lo convertimos a texto y a String
        //y lo aplicamos a "selectedWord"
        selectedWord = ((TextView) info.targetView).getText().toString();
        //Se pone como titulo
        menu.setHeaderTitle(selectedWord);
        //Se aplica a una variable que esta arriba para poder usarla abajo
        selected = selectedWord;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //Casos del menu segun que opcion elegimos
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"pulsado '" + selected + "'. Ver pulsado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"pulsado '" + selected + "'. Eliminar pulsado", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}
