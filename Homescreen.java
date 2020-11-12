package com.example.ondoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
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

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

public class Homescreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    public CardView c1, c2,c3, c4, c5,c6;
    private Button check;


    ViewFlipper v_flipperhome;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        check = (Button) findViewById(R.id.check);
        check.setOnClickListener(this);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        c6.setOnClickListener(this);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_login).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        int images[] = {R.drawable.mask1, R.drawable.sanitize1, R.drawable.socialdistance, R.drawable.staysafe};

        v_flipperhome = findViewById(R.id.v_flipperhome);

        for (int image:images){
            flipperImages(image);
        }

    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipperhome.addView(imageView);
        v_flipperhome.setFlipInterval(2000);
        v_flipperhome.setAutoStart(true);

        v_flipperhome.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipperhome.setOutAnimation(this, android.R.anim.slide_out_right);

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
                Intent intent = new Intent(Homescreen.this, MainActivity2.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.c1:
                Intent intent = new Intent(this,card1.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.c2:
                Intent intent = new Intent(this,card2.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.c3:
                Intent intent = new Intent(this,card3.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.c4:
                Intent intent = new Intent(this, card4.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.c5:
                Intent intent = new Intent(this, card5.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.c6:
                Intent intent = new Intent(this, card6.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.check:
                Intent intent = new Intent(this, corona.class);
                startActivity(intent);
                break;
        }

    }
}

