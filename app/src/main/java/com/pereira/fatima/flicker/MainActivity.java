package com.pereira.fatima.flicker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.pereira.fatima.flicker.service.FlickerService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    FlickerAdapter flickerAdapter = new FlickerAdapter();
    List<ClassPhoto> classPhoto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                classPhoto = flickerService.getClassPhotos();
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
            bound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            bound = false;
        }
    };


}
