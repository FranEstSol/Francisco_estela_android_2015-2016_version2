package com.example.fran_.syp_practica2_parada_de_threads;

import android.util.Log;

public class TareaMuyCostosa implements  Runnable{

    final static String TAG = "SYP-practica2";

    static private volatile boolean hiloInterrumpido = false;

    static public void detener (){
        hiloInterrumpido = true;
    }
    @Override
    public void run() {
        Log.i(TAG, "Tarea muy costosa iniciada");
        try {
            for (int i = 0; i < 100; i++) {
                    if (hiloInterrumpido == true) {
                        break;
                    }
                Log.i(TAG, "Tarea muy costosa en marcha...");
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Log.i(TAG, "Tarea costosa interrumpida");
            Log.i(TAG, "Con exito");
        }

        Log.i(TAG, "Tarea muy costosa finalizada");

    }
}