package com.example.headstart.headstart;


public class User {

    String name;
    String password;
    String phoneno;
    String email;
    String college;

    User(String a,String b,String c,String d,String e)
    {
        name = a;
        password = b;
        phoneno = c;
        email = d;
        college = e;
    }
    void setname(String a)
    {
        name = a;

    }
    String getname()
    {
        return name;
    }
    void setpassword(String b)
    {
        password = b;
    }
    String getpassword()
    {
        return password;
    }
    void setphoneno(String c)
    {
        phoneno = c;
    }
    String getphoneno()
    {
        return phoneno;
    }
    void setemail(String d)
    {
        email = d;
    }
    String getemail()
    {
        return email;
    }
    void setcollege(String e)
    {
        college = e;

    }
    String getcollege()
    {
        return college;
    }

}
