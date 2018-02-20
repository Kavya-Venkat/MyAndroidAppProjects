package com.main.sai.regapp;

/**
 * Created by KV035320 on 7/13/2017.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends Activity {
    EditText ET_Fname, ET_Lname, ET_Address, ET_City, ET_Dist, ET_State, ET_HomePhone, ET_MobilePhone, ET_Email, ET_Education;
    String Fname,Lname,Address, City, Dist, State, HomePhone, MobilePhone, Email, Education;
    //RadioGroup radioSexGroup;
    //Button btnDisplay;
    //RadioButton radioSexButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_layout);
        ET_Fname = (EditText) findViewById(R.id.fname);
        ET_Lname = (EditText) findViewById(R.id.lname);
        ET_Address = (EditText) findViewById(R.id.addr);
        ET_City = (EditText) findViewById(R.id.city);
        ET_Dist = (EditText) findViewById(R.id.dist);
        ET_State = (EditText) findViewById(R.id.state);
        ET_HomePhone = (EditText) findViewById(R.id.homenum);
        ET_MobilePhone = (EditText) findViewById(R.id.mobnum);
        ET_Email = (EditText) findViewById(R.id.mailid);
        ET_Education = (EditText) findViewById(R.id.edu);
    }
    public void userReg(View view)
    {
        Fname 		= ET_Fname.getText().toString();
        Lname 		= ET_Lname.getText().toString();
        Address 	= ET_Address.getText().toString();
        City 		= ET_City.getText().toString();
        Dist 		= ET_Dist.getText().toString();
        State 		= ET_State.getText().toString();
        HomePhone 	= ET_HomePhone.getText().toString();
        MobilePhone = ET_MobilePhone.getText().toString();
        Email 		= ET_Email.getText().toString();
        Education 	= ET_Education.getText().toString();
        String method = "register";
        Background backgroundTask = new Background(this);
        backgroundTask.execute(method,Fname,Lname,Address,City,Dist,State,HomePhone,MobilePhone,Email,Education);
        finish();
    }
}