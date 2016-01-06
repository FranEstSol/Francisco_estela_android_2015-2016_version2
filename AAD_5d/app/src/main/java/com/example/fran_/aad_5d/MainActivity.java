package com.example.fran_.aad_5d;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    static final String PROVIDER_NAME = "com.android.contacts";
    static final String URL = "content://" + PROVIDER_NAME + "/contacts";
    static final Uri contentUri = Uri.parse(URL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLeer = (Button) findViewById(R.id.buttonLeer);
        Button buttonInsertar = (Button) findViewById(R.id.buttonInsertar);

        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "My House Party");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "My Beach House");
                calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "A Pig Roast on the Beach");

                GregorianCalendar calDate = new GregorianCalendar(2012, 7, 15);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        calDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        calDate.getTimeInMillis());

                startActivity(calIntent);
            }
        });



    }
}