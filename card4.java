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

public class card4 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    public CardView primarytensioncard,migraincard,primaryclustercard,hypniccard,hemicraniacard,traumacard;
    Button button2,button3;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ViewFlipper v_flipperhead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card4);
        primarytensioncard = findViewById(R.id.primarytensioncard);
        primarytensioncard.setOnClickListener(this);
        migraincard = findViewById(R.id.migraincard);
        migraincard.setOnClickListener(this);
        primaryclustercard = findViewById(R.id.primaryclustercard);
        primaryclustercard.setOnClickListener(this);
        hypniccard = findViewById(R.id.hypniccard);
        hypniccard.setOnClickListener(this);
        hemicraniacard = findViewById(R.id.hemicraniacard);
        hemicraniacard.setOnClickListener(this);
        traumacard = findViewById(R.id.traumacard);
        traumacard.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        drawerLayout = findViewById(R.id.drawer_card4);
        navigationView = findViewById(R.id.nav_viewcard4);
        toolbar = findViewById(R.id.toolbarcard4);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_login).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        int images[] = {R.drawable.headache1, R.drawable.headache2, R.drawable.headache3};

        v_flipperhead = findViewById(R.id.v_flipperhead);

        for (int image:images){
            flipperImages(image);
        }

    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipperhead.addView(imageView);
        v_flipperhead.setFlipInterval(2000);
        v_flipperhead.setAutoStart(true);

        v_flipperhead.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipperhead.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.primarytensioncard:
                Intent intent = new Intent(this, primarytension.class);
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
            case R.id.primaryclustercard:
                Intent intent = new Intent(this,primarycluster.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.hemicraniacard:
                Intent intent = new Intent(this, hemicrania.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.migraincard:
                Intent intent = new Intent(this,migrain.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.hypniccard:
                Intent intent = new Intent(this,hypnicheadache.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.traumacard:
                Intent intent = new Intent(this,trauma.class);
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
                Intent intent = new Intent(card4.this, MainActivity2.class);
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