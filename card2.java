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

public class card2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    public CardView jointcard,bonecard,softtissuecard,backpaincard,shouldercard,sportcard;
    Button button2, button3;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ViewFlipper v_flipperOrtho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card2);
        jointcard = findViewById(R.id.jointcard);
        jointcard.setOnClickListener(this);
        bonecard = findViewById(R.id.bonecard);
        bonecard.setOnClickListener(this);
        softtissuecard = findViewById(R.id.softtissuecard);
        softtissuecard.setOnClickListener(this);
        backpaincard = findViewById(R.id.backpaincard);
        backpaincard.setOnClickListener(this);
        shouldercard = findViewById(R.id.shouldercard);
        shouldercard.setOnClickListener(this);
        sportcard = findViewById(R.id.sportcard);
        sportcard.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        drawerLayout = findViewById(R.id.drawer_card2);
        navigationView = findViewById(R.id.nav_viewcard2);
        toolbar = findViewById(R.id.toolbarcard2);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_login).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);



        int images[] = {R.drawable.ortho1, R.drawable.ortho2, R.drawable.ortho3};

        v_flipperOrtho = findViewById(R.id.v_flipperOrtho);

        for (int image:images){
            flipperImages(image);
        }

    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipperOrtho.addView(imageView);
        v_flipperOrtho.setFlipInterval(2000);
        v_flipperOrtho.setAutoStart(true);

        v_flipperOrtho.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipperOrtho.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jointcard:
                Intent intent = new Intent(this,joints.class);
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
            case R.id.bonecard:
                Intent intent = new Intent(this,bonefracture.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.softtissuecard:
                Intent intent = new Intent(this,softtissue.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.shouldercard:
                Intent intent = new Intent(this,shoulderpain.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.backpaincard:
                Intent intent = new Intent(this,backpain.class);
                startActivity(intent);
                break;
        }
        switch (v.getId()){
            case R.id.sportcard:
                Intent intent = new Intent(this,sportinjury.class);
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
                Intent intent = new Intent(card2.this, MainActivity2.class);
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