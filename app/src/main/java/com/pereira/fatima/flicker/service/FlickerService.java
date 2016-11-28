package com.pereira.fatima.flicker.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.google.gson.Gson;
import com.pereira.fatima.flicker.ClassPhoto;
import com.pereira.fatima.flicker.R;
import com.pereira.fatima.flicker.flickr.dto.ClassConverter;
import com.pereira.fatima.flicker.flickr.dto.FlickrResponseDto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlickerService extends Service {
    private final IBinder binder = new ServiceBinder();
    List<ClassPhoto> classPhotos = new ArrayList<>();
    Retrofit retrofit;
    FlickerRetrofit retrofitService;
    String url = "https://www.flickr.com/";

    private FlickerResponseListener flickerResponseListener;

    public void getClassPhotos(String query) {

        //***************************************************
        //           RETROFIT
        //***************************************************


        final Call<FlickrResponseDto> flickrResponseRetrofitCall = retrofitService.getPhotosRetrofit(query,getResources().getString(R.string.flicker_api_key));
        flickrResponseRetrofitCall.enqueue(new Callback<FlickrResponseDto>()

        {
            @Override
            public void onResponse (Call < FlickrResponseDto > call,
                                    Response< FlickrResponseDto > response){
                // On reçoit la liste et on la converti
                List<ClassPhoto> classPhotos = new ClassConverter().convert(response.body());
                flickerResponseListener.onPhotosReceived(classPhotos);
            //Log.e("ON RESPONSE", classPhotos.toString());

            }


            @Override
            public void onFailure (Call < FlickrResponseDto > call,
                                   Throwable t){
            //Log.e("ON RESPONSE", "ok" );
            }

        });

    }

    @Override
    public IBinder onBind(Intent intent) {
        retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        retrofitService = retrofit.create(FlickerRetrofit.class);
        return binder;
    }

    public class ServiceBinder extends Binder {
        public FlickerService getService() {
            return FlickerService.this;
        }
    }

    public void setFlickerResponseListener(FlickerResponseListener flickerResponseListener) {
        this.flickerResponseListener = flickerResponseListener;
    }
}