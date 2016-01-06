package com.example.furk.programacion_03;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListFragment extends Fragment {

    //Objeto de ListFragmentListener llamado mCallback
    ListFragmentListener mCallback;
    //Metodo publico ListFragmentListener que contiene el onListSelected y le recibe una posicion
    public interface ListFragmentListener{
        public void onListSelected(int position);
    }

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            //Al asignar el fragment, inicializamos el mCallback
            mCallback = (ListFragmentListener)activity;
        }catch (ClassCastException e){
            throw  new ClassCastException (activity.toString()+"must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //DATOS
        //Creamos la Array de opciones
        String[] opciones = new String[]{"PERFIL", "JUEGO", "INSTRUCCIONES", "INFO"};
        //Transformamos la Array en un ArrayList tipo lista
        ArrayList<String> listaOpciones = new ArrayList<String>(Arrays.asList(opciones));
        //Creamos nuestro propio adapter al cual le metemos el contexto (this) y el ArrayList de opciones
        MenuAdapter adapter = new MenuAdapter(getActivity(),listaOpciones);
        //INTERFAZ
        //creacion del listView
        final ListView listView = (ListView) getActivity().findViewById(R.id.listView);
        //Le damos al listView el adapter
        listView.setAdapter(adapter);

        //INTERACCION
        //Al hacer click en un item de la listView, creamos un nuevo "nuestroListener" y lo llamamos
        listView.setOnItemClickListener(new nuestroListener());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //Al terminar volvemos mCallback null para que vuelva a su "estado natural"
        mCallback = null;
    }

    //Implementacion del listener
    //INNER CLASS (clase dentro de una clase)
    private  class nuestroListener implements AdapterView.OnItemClickListener{
        //el onItemClick recibe el AdapterView de su padre (mediante el implements) el view al que pertenece
        //la posicion donde se ha hecho click y la id del item donde se ha hecho click
        public void onItemClick (AdapterView<?> parent, View view, int position, long id){
            //String de la posicion donde se ha hecho click
            //String itemSeleccionado = (String) parent.getItemAtPosition(position);
            //Pasamos la informacion de vuelta al mCallback mediante el onListSelected y le enviamos
            //la posicion del click
            mCallback.onListSelected(position);
        }
    }

}
