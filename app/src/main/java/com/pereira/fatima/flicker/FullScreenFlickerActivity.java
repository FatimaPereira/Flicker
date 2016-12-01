package com.pereira.fatima.flicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FullScreenFlickerActivity extends AppCompatActivity {

    List<ClassPhoto> classPhoto = new ArrayList<>();

    TextView titreFullscreen;
    TextView urlFullscreen;
    ImageView imageFullscreen;
    //@BindView(R.id.titre_fullscreen)TextView titreFullscreen;
    //@BindView(R.id.url_fullscreen)TextView urlFullscreen;
    //@BindView(R.id.image_fullscreen)ImageView imageFullscreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_flicker);
        String title = getIntent().getStringExtra("Title");
        String url = getIntent().getStringExtra("Url");

        //********** ButterKnife *******************
        //ButterKnife.bind(this);


        titreFullscreen = (TextView) findViewById(R.id.titre_fullscreen);
        urlFullscreen = (TextView) findViewById(R.id.url_fullscreen);
        imageFullscreen = (ImageView) findViewById(R.id.image_fullscreen);
        titreFullscreen.setText(title);
        urlFullscreen.setText(url);
        Picasso.with(this).load(url).into(imageFullscreen);

        Button btnResetFullScreen = (Button) findViewById(R.id.btn_reset_fullscreen);

        btnResetFullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

    }
}
