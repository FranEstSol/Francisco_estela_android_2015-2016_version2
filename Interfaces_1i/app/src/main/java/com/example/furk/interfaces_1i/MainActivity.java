package com.example.furk.interfaces_1i;

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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(),"Click en action_settings",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_search) {
            Toast.makeText(getApplicationContext(),"Click en action_search",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_refresh) {
            Toast.makeText(getApplicationContext(),"Click en action_refresh",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_zoom_in) {
            Toast.makeText(getApplicationContext(),"Click en action_zoom_in",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_zoom_out) {
            Toast.makeText(getApplicationContext(),"Click en action_zoom_out",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
