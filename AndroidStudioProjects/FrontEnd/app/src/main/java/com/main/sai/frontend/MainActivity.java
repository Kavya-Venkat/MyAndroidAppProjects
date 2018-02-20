package com.main.sai.frontend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;

import static com.main.sai.frontend.R.id.email;

public class MainActivity extends Activity {

    String FirstName,LastName,MobilePhone,Email,Address,City ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnEditText();

        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(MainActivity.this, Main4Activity.class);

                Bundle b = new Bundle();
                b.putString("First Name", FirstName);
                b.putString("Last Name", LastName);
                b.putString("Mobile", MobilePhone);
                b.putString("mail", Email);
                b.putString("addr", Address);
                b.putString("city", City);
                intent.putExtras(b);

                startActivity(intent);
            }
        });
    }
   /* public void onNext(View view)
    {
        startActivity(intent,Main4Activity.class));
    }*/
    public void addListenerOnEditText(){
        EditText myTextBox = (EditText) findViewById(R.id.fname);
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
                //Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                FirstName=s.toString();

            }
        });

         myTextBox = (EditText) findViewById(R.id.lname);
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
                //Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                LastName=s.toString();

            }
        });

        myTextBox = (EditText) findViewById(R.id.mobnum);
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
                //Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                MobilePhone=s.toString();

            }
        });
        myTextBox = (EditText) findViewById(email);
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
                //Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                Email=s.toString();

            }
        });

        myTextBox = (EditText) findViewById(R.id.addr);
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
                 //Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                Address=s.toString();
            }
        });

        myTextBox = (EditText) findViewById(R.id.city);
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
               // Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                City=s.toString();

            }
        });
    }
}
