package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Actividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navbar = findViewById(R.id.navbar);
        navbar.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contenedor, new InicioFragment()).commit();

        getSupportActionBar().hide();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectFragment = null;

            switch (item.getItemId()){
                case R.id.nav_inicio:
                    selectFragment = new InicioFragment();
                    break;
                case R.id.nav_descargas:
                    selectFragment = new DescargasFragment();

                    break;
                case R.id.nav_premium:
                    selectFragment = new PremiumFragment();
                    break;
                case R.id.nav_help:
                    selectFragment = new AyudaFragment();
                    break;
                case R.id.nav_info:
                    selectFragment = new InformacionFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contenedor, selectFragment).commit();
            return true;
        }
    };
}
