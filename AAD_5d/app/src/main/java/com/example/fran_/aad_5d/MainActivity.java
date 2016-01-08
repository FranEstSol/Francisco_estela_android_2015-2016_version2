package com.example.fran_.aad_5d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    static final String PROVIDER_NAME = "com.android.calendar";
    static final String URL = "content://" + PROVIDER_NAME + "/events";
    static final Uri CONTENT_URI = Uri.parse(URL);

    private static final String TAG = "testCalendar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLeer = (Button) findViewById(R.id.buttonLeer);
        Button buttonInsertar = (Button) findViewById(R.id.buttonInsertar);


        //Boton de insertar evento
        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Creamos un intent con la accion de insertar
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                //Le asignamos un tipo al intent (tipo event)
                calIntent.setType("vnd.android.cursor.item/event");
                //Le damos los extras como "titulo" "localizacion" y "descripccion" (extras basicos)
                calIntent.putExtra(CalendarContract.Events.TITLE, "Fiesta en mi pueblo");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Mi casa del pueblo");
                calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "Tendremos chuletas y cerveza");

                //Le asignamos una fecha a un tipo de calendario concreto
                GregorianCalendar calDate = new GregorianCalendar(2015, 7, 15);
                //Le damos mas extras que indican la duracion, hora de inicio y hora de finalizacion
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, calDate.getTimeInMillis());

                //Iniciamos la activity con nuestro intent
                startActivity(calIntent);
            }
        });

        //Boton que lee todos los eventos
        buttonLeer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Creamos un ContentResolver, le asignamos la URI y otra informacion y se lo asignamos a un cursor
                ContentResolver cr = getContentResolver();
                Cursor cursor = cr.query(CONTENT_URI, null, null, null, null);

                //Comprobamos que el cursor no sea null y que sea posible moverlo al primer lugar
                if (cursor != null && cursor.moveToFirst()){

                    //Variable indice para el cursor, que recorrera los elementos, cogiendo la columna "Tittle"
                    int indice = cursor.getColumnIndex(CalendarContract.Events.TITLE);
                    //Creamos un Array de Strings que reciba el contador del cursor
                    String[] values = new String[cursor.getCount()];
                    //Realizaremos este "do" mientras el cursor tenga siguiente
                    do{
                        //Recuperamos el "tittle"
                        String name = cursor.getString(indice);
                        //Guardamos en el Array
                        values[cursor.getPosition()] = cursor.getPosition() + " // (" + name +")";
                        Log.v(TAG, "log= " + name);
                    }
                    while (cursor.moveToNext());

                    //Añadimos los resultados del Array a un listView
                    ListView lv = (ListView)findViewById(R.id.listView);

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1, values);

                    lv.setAdapter(adapter);

                }





                /*Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri.Builder uri = CalendarContract.Events.CONTENT_URI.buildUpon();
                uri.appendPath(Long.toString(155));
                intent.setData(uri.build());
                startActivity(intent);*/


            }
        });
    }

}