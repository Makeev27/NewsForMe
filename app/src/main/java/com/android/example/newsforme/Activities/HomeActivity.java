package com.android.example.newsforme.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.android.example.newsforme.Fragments.GamesFragment;
import com.android.example.newsforme.Fragments.ScienceFragment;
import com.android.example.newsforme.Fragments.SettingsFragment;
import com.android.example.newsforme.Fragments.SportsFragment;
import com.android.example.newsforme.Fragments.WorldFragment;
import com.android.example.newsforme.R;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.SwitchDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import static com.android.example.newsforme.Data.Constants.*;

public class HomeActivity extends AppCompatActivity {
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;
    private AccountHeader headerResult = null;
    private Drawer result = null;





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
        CharSequence charSequence;
        String str;
        String str2;
        final IProfile profile = new ProfileDrawerItem().withName("Daniil Makeev").withEmail("makeevdaniildm@gmail.com").withIcon(Uri.parse("https://pp.userapi.com/c841521/v841521560/28311/RSqYN7R8wvs.jpg"));
        headerResult = new AccountHeaderBuilder().withActivity(this).
                withHeaderBackground(R.color.accent)
                .withTranslucentStatusBar(true)
                .addProfiles(profile, new ProfileSettingDrawerItem().withName("Add account").withDescription("Add a new account"))
                .withSavedInstance(savedInstanceState)
                .build();

        result = new DrawerBuilder().withActivity(this).withAccountHeader(headerResult)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.science_en).withIcon(R.drawable.ic_wb_incandescent_gray_24dp).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.sport_en).withIcon(R.drawable.ic_directions_run_gray_24dp).withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.world_en).withIcon(R.drawable.ic_public_gray_24dp).withIdentifier(3),
                        new PrimaryDrawerItem().withName(R.string.games_en).withIcon(R.drawable.ic_gamepad_controller).withIdentifier(4),
                        new SectionDrawerItem().withName(R.string.sub_menu),
                        new SecondaryDrawerItem().withName(R.string.favorite_en).withIcon(R.drawable.ic_favorite_gray_24dp).withIdentifier(5),
                        new SecondaryDrawerItem().withName(R.string.sources_en).withIcon(R.drawable.ic_favorite_gray_24dp).withIdentifier(6),
                        new SectionDrawerItem().withName(R.string.settings),
                        new SwitchDrawerItem().withName(R.string.language).withChecked(false).withOnCheckedChangeListener(onCheckedChangeListener)
                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Fragment fragment;
                        switch (position){
                            case 1:
                                fragment = new ScienceFragment();
                                loadFragment(fragment);
                                result.closeDrawer();
                                return true;
                            case 2:
                                fragment = new SportsFragment();
                                loadFragment(fragment);
                                result.closeDrawer();
                                return true;
                            case 3:
                                fragment = new WorldFragment();
                                loadFragment(fragment);
                                result.closeDrawer();
                                return true;
                            case 4:
                                fragment = new GamesFragment();
                                loadFragment(fragment);
                                result.closeDrawer();
                                return true;
                        }
                        return false;
                    }
                }).withSavedInstance(savedInstanceState)
                .build();







        loadFragment(new ScienceFragment());
//        NavigationView navigationView = findViewById(R.id.navView);
//        navigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);
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

    private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {
            if (isChecked == true){
                LANGUAGE = true;
            } else {
                LANGUAGE = false;
            }
        }
    };


}
