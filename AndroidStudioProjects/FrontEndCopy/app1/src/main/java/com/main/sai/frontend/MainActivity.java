package com.main.sai.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnEditText();
    }
    public void onNext(View view)
    {
        startActivity(new Intent(this,Main2Activity.class));
    }
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
            }
        });
        myTextBox = (EditText) findViewById(R.id.email);
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
            }
        });
    }
}
