package com.example.furk.programacion_03;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class StartEmptyFragment extends Fragment {

    final String TAG = "Examen";
    String getNombre=null;
    String getEdad=null;

    public StartEmptyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start_empty, container, false);

        final TextView textViewNombre = (TextView)view.findViewById(R.id.editTextNombre);
        final TextView textViewEdad = (TextView)view.findViewById(R.id.editTextEdad);

        Button buttonPlay = (Button) view.findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nombre = textViewNombre.getText().toString();
                String edad = textViewEdad.getText().toString();

                Intent mainIntent = new Intent(getActivity(),MainActivity.class);
                mainIntent.putExtra("nombre", nombre);
                mainIntent.putExtra("edad", edad);
                startActivity(mainIntent);
            }
        });
        return view;
    }




    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



}
