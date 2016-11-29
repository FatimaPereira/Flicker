package com.pereira.fatima.flicker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.IBinder;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.pereira.fatima.flicker.service.FlickerService;
import com.pereira.fatima.flicker.service.FlickerResponseListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity implements FlickerResponseListener {

    ListView listView;
    FlickerAdapter flickerAdapter = new FlickerAdapter();
    List<ClassPhoto> classPhoto = new ArrayList<>();


    ActionBarDrawerToggle actionBarDrawerToggle;

    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.nav_search) Button btnNavSearch;
    @BindView(R.id.nav_historique) Button btnNavHistorique;
    @BindView(R.id.nav_spinner) Spinner btnNavSpinner;

    String titleNavDrawer;
    String titleNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //***** ButterKnife ********************
        ButterKnife.bind(this);

        //***** NAV TOGGLE ********************

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.drawer_open,
                R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(titleNav);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(titleNavDrawer);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
        R.array.number_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        btnNavSpinner.setAdapter(adapter);


//    flickerAdapter.classPhoto.add(new ClassPhoto("Chat","http://media.koreus.com/201409/109-insolite-34.jpg"));
//    flickerAdapter.classPhoto.add(new ClassPhoto("Titre","http://media.koreus.com/201409/109-insolite-34.jpg"));
//    flickerAdapter.classPhoto.add(new ClassPhoto("Titre","http://media.koreus.com/201409/109-insolite-34.jpg"));

        listView = (ListView) findViewById(R.id.list_flick);
        listView.setAdapter(flickerAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ClassPhoto image = (ClassPhoto) flickerAdapter.getItem(i);
                String title = image.getTitle();
                String url = image.getUrl();
                Intent intent = new Intent(MainActivity.this, FullScreenFlickerActivity.class);
                intent.putExtra("Title",title);
                intent.putExtra("Url",url);
                startActivity(intent);
            }
        });

        final EditText fieldSearch = (EditText) findViewById(R.id.search_textfield);

        Button btnSearch = (Button) findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {

            // Toast message d'alerte ou pop-up
            @Override
            public void onClick(View view) {
                flickerService.getClassPhotos(fieldSearch.getText().toString());
                flickerAdapter.setClassPhoto(classPhoto);
                //Toast.makeText(MainActivity.this, fieldSearch.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });


    }

    //***************************************************
    //            WEB SERVICE
    //***************************************************

    private FlickerService flickerService;
    boolean bound = false;

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, FlickerService.class);
        bindService(intent, flickConnection, Context.BIND_AUTO_CREATE);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (bound) {
            unbindService(flickConnection);
            bound = false;
        }
    }
    private ServiceConnection flickConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            FlickerService.ServiceBinder binder = (FlickerService.ServiceBinder) service;
            flickerService = binder.getService();
            flickerService.setFlickerResponseListener(MainActivity.this);

            bound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            bound = false;
        }
    };

    @Override
    public void onPhotosReceived(List<ClassPhoto> classPhotos) {
        flickerAdapter.setClassPhoto(classPhotos);
    }


    //***************************************************
    //            NAVIGATION DRAWER + ButterKnife
    //***************************************************
    @OnClick(R.id.nav_search)
    public void navSearch(Button btnNavSearch) {

    }

    @OnClick(R.id.nav_historique)
    public void navHistorique(Button btnNavHistorique) {

    }



     //***************************************************
    //            NAV TOGGLE
    //***************************************************
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }


}
