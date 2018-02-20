package com.main.sai.frontend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class Main4Activity extends Activity {
    String data="",FirstName,LastName,Address,City, Dist, State,Samiti,MobilePhone, EmailAddress, Education,Marital_status,Occupation,Other_Skill,Sex,comments,Partiyatra,Prev_sadhana,Stu_Balvikas,Guru_Balvikas,Age,interest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        addListenerOnEditText();
        addListenerOnSwitch();
    }

    public void userReg(View view)
    {
        Intent intent=getIntent();
        Bundle b= intent.getExtras();

        FirstName=b.getString("First Name");
        LastName=b.getString("Last Name");
        Address=b.getString("addr");
        City=b.getString("city");
        MobilePhone=b.getString("Mobile");
        EmailAddress=b.getString("mail");
        /*
        FirstName=b.getString("First Name");
        LastName=b.getString("Last Name");
        Address=b.getString("addr");
        City=b.getString("city");
        Samiti=b.getString("samiti");
        Dist=b.getString("dist");
        State=b.getString("state");
        MobilePhone=b.getString("Mobile");
        EmailAddress=b.getString("mail");
        Education=b.getString("edu");
        Occupation=b.getString("occu");
        Other_Skill=b.getString("other_int");
        Sex=b.getString("gender");
        Marital_status=b.getString("marital");
        interest=b.getString("Interests");
        Age=b.getString("age");
        */
        Samiti="samiti";
        Dist="dist";
        State="state";
        Education="edu";
        Occupation="occu";
        Other_Skill="other_int";
        Sex="gender";
        Marital_status="marital";
        interest="Interests";
        Age="age";
        /*
          FirstName="First Name";
        LastName="Last Name";
        Address="addr";
        City="city";
        Samiti="samiti";
        Dist="dist";
        State="state";
        MobilePhone="Mobile";
        EmailAddress="mail";
        Education="edu";
        Occupation="occu";
        Other_Skill="other_int";
        Sex="gender";
        Marital_status="marital";
        interest="Interests";
        Age="age";
         */

        String method = "register";
        Register register = new Register(this);
        register.execute(method,FirstName,LastName,Address,City, Dist, State,Samiti,MobilePhone, EmailAddress, Education,Marital_status,Occupation,Other_Skill,Sex,comments,Partiyatra,Prev_sadhana,Stu_Balvikas,Guru_Balvikas,Age,interest);
        finish();
        //startActivity(new Intent(this,Register.class));
    }

    public void addListenerOnEditText()
    {
    EditText myTextBox = (EditText) findViewById(R.id.comment);
    myTextBox.addTextChangedListener(new TextWatcher() {

        public void afterTextChanged (Editable s){
        }

    public void beforeTextChanged(CharSequence s, int start,
                                  int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start,
                              int before, int count) {
       //store the string s which contains the charseq
        //toast to check
        //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
        comments=s.toString();
    }
    });
    }

    public void addListenerOnSwitch()
    {
        Switch mySwitch=(Switch)findViewById(R.id.sadhana_switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked){
                   Prev_sadhana="1";
               }
                  // Toast.makeText(getApplicationContext(),"Attended",Toast.LENGTH_LONG).show();
            }
        });

        mySwitch=(Switch)findViewById(R.id.yatra_switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Partiyatra="1";
                }
                   // Toast.makeText(getApplicationContext(),"Parti yatra",Toast.LENGTH_LONG).show();
            }
        });

        mySwitch=(Switch)findViewById(R.id.guru_switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Guru_Balvikas="1";
                }
                    ///Toast.makeText(getApplicationContext(),"Balvikas guru",Toast.LENGTH_LONG).show();
            }
        });

        mySwitch=(Switch)findViewById(R.id.stud_switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Stu_Balvikas="1";
                }
                   // Toast.makeText(getApplicationContext(),"BV Student",Toast.LENGTH_LONG).show();
            }
        });
    }
}
