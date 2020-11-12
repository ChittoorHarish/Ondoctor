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

public class card3 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    public CardView constipationcard,appendicitiscard,irritablecard,ulcerscard,pancreatiscard,gastrocard;
    Button button2,button3;
    ViewFlipper v_flipperAbdomen;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card3);

        constipationcard = findViewById(R.id.constipationcard);
        constipationcard.setOnClickListener(this);
        appendicitiscard = findViewById(R.id.appendicitiscard);
        appendicitiscard.setOnClickListener(this);
        irritablecard = findViewById(R.id.irritablecard);
        irritablecard.setOnClickListener(this);
        ulcerscard = findViewById(R.id.ulcerscard);
        ulcerscard.setOnClickListener(this);
        pancreatiscard = findViewById(R.id.pancreatiscard);
        pancreatiscard.setOnClickListener(this);
        gastrocard = findViewById(R.id.gastrocard);
        gastrocard.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        drawerLayout = findViewById(R.id.drawer_card3);
        navigationView = findViewById(R.id.nav_viewcard3);
        toolbar = findViewById(R.id.toolbarcard3);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_login).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        int images[] = {R.drawable.abdomen1, R.drawable.abdomen2, R.drawable.abdomen3};

        v_flipperAbdomen = findViewById(R.id.v_flipperAbdomen);

        for (int image:images){
            flipperImages(image);
        }

    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipperAbdomen.addView(imageView);
        v_flipperAbdomen.setFlipInterval(2000);
        v_flipperAbdomen.setAutoStart(true);

        v_flipperAbdomen.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipperAbdomen.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.constipationcard:
                Intent intent = new Intent(this,constipation.class);
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
            case R.id.pancreatiscard:
                Intent intent = new Intent(this,pancreatitis.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.appendicitiscard:
                Intent intent = new Intent(this,appendicitis.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.irritablecard:
                Intent intent = new Intent(this,irritablebowel.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.ulcerscard:
                Intent intent = new Intent(this, ulcers.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.gastrocard:
                Intent intent = new Intent(this,gastroenteritis.class);
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
                Intent intent = new Intent(card3.this, MainActivity2.class);
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