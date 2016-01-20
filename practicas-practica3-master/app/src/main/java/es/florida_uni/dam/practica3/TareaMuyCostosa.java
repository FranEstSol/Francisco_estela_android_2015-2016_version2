package es.florida_uni.dam.practica3;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class TareaMuyCostosa implements Runnable{

    public final static int MSG_TAREA_FINALIZADA = 1;

    final static String TAG = "SYP-practica3";

    volatile boolean interrumpido = false;

    MainActivity actividadPadre;
    Handler handler;

    public TareaMuyCostosa(MainActivity actividadPadre, Handler handler){
        this.actividadPadre = actividadPadre;
        this.handler = handler;
    }

    @Override
    public void run(){
        Log.i(TAG, "Tarea muy costosa iniciada");

        try {
            for(int i=0;i<100;i++){
                if(interrumpido) return;
                Log.i(TAG, "Tarea muy costosa en marcha...");
                mostrarProgreso(i);
                Thread.sleep(200);
            }
            Log.i(TAG, "Tarea muy costosa finalizada");
            notificarFinalizacion();
        }catch(InterruptedException e){
            return;
        }

        Log.i(TAG, "Tarea muy costosa finalizada");
    }

    // TODO: Mostrar el progreso en la barra principal
    // Debéis hacerlo utilizando runOnUIThread o enviando un runnable
    private void mostrarProgreso(final int progreso) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                actividadPadre.barraProgreso.setProgress(progreso);
            }
        };
        //Enviando el runnable por medio del handler
        handler.post(runnable);

        //Enviando el runnable por medio del runOnUiThread
        //actividadPadre.runOnUiThread(runnable);

    }

    // TODO: Avisar de la finalización de la tarea
    // Debéis hacerlo enviando un mensaje a la actividad principal
    // No utilices runnables aquí
    private void notificarFinalizacion(){
        // Cambiado a "Message.obtain" a petion en la tutoria //
        Message message = Message.obtain(actividadPadre.handler, MSG_TAREA_FINALIZADA);
        handler.sendMessage(message);


        // Metodo menos correcto, pero funciona //
        /*
        Message message = new Message();
        message.what = MSG_TAREA_FINALIZADA;
        handler.sendMessage(message);
        */
    }

    synchronized public void cancel(){
        if(interrumpido) return;
        interrumpido = true;
        Thread.currentThread().interrupt();
    }
}
