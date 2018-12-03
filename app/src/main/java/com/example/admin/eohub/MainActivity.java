package com.example.admin.eohub;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.admin.eohub.event.EventFragment;
import com.example.admin.eohub.home.HomeFragment;
import com.example.admin.eohub.setting.SettingFragment;


public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navBot);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
            switch (item.getItemId()) { case R.id.home:
                selectedFragment = HomeFragment.newInstance();
                break;
            case R.id.events:
                selectedFragment = EventFragment.newInstance();
                break;
            case R.id.setting:
                selectedFragment = SettingFragment.newInstance();
                break;
            }
        return loadFragment(selectedFragment);
    }
}
