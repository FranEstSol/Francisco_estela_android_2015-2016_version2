package com.example.furk.aad_3b;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main2Activity extends Activity {

    public static final String prefs = "My preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView resultado = (TextView) findViewById(R.id.textView5);

        //Creamos o recuperamos el objeto de preferencias con el nombre declarado arriba
        SharedPreferences mySharedPreferences = getSharedPreferences(prefs, Activity.MODE_PRIVATE);

        //Creamos las Strings donde asignamos los valores recibidos desde las preferencias
        String nombreValor = mySharedPreferences.getString("nombreValor","");
        String DniValor = mySharedPreferences.getString("DniValor","");
        String fechavalor = mySharedPreferences.getString("fechavalor","");
        String sexoValor = mySharedPreferences.getString("sexoValor", "");

        //Montamos el textView con los resultados
        resultado.setText("Nombre: "+nombreValor);
        resultado.append(System.getProperty("line.separator"));
        resultado.append("DNI: " + DniValor);
        resultado.append(System.getProperty("line.separator"));
        resultado.append("Fecha de nacimiento: "+fechavalor);
        resultado.append(System.getProperty("line.separator"));
        resultado.append("Sexo: "+sexoValor);
    }

}
