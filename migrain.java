package com.example.ondoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class migrain extends AppCompatActivity implements View.OnClickListener{
    Button button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczema);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                Intent intent = new Intent(this,Homescreen.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()) {
            case R.id.button3:
                Intent intent = new Intent(this, RegisterUser.class);
                startActivity(intent);
                break;
        }

    }
}