package com.example.fran_.aad_5b;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class EliminarActivity extends AppCompatActivity {

    private MyDBAdapter myDBAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        final Button buttonEliminar = (Button)findViewById(R.id.buttonEliminar);
        final EditText editTextEliminar = (EditText) findViewById(R.id.editTextEliminar);
        final RadioButton rButtonAlumno = (RadioButton) findViewById(R.id.option1);
        final RadioButton rButtonProfesor = (RadioButton) findViewById(R.id.option2);
        final TextView opcionSeleccionada = (TextView) findViewById(R.id.textViewSeleccionado);

        myDBAdapter = new MyDBAdapter(this);
        myDBAdapter.open();

        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String eliminar = editTextEliminar.getText().toString();
                if(rButtonAlumno.isChecked()){
                    myDBAdapter.eliminarRegistro(eliminar , "alumno");
                }
                else if (rButtonProfesor.isChecked()){
                    myDBAdapter.eliminarRegistro(eliminar , "profesor");
                }
                else {
                    opcionSeleccionada.setText("Selecciona una opcion");
                }
            }
        });
    }
}
