package com.pereira.fatima.flicker.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.pereira.fatima.flicker.ClassPhoto;

import java.util.ArrayList;
import java.util.List;

public class FlickerService extends Service {
    private final IBinder binder = new ServiceBinder();
    List<ClassPhoto> classPhotos = new ArrayList<>();

    public List<ClassPhoto>getClassPhotos(){

        classPhotos.add(new ClassPhoto("Chat", "http://media.koreus.com/201409/109-insolite-34.jpg"));
        classPhotos.add(new ClassPhoto("Titre", "http://media.koreus.com/201409/109-insolite-34.jpg"));
        classPhotos.add(new ClassPhoto("Titre", "http://media.koreus.com/201409/109-insolite-34.jpg"));
        return classPhotos;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class ServiceBinder extends Binder {
        public FlickerService getService() {
            return FlickerService.this;
        }
    }
}