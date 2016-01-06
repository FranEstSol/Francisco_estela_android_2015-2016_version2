package com.example.fran_.aad_5a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlumnoActivity extends AppCompatActivity {

    private MyDBAdapter myDBAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        Button buttonAñadirAlumno = (Button)findViewById(R.id.buttonAñadirAlumno);
        final EditText nombreAlumno = (EditText) findViewById(R.id.editTextNombreAlumno);
        final EditText edadAlumno = (EditText) findViewById(R.id.editTextEdadAlumno);
        final EditText cicloAlumno = (EditText) findViewById(R.id.editTextCicloAlumno);
        final EditText cursoAlumno = (EditText) findViewById(R.id.editTextCursoAlumno);

        myDBAdapter = new MyDBAdapter(this);

        buttonAñadirAlumno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String camposAlumno[] = {
                        nombreAlumno.getText().toString(),
                        edadAlumno.getText().toString(),
                        cicloAlumno.getText().toString(),
                        cursoAlumno.getText().toString()
                };
                myDBAdapter.insertarAlumno(camposAlumno[0], camposAlumno[1], camposAlumno[2], camposAlumno[3]);
            }
        });
    }
}
