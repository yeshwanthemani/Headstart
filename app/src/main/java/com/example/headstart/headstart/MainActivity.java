package com.example.headstart.headstart;


import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Window;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ActionBar bar = getActionBar();
       // bar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if(bar != null){
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6600")));
        }

        TextView t  = (TextView)findViewById(R.id.textView2);
        t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), signupactivity.class);
                startActivity(i);
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

        switch(item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_youtube:
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=okVhbNJizPk"));
                startActivity(i1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }



    }

    public void login(View view)
    {
        TextView t7 =(TextView) findViewById(R.id.editText);
        String z = t7.getText().toString();
        TextView t8 =(TextView) findViewById(R.id.editText2);
        String o = t8.getText().toString();


        Databasehandler db = new Databasehandler(this);
        String h = db.logindb(z);

        int valid = 1;

        if( z.equals("") || o.equals(""))
        {
            valid =0;
            Context b1 = getApplicationContext();
            CharSequence d1 = "Enter all the details!";
            int di = Toast.LENGTH_SHORT;

            Toast t1 = Toast.makeText(b1,d1,di);
            t1.show();

        }

        if(h == null)
        {
            valid =0;
            Context c1 = getApplicationContext();
            CharSequence s1g = "Invalid user";
            int di = Toast.LENGTH_SHORT;

            Toast t1 = Toast.makeText(c1,s1g,di);
            t1.show();
        }
        else if(o.equals(h) && valid ==1)
        {
            Databasehandler.login = true;
            Databasehandler.phone = z;

            Intent i = new Intent(this,Kodekrypt.class);

            startActivity(i);
        }
        else
        {
            Context c1 = getApplicationContext();
            CharSequence s1g = "Invalid user";
            int dl = Toast.LENGTH_SHORT;

            Toast t1 = Toast.makeText(c1,s1g,dl);
            t1.show();
        }
    }



    public void hell(View view)
    {
        Intent i = new Intent(this,Kodekrypt.class);
        startActivity(i);
    }
}
