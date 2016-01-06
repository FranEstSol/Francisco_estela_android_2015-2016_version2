package com.example.furk.aad_3a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Strings
        final String file_name = "fichero_3a_test.txt";
        final String lineSep = System.getProperty("line.separator");

        //Campo de escritura
        final EditText editText = (EditText) findViewById(R.id.editText);

        //Campo de lectura de texto
        final TextView textView = (TextView) findViewById(R.id.textView);

        //Botones
        Button readButton = (Button) findViewById(R.id.readButton);
        Button writeButton = (Button) findViewById(R.id.writeButton);
        Button cleanButton = (Button) findViewById(R.id.cleanButton);

        //Boton de escritura
        writeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Creamos un fichero de salida que es privado a esta aplicación
                try {
                    //Creamos objeto fileOutputStream y le damos el nombre del archivo y el contexto
                    //(MODE_APPEND sirve para concatenar
                    FileOutputStream fos = openFileOutput(file_name, Context.MODE_APPEND);
                    //Creamos objeto DataOutputStream y le damos el FileOutputStream
                    DataOutputStream dos = new DataOutputStream(fos);
                    //Creamos una nueva String y le asignamos lo escrito en el campo de texto
                    //transformado en String, por si acaso y le añadimos al final un cambio de linea
                    String textField = new String(editText.getText().toString()+lineSep);
                    //damos la orden al DataOutputStream de escribir los bytes que hayan en la variable "textField"
                    dos.writeBytes(textField);
                    //Cerramos el FileOutputStream
                    fos.close();
                    //Cerramos el FileOutputStream
                    dos.close();
                    //Mostramos un toast para asegurarnos de que ha recibido la orden
                    Toast.makeText(getApplicationContext(), "Escrito:  " + textField, Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //Boton de lectura
        readButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Leemos el fichero
                try {
                    //Creamos objeto FileInputStream y le damos el nombre del archivo
                    FileInputStream fin = openFileInput(file_name);
                    //Creamos objeto DataInputStream y le damos el FileInputStream
                    DataInputStream dis = new DataInputStream(fin);
                    //Creamos un buffer de bytes que tendra 1000 bytes
                    byte[] buff = new byte[1000];
                    //Leemos en el DataInputStream la cantidad de bytes que indica el buff
                    dis.read(buff);
                    //Asignamnos el texto en el textView
                    textView.setText(new String(buff));
                    //Cerramos el FileInputStream
                    fin.close();
                    //Cerramos el DataInputStream
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //Boton de limpieza
        cleanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    //Creamos objeto fileOutputStream y le damos el nombre del archivo y el contexto
                    //(MODE_PRIVATE sustituye el texto actual por el nuevo
                    FileOutputStream fos = openFileOutput(file_name, Context.MODE_PRIVATE);
                    //Creamos objeto DataOutputStream y le damos el FileOutputStream
                    DataOutputStream dos = new DataOutputStream(fos);
                    //Creamos una nueva String vacio para dejar el fichero vacio
                    String textField = "";
                    //damos la orden al DataOutputStream de escribir los bytes que hayan en la variable "textField"
                    dos.writeBytes(textField);
                    //Cerramos el FileOutputStream
                    fos.close();
                    //Cerramos el FileOutputStream
                    dos.close();
                    //Mostramos un toast para asegurarnos de que ha recibido la orden
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
