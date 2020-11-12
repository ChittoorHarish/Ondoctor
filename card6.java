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

public class card6 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    public CardView vitiligocard,eczemacard,acnecard,psoriasiscard,rosaceacard,wartscard;
    Button button2,button3;

    ViewFlipper v_flipperskin;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card6);

        vitiligocard = findViewById(R.id.vitiligocard);
        vitiligocard.setOnClickListener(this);
        eczemacard = findViewById(R.id.eczemacard);
        eczemacard.setOnClickListener(this);
        acnecard = findViewById(R.id.acnecard);
        acnecard.setOnClickListener(this);
        psoriasiscard = findViewById(R.id.psoriasiscard);
        psoriasiscard.setOnClickListener(this);
        rosaceacard = findViewById(R.id.rosaceacard);
        rosaceacard.setOnClickListener(this);
        wartscard = findViewById(R.id.wartscard);
        wartscard.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        drawerLayout = findViewById(R.id.drawer_card6);
        navigationView = findViewById(R.id.nav_viewcard6);
        toolbar = findViewById(R.id.toolbarcard6);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_login).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        int images[] = {R.drawable.skin1, R.drawable.skin2, R.drawable.skin3};

        v_flipperskin = findViewById(R.id.v_flipperskin);

        for (int image:images){
            flipperImages(image);
        }

    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipperskin.addView(imageView);
        v_flipperskin.setFlipInterval(2000);
        v_flipperskin.setAutoStart(true);

        v_flipperskin.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipperskin.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.vitiligocard:
                Intent intent = new Intent(this, vitiligo.class);
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
            case R.id.eczemacard:
                Intent intent = new Intent(this,eczema.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.acnecard:
                Intent intent = new Intent(this,acne.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.rosaceacard:
                Intent intent = new Intent(this,rosacea.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.psoriasiscard:
                Intent intent = new Intent(this,psoriasis.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.wartscard:
                Intent intent = new Intent(this,warts.class);
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
                Intent intent = new Intent(card6.this, MainActivity2.class);
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