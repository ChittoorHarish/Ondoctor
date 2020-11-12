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

public class card5 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    public CardView tonsillitiscard,earinfectioncard,sinuscard,allergiescard,sleepcard,hearingcard;
    Button button2,button3;

    ViewFlipper v_flipperent;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card5);
        tonsillitiscard = findViewById(R.id.tonsillitiscard);
        tonsillitiscard.setOnClickListener(this);
        earinfectioncard = findViewById(R.id.earinfectioncard);
        earinfectioncard.setOnClickListener(this);
        sinuscard = findViewById(R.id.sinuscard);
        sinuscard.setOnClickListener(this);
        allergiescard = findViewById(R.id.allergiescard);
        allergiescard.setOnClickListener(this);
        sleepcard = findViewById(R.id.sleepcard);
        sleepcard.setOnClickListener(this);
        hearingcard = findViewById(R.id.hearingcard);
        hearingcard.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        drawerLayout = findViewById(R.id.drawer_card5);
        navigationView = findViewById(R.id.nav_viewcard5);
        toolbar = findViewById(R.id.toolbarcard5);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_login).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        int images[] = {R.drawable.ent1, R.drawable.ent2, R.drawable.ent3};

        v_flipperent = findViewById(R.id.v_flipperent);

        for (int image:images){
            flipperImages(image);
        }

    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipperent.addView(imageView);
        v_flipperent.setFlipInterval(2000);
        v_flipperent.setAutoStart(true);

        v_flipperent.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipperent.setOutAnimation(this, android.R.anim.slide_out_right);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tonsillitiscard:
                Intent intent = new Intent(this, tonsillitis.class);
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
            case R.id.sleepcard:
                Intent intent = new Intent(this,sleepapnea.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.earinfectioncard:
                Intent intent = new Intent(this,earinfection.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.hearingcard:
                Intent intent = new Intent(this,hearingloss.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.sinuscard:
                Intent intent = new Intent(this,sinusinfection.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.allergiescard:
                Intent intent = new Intent(this,allergies.class);
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
                Intent intent = new Intent(card5.this, MainActivity2.class);
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
