package com.android.example.newsforme.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.example.newsforme.Fragments.GamesFragment;
import com.android.example.newsforme.Fragments.ScienceFragment;
import com.android.example.newsforme.Fragments.SettingsFragment;
import com.android.example.newsforme.Fragments.SportsFragment;
import com.android.example.newsforme.Fragments.WorldFragment;
import com.android.example.newsforme.R;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

public class HomeActivity extends AppCompatActivity {
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;
    private Drawer drawerBuilder;
    private PrimaryDrawerItem mainItem;
    private SecondaryDrawerItem subItem;
    private NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()) {
                case R.id.scienceNews:
                    fragment = new ScienceFragment();
                    mDrawerLayout.closeDrawers();
                    loadFragment(fragment);
                    return true;
                case R.id.sportNews:
                    fragment = new SportsFragment();
                    mDrawerLayout.closeDrawers();
                    loadFragment(fragment);
                    return true;
                case R.id.worldNews:
                    fragment = new WorldFragment();
                    mDrawerLayout.closeDrawers();
                    loadFragment(fragment);
                    return true;
                case R.id.favoriteNews:
                    return true;
                case R.id.videoGameNews:
                    fragment = new GamesFragment();
                    mDrawerLayout.closeDrawers();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.toMenu) {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loadFragment(new ScienceFragment());
        NavigationView navigationView = findViewById(R.id.nav_View);
        navigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
    }


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
