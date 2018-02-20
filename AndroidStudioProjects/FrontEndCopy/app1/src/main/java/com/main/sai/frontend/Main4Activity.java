package com.main.sai.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        addListenerOnEditText();
        addListenerOnSwitch();
    }

    public void userReg(View view)
    {
        startActivity(new Intent(this,Register.class));
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
    }
    });
    }

    public void addListenerOnSwitch()
    {
        Switch mySwitch=(Switch)findViewById(R.id.sadhana_switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked){}
                  // Toast.makeText(getApplicationContext(),"Attended",Toast.LENGTH_LONG).show();
            }
        });

        mySwitch=(Switch)findViewById(R.id.yatra_switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){}
                   // Toast.makeText(getApplicationContext(),"Parti yatra",Toast.LENGTH_LONG).show();
            }
        });

        mySwitch=(Switch)findViewById(R.id.guru_switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){}
                    ///Toast.makeText(getApplicationContext(),"Balvikas guru",Toast.LENGTH_LONG).show();
            }
        });

        mySwitch=(Switch)findViewById(R.id.stud_switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){}
                   // Toast.makeText(getApplicationContext(),"BV Student",Toast.LENGTH_LONG).show();
            }
        });
    }
}
