package com.example.furk.interfaces_1d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaracion de objetos
        final LinearLayout bot = (LinearLayout) findViewById(R.id.downLayout);
        final LinearLayout top = (LinearLayout) findViewById(R.id.upLayout);

        final CheckBox hiddenMsg = (CheckBox) findViewById(R.id.hiddenMessageCheckBox);

        final ToggleButton toggleButton1 = (ToggleButton) findViewById(R.id.backgroundButton);
        final ToggleButton toggleButton2 = (ToggleButton) findViewById(R.id.lettersButton);

        final TextView hiddenText = (TextView) findViewById(R.id.hiddenTextView);
        final TextView longText = (TextView) findViewById(R.id.longClickTextView);
        final TextView ratingTV = (TextView) findViewById(R.id.ratingTV);

        final RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);

        Context context = getApplicationContext();

        //Variables
        CharSequence text = "Gracias por el click largo!";

        int duration = Toast.LENGTH_SHORT;

        //objetos que usan variables
        final Toast toast = Toast.makeText(context, text, duration);

        //Interruptor que cambia el fondo
        toggleButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton1.isChecked()){
                    bot.setBackgroundColor(0xffff0000);
                }
                else {
                    bot.setBackgroundColor(0x00000000);
                }
            }
        });

        //Interruptor que cambia sus propias letras
        toggleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton2.isChecked()) {
                    toggleButton2.setTextColor(0xffffffff);
                } else {
                    toggleButton2.setTextColor(0xff000000);
                }
            }
        });

        //check que muestra un mensaje oculto
        hiddenMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hiddenMsg.isChecked()) {
                    hiddenMsg.setText("ocultar!");
                    hiddenText.setVisibility(View.VISIBLE);
                } else {
                    hiddenMsg.setText("mostrar");
                    hiddenText.setVisibility(View.INVISIBLE);
                }
            }
        });

        //Texto de click largo que muestra un toast
        longText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                toast.show();
                return true;
            }
        });

        //Sistema de estrellas
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged (RatingBar ratingBar,float rating,boolean fromUser){
                //(int) rating sirve para cambiar el float a un integer para facilitar la lectura
                ratingTV.setText((int) rating +" / "+ ratingBar.getMax());
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
