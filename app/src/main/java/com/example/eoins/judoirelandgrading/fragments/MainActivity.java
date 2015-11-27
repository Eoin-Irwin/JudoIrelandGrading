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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.eoins.judoirelandgrading.R;
import com.example.eoins.judoirelandgrading.dB.DatabaseHelper;
import com.example.eoins.judoirelandgrading.dB.MainActivity2;


public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    DatabaseHelper myDb;
    EditText editName,editMemNo,editDate,editGrade, editScore;

    Button btnAddData;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnviewDelete;

ArrayAdapter<String> adapter;
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private int position = 0;
    private static final String LOG_TAG = "JudoIrelandGrading";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);

    }

    public void onContentChanged() {
        super.onContentChanged();
        Log.d(LOG_TAG, "onContentChanged");
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

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
                mToolbar.setBackgroundColor(Color.rgb(255,235,59));
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
                mToolbar.setBackgroundColor(Color.rgb(34,139,34));
                fragment = new GreenFragment();
                title = getString(R.string.title_green);
                break;

            case 4:
                mToolbar.setTitleTextColor(Color.WHITE);
                mToolbar.setBackgroundColor(Color.rgb(63,81,181));
                fragment = new BlueFragment();
                title = getString(R.string.title_blue);
                break;

            case 5:
                mToolbar.setTitleTextColor(Color.WHITE);
                mToolbar.setBackgroundColor(Color.rgb(121,85,72));
                fragment = new BrownFragment();
                title = getString(R.string.title_brown);
                break;
            case 6:
                mToolbar.setTitleTextColor(Color.WHITE);
                mToolbar.setBackgroundColor(Color.rgb(0,0,0));
                fragment = new BlackFragment();
                title = getString(R.string.title_black);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:

                Intent main = new Intent(this, MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_record) {

            Intent add_mem = new Intent(this, MainActivity2.class);
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }

}