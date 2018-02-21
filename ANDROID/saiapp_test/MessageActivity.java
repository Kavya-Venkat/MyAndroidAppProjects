package com.main.sai.regapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        final ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.swami);
        setContentView(imageView);
    }
}
