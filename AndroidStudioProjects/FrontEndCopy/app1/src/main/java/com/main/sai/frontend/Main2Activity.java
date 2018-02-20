package com.main.sai.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

public class Main2Activity extends AppCompatActivity {
    private Spinner stateSpin,distSpin,samitiSpin,genderSpin,eduSpin,occSpin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //https://developer.android.com/guide/topics/ui/controls/spinner.html
        //https://www.tutorialspoint.com/android/android_spinner_control.htm
       // https://www.mkyong.com/android/android-spinner-drop-down-list-example/
        // Spinner element
        addListenerOnSpinnerItemSelection();

    }
    public void onNext(View view)
    {
        startActivity(new Intent(this,Main3Activity.class));
    }
    public void addListenerOnSpinnerItemSelection() {
        stateSpin = (Spinner) findViewById(R.id.state_spinner);
        stateSpin.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        distSpin = (Spinner) findViewById(R.id.dist_spinner);
        distSpin.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        samitiSpin = (Spinner) findViewById(R.id.samithi_spinner);
        samitiSpin.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        genderSpin = (Spinner) findViewById(R.id.gender_spinner);
        genderSpin.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        eduSpin = (Spinner) findViewById(R.id.education_spinner);
        eduSpin.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        occSpin = (Spinner) findViewById(R.id.occupation_spinner);
        occSpin.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }
}