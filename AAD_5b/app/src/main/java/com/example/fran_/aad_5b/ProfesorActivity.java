package com.example.fran_.aad_5b;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfesorActivity extends AppCompatActivity {

    private MyDBAdapter myDBAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);

        Button buttonAñadirProfesor = (Button)findViewById(R.id.buttonAñadirProfesor);
        final EditText nombreProfesor = (EditText) findViewById(R.id.editTextNombreProfesor);
        final EditText edadProfesor = (EditText) findViewById(R.id.editTextEdadProfesor);
        final EditText cicloProfesor = (EditText) findViewById(R.id.editTextCicloProfesor);
        final EditText cursoProfesor = (EditText) findViewById(R.id.editTextCursoProfesor);
        final EditText despachoProfesor = (EditText) findViewById(R.id.editTextDespacho);

        myDBAdapter = new MyDBAdapter(this);
        myDBAdapter.open();

        buttonAñadirProfesor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String camposProfesor[] = {
                        nombreProfesor.getText().toString(),
                        edadProfesor.getText().toString(),
                        cicloProfesor.getText().toString(),
                        cursoProfesor.getText().toString(),
                        despachoProfesor.getText().toString()
                };
                myDBAdapter.insertarProfesor(camposProfesor[0], camposProfesor[1], camposProfesor[2], camposProfesor[3], camposProfesor[4]);
            }
        });
    }
}
