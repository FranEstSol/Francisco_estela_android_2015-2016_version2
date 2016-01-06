package com.example.furk.interfaces_1j;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.widget.Toast;


public class SettingsActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Cargamos el recurso de las preferencias desde el fichero de recursos XML
        addPreferencesFromResource(R.xml.preferences_screen);

        //Creamos un objeto SharedPreferences al cual le "asignamos" nuestro archivo de recursos xml
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);



        //Registramos el listener al objeto SharedReferences recien creado
        SharedPreferences.OnSharedPreferenceChangeListener listener;
        listener= new SharedPreferences.OnSharedPreferenceChangeListener(){

            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {

                //Giro automatico
                if (key.equals("giro_pref")){
                    CheckBoxPreference checkPref = (CheckBoxPreference) findPreference("giro_pref");
                    if(checkPref.isChecked()){
                        checkPref.setChecked(true);
                        Toast.makeText(getApplicationContext(),"Check ON", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        checkPref.setChecked(false);
                        Toast.makeText(getApplicationContext(),"Check OFF", Toast.LENGTH_SHORT).show();
                    }
                }
                //Tiempo de espera
                if (key.equals("tiempo_pref")){
                    ListPreference listPref = (ListPreference) findPreference("tiempo_pref");
                    //Creamos un String al cual le asignamos el valor del listPref seleccionado
                    String currValue = listPref.getValue();
                    Toast.makeText(getApplicationContext(),currValue, Toast.LENGTH_SHORT).show();
                }
                //Salvapantallas
                else if (key.equals("salvapantallas_pref")){
                    SwitchPreference switchPref = (SwitchPreference) findPreference("salvapantallas_pref");
                    if(switchPref.isChecked()){
                        switchPref.setChecked(true);
                        Toast.makeText(getApplicationContext(),"Switch ON", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        switchPref.setChecked(true);
                        Toast.makeText(getApplicationContext(),"Switch OFF", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

        prefs.registerOnSharedPreferenceChangeListener(listener);

    }
}
