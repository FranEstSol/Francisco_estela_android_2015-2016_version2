package com.example.fran_.aad_5a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAlumno = (Button)findViewById(R.id.buttonAlumno);
        Button buttonProfesor = (Button)findViewById(R.id.buttonProfesor);
        Button buttonEliminar = (Button)findViewById(R.id.buttonEliminar);

        buttonAlumno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlumnoActivity.class);
                startActivity(intent);
            }
        });

        buttonProfesor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfesorActivity.class);
                startActivity(intent);
            }
        });

        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EliminarActivity.class);
                startActivity(intent);
            }
        });

    }
}
