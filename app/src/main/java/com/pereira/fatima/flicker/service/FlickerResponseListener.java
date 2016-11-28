package com.pereira.fatima.flicker.service;

import com.pereira.fatima.flicker.ClassPhoto;

import java.util.List;

/**
 * Created by Human Booster on 28/11/2016.
 */

public interface FlickerResponseListener {
    public void onPhotosReceived (List<ClassPhoto> classPhotos);

}
