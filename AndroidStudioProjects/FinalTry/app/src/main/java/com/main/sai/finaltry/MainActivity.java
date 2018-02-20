package com.main.sai.finaltry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newMem(View view)
    {
        startActivity(new Intent(this,Main2Activity.class));
    }
}


   /* TODOOOOOO....
   Populate Samitis,state,district

    Include delegate,BV alumni,member fields - comments

        App UI- color,format

        BACK button

        Possible final activity for successful registration

        Swami Image clarity*/