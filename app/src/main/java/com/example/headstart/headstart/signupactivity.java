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


public class signupactivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if(bar != null){
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6600")));
        }
        getSupportActionBar().setTitle("Headstart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signupactivity, menu);
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
    public void signup(View view)
    {
        EditText e1 = (EditText)findViewById(R.id.editText3);
        String a = e1.getText().toString();
        EditText e2 = (EditText) findViewById(R.id.editText8);
        String b = e2.getText().toString();
        EditText e3 = (EditText) findViewById(R.id.editText7);
        String c = e3.getText().toString();

        EditText e4 = (EditText)findViewById(R.id.editText4);
        String d = e4.getText().toString();
        EditText e5 = (EditText) findViewById(R.id.editText5);
        String e = e5.getText().toString();
        EditText e6 = (EditText) findViewById(R.id.editText6);
        String f = e6.getText().toString();

        int valid = 1;

        if(a.equals("") || b.equals("") || c.equals("") || d.equals("") || e.equals("") || f.equals(""))
        {
            valid = 0;
            Context h2 = getApplicationContext();
            CharSequence n2 = "Fill all the details!! ";
            int dv = Toast.LENGTH_SHORT;

            Toast t1 = Toast.makeText(h2,n2,dv);
            t1.show();
        }

        if(!b.equals(c))
        {
            valid = 0;
            Context c1 = getApplicationContext();
            CharSequence s1g = "Passwords dont match";
            int dv = Toast.LENGTH_SHORT;

            Toast t1 = Toast.makeText(c1,s1g,dv);
            t1.show();
        }
        if(d.length() != 10)
        {
            valid = 0;
            Context h1 = getApplicationContext();
            CharSequence n1 = "Enter a valid Mobile Number";
            int dv = Toast.LENGTH_SHORT;

            Toast t1 = Toast.makeText(h1,n1,dv);
            t1.show();

        }

        if (valid ==1 )
        {
            User u = new User(a, c, d, e, f);
            Databasehandler db1 = new Databasehandler(this);
            db1.adduser(u);
            Databasehandler.login = true;
            Databasehandler.phone = d;

            Intent i = new Intent(this,Kodekrypt.class);

            startActivity(i);
        }
    }
}
