package com.example.fran_.aad_5e;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showAllRecords();
    }

    public void showAllRecords(){

        String URL = "content://com.example.fran_.aad_5e/alumnos";
        Uri alumnos = Uri.parse(URL);
        Cursor cursor = getContentResolver().query(alumnos, null, null, null, null);

        Toast.makeText(getApplicationContext(),"Cursor " + cursor.getCount(), Toast.LENGTH_LONG).show();

        if (cursor != null && cursor.moveToFirst()){
            int indice_nombre = cursor.getColumnIndex(CustomContentProvider.NOMBRE_ALUMNO);
            String[] values = new String[cursor.getCount()];
            Toast.makeText(getApplicationContext(),"Cursor " + cursor.getCount(), Toast.LENGTH_LONG).show();
            do{
                //Recuperamos el nombre
                String name = cursor.getString(indice_nombre);
                //Guardamos en el Array
                values[cursor.getPosition()] = cursor.getPosition() + " (" + name +")";
            }while (cursor.moveToNext());

            ListView lv = (ListView)findViewById(R.id.listView);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1, values);

            lv.setAdapter(adapter);

        }
    }
}