package com.example.eoins.judoirelandgrading.fragments;

/**
 * created by Eoin on 30-10-15
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.eoins.judoirelandgrading.R;
import com.example.eoins.judoirelandgrading.dB.MainActivity2;


public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initalise toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        //Set the toolbar instead of the action bar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Initalise Fragment Drawer
        drawerFragment = (FragmentDrawer)
                //Get the FragmentManager that has fragments associated with this activity.
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        //Initalise the drawer layout
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        //Drawer listener
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);

    }

    //When an item is selected display it
    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    //Function which has a switch case, contains fragments and bg colours of toolbars
    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                mToolbar.setTitleTextColor(Color.BLACK);
                mToolbar.setBackgroundColor(Color.LTGRAY);
                fragment = new WhiteFragment();
                title = getString(R.string.title_white);
                break;
            case 1:
                mToolbar.setTitleTextColor(Color.WHITE);
                mToolbar.setBackgroundColor(Color.rgb(255, 235, 59));
                fragment = new YellowFragment();
                title = getString(R.string.title_yellow);
                break;
            case 2:
                mToolbar.setTitleTextColor(Color.WHITE);
                mToolbar.setBackgroundColor(Color.rgb(255, 165, 0));
                fragment = new OrangeFragment();
                title = getString(R.string.title_orange);
                break;
            case 3:
                mToolbar.setTitleTextColor(Color.WHITE);
                mToolbar.setBackgroundColor(Color.rgb(34, 139, 34));
                fragment = new GreenFragment();
                title = getString(R.string.title_green);
                break;

            case 4:
                mToolbar.setTitleTextColor(Color.WHITE);
                mToolbar.setBackgroundColor(Color.rgb(63, 81, 181));
                fragment = new BlueFragment();
                title = getString(R.string.title_blue);
                break;

            case 5:
                mToolbar.setTitleTextColor(Color.WHITE);
                mToolbar.setBackgroundColor(Color.rgb(121, 85, 72));
                fragment = new BrownFragment();
                title = getString(R.string.title_brown);
                break;
            case 6:
                mToolbar.setTitleTextColor(Color.WHITE);
                mToolbar.setBackgroundColor(Color.rgb(0, 0, 0));
                fragment = new BlackFragment();
                title = getString(R.string.title_black);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            //Start edit operations on the Fragments associated with this FragmentManager.
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

    //Menu Inflation
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    //Overflow menu that allows the user
    //to input a new record to database
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_record) {

            Intent add_to_db = new Intent(this, MainActivity2.class);
            startActivity(add_to_db);

        }
        return super.onOptionsItemSelected(item);
    }

}