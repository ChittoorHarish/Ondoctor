package com.example.ondoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class card1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    public CardView continuousfevercard,remittentfevercard,ebsteinfevercard,intermittentcard,septicfevercard,periodicfevercard;
    Button button2, button3;

    ViewFlipper v_flipper;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card1);
        continuousfevercard = findViewById(R.id.continuosfevercard);
        continuousfevercard.setOnClickListener(this);
        intermittentcard = findViewById(R.id.intermittentcard);
        intermittentcard.setOnClickListener(this);
        remittentfevercard = findViewById(R.id.remittentfevercard);
        remittentfevercard.setOnClickListener(this);
        ebsteinfevercard = findViewById(R.id.ebsteinfevercard);
        ebsteinfevercard.setOnClickListener(this);
        septicfevercard = findViewById(R.id.septicfevercard);
        septicfevercard.setOnClickListener(this);
        periodicfevercard = findViewById(R.id.periodicfevercard);
        periodicfevercard.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        drawerLayout = findViewById(R.id.drawer_card1);
        navigationView = findViewById(R.id.nav_viewcard1);
        toolbar = findViewById(R.id.toolbarcard1);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_login).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        int images[] = {R.drawable.fever1, R.drawable.fever2, R.drawable.fever3};

        v_flipper = findViewById(R.id.v_flipper);

        for (int image:images){
            flipperImages(image);
        }

    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(2000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.continuosfevercard:
                Intent intent = new Intent(this, continuousfever.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.button2:
                Intent intent = new Intent(this,Homescreen.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.button3:
                Intent intent = new Intent(this,RegisterUser.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.intermittentcard:
                Intent intent = new Intent(this,intermittent.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.remittentfevercard:
                Intent intent = new Intent(this,remittentfever.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.ebsteinfevercard:
                Intent intent = new Intent(this,ebsteinfever.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.septicfevercard:
                Intent intent = new Intent(this,septicfever.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.periodicfevercard:
                Intent intent = new Intent(this,periodicfever.class);
                startActivity(intent);
                break;
        }

    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_logout:
                Intent intent = new Intent(card1.this, MainActivity2.class);
                startActivity(intent);
                break;
        }
        switch (item.getItemId()){
            case R.id.nav_Home:
                Intent intent = new Intent(this,Homescreen.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}