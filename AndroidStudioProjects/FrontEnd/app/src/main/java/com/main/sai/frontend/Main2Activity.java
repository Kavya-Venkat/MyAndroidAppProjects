package com.main.sai.frontend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class Main2Activity extends Activity {
    private Spinner stateSpin,distSpin,samitiSpin,genderSpin,eduSpin,occSpin;
    String state,dist,samiti,gender,edu,occu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //https://developer.android.com/guide/topics/ui/controls/spinner.html
        //https://www.tutorialspoint.com/android/android_spinner_control.htm
       // https://www.mkyong.com/android/android-spinner-drop-down-list-example/
        // Spinner element
        addListenerOnSpinnerItemSelection();
        /*Intent intent=new Intent(Main2Activity.this,Main4Activity.class);
        Bundle b =new Bundle();
        b.putString("state",state);
        b.putString("dist",dist);
        b.putString("samiti",samiti);
        b.putString("gender",gender);
        b.putString("edu",edu);
        b.putString("occu",occu);
        intent.putExtras(b);*/


    }
    public void onNext(View view)
    {

        startActivity(new Intent(this,Main3Activity.class));
    }


    public void addListenerOnSpinnerItemSelection()
    {
        stateSpin = (Spinner) findViewById(R.id.state_spinner);
        stateSpin .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                 @Override
                                                 public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {

                                                     state = parent.getItemAtPosition(pos).toString();

                                                 }

                                                 @Override
                                                 public void onNothingSelected(AdapterView<?> parentView) {
                                                     // your code here
                                                 }
                                             });

        distSpin = (Spinner) findViewById(R.id.dist_spinner);
        distSpin.setOnItemSelectedListener(new  AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
            /*Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();*/
             dist = parent.getItemAtPosition(pos).toString();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
            // your code here
        }
    });

        samitiSpin = (Spinner) findViewById(R.id.samithi_spinner);
        samitiSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
                /*Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();*/
                 samiti = parent.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        genderSpin = (Spinner) findViewById(R.id.gender_spinner);
        genderSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
                /*Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();*/
                 gender = parent.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        eduSpin = (Spinner) findViewById(R.id.education_spinner);
        eduSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
                /*Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();*/
                 edu = parent.getItemAtPosition(pos).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        occSpin = (Spinner) findViewById(R.id.occupation_spinner);
        occSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
               /* Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();*/
                 occu = parent.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

    }
}