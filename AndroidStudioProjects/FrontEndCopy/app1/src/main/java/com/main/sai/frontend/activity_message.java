package com.main.sai.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class activity_message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        final ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.swami);
        setContentView(imageView);


    }
    public void goback(View view)
    {
        startActivity(new Intent(this,MainActivity.class));

    }
}
