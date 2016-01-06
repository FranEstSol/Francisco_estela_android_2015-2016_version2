package com.example.fran_.aad_5b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class LeerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer);

        final RadioButton rButtonLeerAlumno = (RadioButton) findViewById(R.id.rButtonLeerAlumno);
        final RadioButton rButtonLeerProfesor = (RadioButton) findViewById(R.id.rButtonLeerProfesor);
        final RadioButton rButtonLeerTodo = (RadioButton) findViewById(R.id.rButtonLeerTodo);

        final RadioButton rButtonLeerCiclo = (RadioButton) findViewById(R.id.rButtonLeerCiclo);
        final RadioButton rButtonLeerCurso = (RadioButton) findViewById(R.id.rButtonLeerCurso);
        final EditText filtroBusqueda = (EditText)findViewById(R.id.editTextFiltroBusqueda);

        final Button buttonLeer = (Button) findViewById(R.id.buttonLeer);

        buttonLeer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String seleccionSuperior = "";
                String seleccionInferior = "";

                String busqueda = filtroBusqueda.getText().toString();

                if (rButtonLeerCiclo.isChecked()) {
                    if (rButtonLeerAlumno.isChecked()) {
                        seleccionInferior = "ciclo";
                        seleccionSuperior = "alumno";
                        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
                        intent.putExtra("seleccionInferior", seleccionInferior);
                        intent.putExtra("seleccionSuperior", seleccionSuperior);
                        intent.putExtra("busqueda", busqueda);
                        startActivity(intent);
                    }
                    else if (rButtonLeerProfesor.isChecked()) {
                        seleccionInferior = "ciclo";
                        seleccionSuperior = "profesor";
                        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
                        intent.putExtra("seleccionInferior", seleccionInferior);
                        intent.putExtra("seleccionSuperior", seleccionSuperior);
                        intent.putExtra("busqueda", busqueda);
                        startActivity(intent);
                    }
                    else {
                        seleccionInferior = "ciclo";
                        seleccionSuperior = "todo";
                        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
                        intent.putExtra("seleccionInferior", seleccionInferior);
                        intent.putExtra("seleccionSuperior", seleccionSuperior);
                        intent.putExtra("busqueda", busqueda);
                        startActivity(intent);
                    }
                }
                else if (rButtonLeerCurso.isChecked()) {
                    if (rButtonLeerAlumno.isChecked()) {
                        seleccionInferior = "curso";
                        seleccionSuperior = "alumno";
                        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
                        intent.putExtra("seleccionInferior", seleccionInferior);
                        intent.putExtra("seleccionSuperior", seleccionSuperior);
                        intent.putExtra("busqueda", busqueda);
                        startActivity(intent);
                    }
                    else if (rButtonLeerProfesor.isChecked()) {
                        seleccionInferior = "curso";
                        seleccionSuperior = "profesor";
                        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
                        intent.putExtra("seleccionInferior", seleccionInferior);
                        intent.putExtra("seleccionSuperior", seleccionSuperior);
                        intent.putExtra("busqueda", busqueda);
                        startActivity(intent);
                    }
                    else {
                        seleccionInferior = "curso";
                        seleccionSuperior = "todo";
                        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
                        intent.putExtra("seleccionInferior", seleccionInferior);
                        intent.putExtra("seleccionSuperior", seleccionSuperior);
                        intent.putExtra("busqueda", busqueda);
                        startActivity(intent);
                    }
                }
                else {
                    if (rButtonLeerAlumno.isChecked()) {
                        seleccionInferior = "sinFiltro";
                        seleccionSuperior = "alumno";
                        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
                        intent.putExtra("seleccionInferior", seleccionInferior);
                        intent.putExtra("seleccionSuperior", seleccionSuperior);
                        intent.putExtra("busqueda", busqueda);
                        startActivity(intent);
                    }
                    else if (rButtonLeerProfesor.isChecked()) {
                        seleccionInferior = "sinFiltro";
                        seleccionSuperior = "profesor";
                        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
                        intent.putExtra("seleccionInferior", seleccionInferior);
                        intent.putExtra("seleccionSuperior", seleccionSuperior);
                        intent.putExtra("busqueda", busqueda);
                        startActivity(intent);
                    }
                    else {
                        seleccionInferior = "sinFiltro";
                        seleccionSuperior = "todo";
                        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
                        intent.putExtra("seleccionInferior", seleccionInferior);
                        intent.putExtra("seleccionSuperior", seleccionSuperior);
                        intent.putExtra("busqueda", busqueda);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
