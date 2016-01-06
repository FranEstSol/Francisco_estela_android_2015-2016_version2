package com.example.furk.interfaces_1g;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top_menu, menu);
        // super.onCreateOptionsMenu(menu);
        //MenuItem menuItem1 = menu.add(Menu.NONE,Menu.FIRST,Menu.NONE,"Settings");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /*
             * En todos estos casos, se hacen comprobaciones para ver si el check o el radioButton
             * esta On o Off para cambiarle el estado justo despues.
             * Tras esto, se imprime el mensaje Toast
             */
            //Check exterior
            case R.id.check:
                if (item.isChecked()) {
                    item.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Has quitado el check!",
                            Toast.LENGTH_SHORT).show();
                } else if (!item.isChecked()) {
                    item.setChecked(true);
                    Toast.makeText(getApplicationContext(), "Has puesto el check",
                            Toast.LENGTH_SHORT).show();
                }
                return true;
            //Check interior
            case R.id.check2:
                if (item.isChecked()) {
                    item.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Has quitado el check!",
                            Toast.LENGTH_SHORT).show();
                } else if (!item.isChecked()) {
                    item.setChecked(true);
                    Toast.makeText(getApplicationContext(), "Has puesto el check",
                            Toast.LENGTH_SHORT).show();
                }
                return true;
            //Menu interior
            //Opcion Radiobutton 1
            case R.id.option1:
                Toast.makeText(getApplicationContext(), "opcion 1!",
                        Toast.LENGTH_SHORT).show();
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                return true;
            //Opcion Radiobutton 2
            case R.id.option2:
                Toast.makeText(getApplicationContext(), "opcion 2!",
                        Toast.LENGTH_SHORT).show();
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                return true;
            //Opcion Radiobutton 3
            case R.id.option3:
                Toast.makeText(getApplicationContext(), "opcion 3!",
                        Toast.LENGTH_SHORT).show();
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                return true;
            default: return false;
        }
    }
}
