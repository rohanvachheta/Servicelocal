package com.example.lenovo.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.myapplication.Fragments.BlankFragment;
import com.example.lenovo.myapplication.Fragments.DashbordFragment;
import com.example.lenovo.myapplication.Fragments.HomeFragment;
import com.example.lenovo.myapplication.Fragments.Lastfragment;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    android.support.v7.widget.Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        //navigation bar side view
        navigationView=findViewById(R.id.main_nav);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_android:
                        navigationView.setCheckedItem(R.id.nav_android);

                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.nav_home:
                        navigationView.setCheckedItem(R.id.nav_home);

                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(MainActivity.this, "dsfds", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_news:
                        navigationView.setCheckedItem(R.id.nav_news);

                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_about:

                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_mail:
                        Toast.makeText(MainActivity.this, "helo", Toast.LENGTH_SHORT).show();
                        break;



                }
                drawerLayout.closeDrawers();
                return false;
            }
        });

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new BlankFragment()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    Activity activity=null;

                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = new BlankFragment();
                            break;
                        case R.id.navigation_dashboard:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.navigation_notifications:
                            selectedFragment = new Lastfragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.main_drawer);
        toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle("Blogger Post");
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


    }
}
