package com.example.headstart.headstart;

import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.res.AssetManager;
import java.io.IOException;
import android.content.Context;
import java.io.InputStream;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Databasehandler extends SQLiteOpenHelper {

    static boolean login = false;
    static String phone = null ;


    static final String DBNAME = "dbheadstart";
    static final String TBNAME = "user";
    static final String KEY_NAME = "username";
    static final String KEY_PASSWORD = "password";
    static final String KEY_PHONE = "phoneno";
    static final String KEY_EMAIL = "email";
    static final String KEY_COLLEGE = "college";
    static final String KEY_ID = "id";

    static final String TBNAME1="questionsx";
    static final String KEY_I = "id1";
    static final String KEY_Q = "question";
    static final String KEY_A = "A";
    static final String KEY_B = "B";
    static final String KEY_C = "C";
    static final String KEY_D = "D";
    static final String KEY_ANSWER = "answer";

    static String question[] = new String[15];
    static String A[] = new String[15];
    static String B[] = new String[15];
    static String C[] = new String[15];
    static String D[] = new String[15];
    static String answer[] = new String[15];
    static String userans[] = new String[15];
    static int marks = 0;



    int count = 0;

    static final int VERSION = 1;

    Databasehandler(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        String create = "create table user(id integer,username text ,password text,phoneno text,email text,college text,kodekrypt text,dataaddicts text,designfreaks text,cstar text,ppt text,w3quiz text)";
        String create1 = "create table questionsx(id1 integer primary key,question text,A text,B text,C text,D text,answer text)";

        db.execSQL(create);
        db.execSQL(create1);

    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS " + TBNAME1);
        onCreate(db);
    }

    public void addquestions(Context context)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String xg = "delete from questionsx";
        Cursor c8 = db.rawQuery(xg, null);
        c8.close();

        BufferedReader r ;
        String myfile = "kcq.txt";
        AssetManager manager = context.getAssets();

        String a,b,c,d,e,f;

        try{
            r = new BufferedReader(new InputStreamReader(context.getAssets().open("kcq.txt")));



            ContentValues contentv = new ContentValues();

            int counter = 0;
            String sqs = r.readLine();
            while(sqs != null)
            {
                counter++;
                a = sqs;
                String p = r.readLine();
               // while(!p.substring(0,2).equals("A.") )
                //{
                //    a = a.concat(p);
                 //   p = r.readLine();
                //}
                b = p.substring(2);
                String q = r.readLine();
                c = q.substring(2);
                String v = r.readLine();
                d = v.substring(2);
                String x = r.readLine();
                e = x.substring(2);
                String n = r.readLine();
                f = n.substring(8);

                int i;
                i = counter;

                contentv.put(KEY_I,i);
                contentv.put(KEY_Q,a);
                contentv.put(KEY_A,b);
                contentv.put(KEY_B,c);
                contentv.put(KEY_C,d);
                contentv.put(KEY_D,e);
                contentv.put(KEY_ANSWER,f);


                sqs = r.readLine();
                sqs = r.readLine();

                db.insert(TBNAME1, null, contentv);
            }


            db.close();

        }
        catch(IOException nm){

        }
    }

    public String gtstring()
    {
        String nw;
        SQLiteDatabase db = this.getReadableDatabase();
        String x = "select question from questionsx where id1=1";
        Cursor c1 = db.rawQuery(x, null);
        if( c1 != null && c1.moveToFirst())
        {

                nw = c1.getString(c1.getColumnIndex("question"));
                c1.close();
                return nw;

        }
        else
            return "hii";
    }

    public ArrayList<String> dbview()
    {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select question from questionsx", null);
        ArrayList<String> values = new ArrayList<String>();
        int i = c.getColumnIndex("question");
        String result;
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            result = c.getString(i);
            values.add(result);


        }
        return values;
    }



    public void populate()
    {
        int k;
        SQLiteDatabase db2 = this.getReadableDatabase();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < 16) {

            int random = randomGenerator .nextInt(29)+1;
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        String xm1,xm2,xm3,xm4,xm5,xm6;
        Cursor c1,c2,c3,c4,c5,c6;
        for(int i =0;i<15;i++)
        {
         k = numbers.get(i);
            xm1 = "select question from questionsx where id1 ="+"'"+k+"'";
          xm2 = "select A from questionsx where id1 =" + "'"+k+"'";
          xm3 = "select B from questionsx where id1 =" + "'"+k+"'" ;
          xm4 = "select C from questionsx where id1 =" + "'"+k+"'";
          xm5 = "select D from questionsx where id1 =" + "'"+k+"'";
          xm6 = "select answer from questionsx where id1 =" + "'"+k+"'";
             c1 = db2.rawQuery(xm1, null);
            if(c1.moveToFirst())
         question[i]  = c1.getString(c1.getColumnIndex("question"));
            c1.close();
             c2 = db2.rawQuery(xm2, null);
            if(c2.moveToFirst()) {
                A[i] = c2.getString(c2.getColumnIndex("A"));
            }
            c2.close();
             c3 = db2.rawQuery(xm3, null);
            if(c3.moveToFirst())
            B[i] = c3.getString(c3.getColumnIndex("B"));
            c3.close();
             c4 = db2.rawQuery(xm4, null);
            if(c4.moveToFirst())
            C[i] = c4.getString(c4.getColumnIndex("C"));
            c4.close();
             c5 = db2.rawQuery(xm5, null);
            if(c5.moveToFirst())
            D[i] = c5.getString(c5.getColumnIndex("D"));
            c5.close();
             c6 = db2.rawQuery(xm6, null);
            if(c6.moveToFirst())
            answer[i]  = c6.getString(c6.getColumnIndex("answer"));
            c6.close();

        }
    }



    public void adduser(User u)
    {

        SQLiteDatabase db = this.getReadableDatabase();


        ContentValues v = new ContentValues();

        v.put(KEY_NAME,u.getname());
        v.put(KEY_PASSWORD,u.getpassword());
        v.put(KEY_PHONE,u.getphoneno());
        v.put(KEY_EMAIL,u.getemail());
        v.put(KEY_COLLEGE,u.getcollege());

        db.insert(TBNAME, null, v);
        db.close();


    }
    public String logindb(String x)
    {
        String kk = "select password from user where phoneno ="+"'" +x+"'"+";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(kk,null);
        String d;

        if( c != null && c.moveToFirst() ){
            d = c.getString(c.getColumnIndex("password"));
            c.close();
            return d;
        }
        else
        {
            return null;
        }

    }
    public void addkodekrypt(String y)
    {
        String addk = "update user set kodekrypt = 'true' where phoneno ="+"'" +y+"'"+";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(addk,null);
    }



}

