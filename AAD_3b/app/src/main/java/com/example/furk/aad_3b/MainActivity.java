package com.example.furk.aad_3b;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String prefs = "My preferences";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        final EditText editTextDni = (EditText) findViewById(R.id.editTextDni);
        final EditText editTextNacimiento = (EditText) findViewById(R.id.editTextNacimiento);

        final RadioButton radioButtonMan = (RadioButton) findViewById(R.id.radioButtonMan);
        final RadioButton radioButtonWoman = (RadioButton) findViewById(R.id.radioButtonWoman);

        Button enviar = (Button) findViewById(R.id.button);
        Button leer =(Button) findViewById(R.id.button2);

        //Creamos el intentn para lanzar la segunda activity
        final Intent i = new Intent(this, Main2Activity.class);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos o recuperamos el objeto de preferencias con el nombre declarado arriba
                SharedPreferences mySharedPreferences = getSharedPreferences(prefs, Activity.MODE_PRIVATE);

                //Obtenemos un editor para modificar las preferencias desde el objeto mySharedPreferences
                //creado arriba y con el metodo edit
                SharedPreferences.Editor editor = mySharedPreferences.edit();

                //Guardamos los valores
                editor.putString("nombreValor", editTextNombre.getText().toString());
                editor.putString("DniValor", editTextDni.getText().toString());
                editor.putString("fechavalor", editTextNacimiento.getText().toString());
                if (radioButtonMan.isChecked()) {
                    editor.putString("sexoValor", "Hombre");
                } else if (radioButtonWoman.isChecked()) {
                    editor.putString("sexoValor", "Mujer");
                } else {
                    editor.putString("sexoValor", "No seleccionado sexo");
                }

                //Guardamos los cambios
                editor.commit();

                //Iniciamos la segunda activity
                startActivity(i);

            }
        });

        leer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Iniciamos la segunda activity
                startActivity(i);

            }
        });

    }
}
