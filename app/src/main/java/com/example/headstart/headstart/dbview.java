package com.example.headstart.headstart;

import android.app.ListActivity;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.ListActivity;

public class dbview extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Databasehandler db = new Databasehandler(this);
        Context c = getApplicationContext();
        db.addquestions(getApplicationContext());

        ArrayList<String> x = db.dbview();
        final ListView l = getListView();
        setListAdapter(new ArrayAdapter<String>(c,R.layout.activity_dbview,R.id.text11,x));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dbview, menu);
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
