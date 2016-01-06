package com.example.furk.interfaces_1f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static String urlDir = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creacion de los objetos usados en la clase
        final EditText editText = (EditText) findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.button);

        final WebView view = (WebView) findViewById(R.id.webView);

        final Intent secondAct = new Intent(this,SecondActivity.class);

        RadioGroup radio = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton rButton1 = (RadioButton) findViewById(R.id.option1);
        final RadioButton rButton2 = (RadioButton) findViewById(R.id.option2);
        final RadioButton rButton3 = (RadioButton) findViewById(R.id.option3);

        //Activacion de JavaScript para el visualizador web
        view.getSettings().setJavaScriptEnabled(true);

        //Creacion del Toast
        final Context context = getApplicationContext();
        final CharSequence err1 = "No has seleccionado ninguna opcion!";
        final CharSequence err2 = "El campo de busqueda esta vacio!";
        final int duration = Toast.LENGTH_SHORT;

        //Boton para ir a la web
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Comprobacion de que hay algo escrito
                if ( !editText.getText().toString().equals("")){
                    //Check del RadioButton 1
                    if (rButton1.isChecked()){
                        view.loadUrl(editText.getText().toString());
                    }
                    //Check del RadioButton 2
                    else if (rButton2.isChecked()){
                        urlDir = editText.getText().toString();
                        startActivity(secondAct);
                    }
                    //Check del RadioButton 3
                    else if (rButton3.isChecked()){
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(editText.getText().toString()));
                        startActivity(i);
                    }
                    //Check en caso de que ningun radioButton este marcado
                    else {
                        final Toast toast = Toast.makeText(context,err1,duration);
                        toast.show();
                    }
                }
                else {
                    final Toast toast = Toast.makeText(context,err2,duration);
                    toast.show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
