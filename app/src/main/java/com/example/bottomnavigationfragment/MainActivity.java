package com.example.bottomnavigationfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavigationfragment.fragments.AboutFragment;
import com.example.bottomnavigationfragment.fragments.DashboardFragment;
import com.example.bottomnavigationfragment.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                new HomeFragment()).commit();

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()){

                    case R.id.home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.dashboard:
                        selectedFragment = new DashboardFragment();
                        break;
                    case R.id.about:
                        selectedFragment = new AboutFragment();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                        selectedFragment).commit();

                return true;
            }
        });



    }
}