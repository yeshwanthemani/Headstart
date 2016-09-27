package com.example.headstart.headstart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Kodekrypt extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kodekrypt);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if(bar != null){
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6600")));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kodekrypt, menu);
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
    public void register(View view)
    {
        if(Databasehandler.login == true) {
            Databasehandler db2 = new Databasehandler(this);
            db2.addkodekrypt(Databasehandler.phone);

            Intent i3 = new Intent(this, Kodekryptsuccess.class);
            startActivity(i3);
        }
        else
        {
            Context c3 = getApplicationContext();
            CharSequence s2g = "Please Login";
            int dv = Toast.LENGTH_SHORT;

            Toast t1 = Toast.makeText(c3,s2g,dv);
            t1.show();
        }

    }
}
