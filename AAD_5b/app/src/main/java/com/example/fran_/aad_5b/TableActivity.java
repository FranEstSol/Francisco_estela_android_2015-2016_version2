package com.example.fran_.aad_5b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {

    private MyDBAdapter dbAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();
        listView = (ListView) findViewById(R.id.listView);

        //Recojemos los datos enviados desde el "StartEmptyFragment" los asignamos a unas nuevas
        //variables y lo imprimimos por log
        Bundle bundle = getIntent().getExtras();
        String seleccionSuperior = bundle.getString("seleccionSuperior");
        String seleccionInferior = bundle.getString("seleccionInferior");
        String busqueda = bundle.getString("busqueda");

        if(seleccionInferior.equals("ciclo") || seleccionInferior.equals("curso")){
            ArrayList<String> lista = dbAdapter.recuperarConFiltro(seleccionSuperior, seleccionInferior,busqueda);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);

            listView.setAdapter(adapter);
        }
        else {
            ArrayList<String> lista = dbAdapter.recuperarTodo(seleccionSuperior);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);

            listView.setAdapter(adapter);
        }



    }
}
