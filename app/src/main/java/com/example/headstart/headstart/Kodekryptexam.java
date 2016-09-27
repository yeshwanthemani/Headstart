package com.example.headstart.headstart;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Kodekryptexam extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kodekryptexam);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if(bar != null){
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF6600")));
        }


        Databasehandler db2 = new Databasehandler(this);
        // db2.addquestions(getApplicationContext());
        db2.populate();
        TextView tex;
        String qid, aid, bid, cid, did;

        int ques[] = {R.id.t1, R.id.t2, R.id.t3, R.id.t4, R.id.t5, R.id.t6, R.id.t7, R.id.t8, R.id.t9, R.id.t10, R.id.t11, R.id.t12, R.id.t13, R.id.t14, R.id.t15};
        int temp;
        for (int ki = 0; ki < ques.length; ki++) {
            temp = ki + 1;
            tex = (TextView) findViewById(ques[ki]);
            tex.setText(temp + "." + Databasehandler.question[ki]);

        }

        int grp[] = {R.id.gr1, R.id.gr2, R.id.gr3, R.id.gr4, R.id.gr5, R.id.gr6, R.id.gr7, R.id.gr8, R.id.gr9, R.id.gr10, R.id.gr11, R.id.gr12, R.id.gr13, R.id.gr14, R.id.gr15};
        RadioGroup group1;

        for (int kj = 0; kj < 15; kj++) {
            group1 = (RadioGroup) findViewById(grp[kj]);
            ((RadioButton) group1.getChildAt(0)).setText(Databasehandler.A[kj]);
            ((RadioButton) group1.getChildAt(1)).setText(Databasehandler.B[kj]);
            ((RadioButton) group1.getChildAt(2)).setText(Databasehandler.C[kj]);
            ((RadioButton) group1.getChildAt(3)).setText(Databasehandler.D[kj]);

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kodekryptexam, menu);


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

    public void examfinish(View view) {
        int id;
        RadioGroup g1;
        RadioButton r;
        int kkk;
        String ch ;

        int grpp[] = {R.id.gr1, R.id.gr2, R.id.gr3, R.id.gr4, R.id.gr5, R.id.gr6, R.id.gr7, R.id.gr8, R.id.gr9, R.id.gr10, R.id.gr11, R.id.gr12, R.id.gr13, R.id.gr14, R.id.gr15};


        AlertDialog a = new AlertDialog.Builder(Kodekryptexam.this).create();
        a.setTitle("Finish Exam?");
        a.setMessage("Are you sure to finish the exam?");
        final Context c = getApplicationContext();
        a.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface d, int w) {
                Intent i = new Intent(c, Kodekryptexamfinish.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                c.startActivity(i);
            }
        });


        a.show();

        for (int ko = 0; ko < 15; ko++) {
            ch = "G";
            g1 = (RadioGroup) findViewById(grpp[ko]);
            id = g1.getCheckedRadioButtonId();
            r = (RadioButton) findViewById(id);
            kkk = g1.indexOfChild(r);
            if (kkk == 0)
                ch = "A";

            else if (kkk == 1)
                ch = "B";
            else if (kkk == 2)
                ch = "C";
            else if (kkk == 3)
                ch = "D";


            if (Databasehandler.answer[ko].equals(ch)) {
                Databasehandler.marks++;

            }


        }


    }
}



