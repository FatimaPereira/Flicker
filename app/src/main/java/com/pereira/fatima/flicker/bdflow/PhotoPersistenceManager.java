package com.pereira.fatima.flicker.bdflow;

import android.content.Context;
import android.util.Log;

import com.pereira.fatima.flicker.ClassPhoto;
import com.pereira.fatima.flicker.ClassPhoto_Table;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

/**
 * Created by Human Booster on 30/11/2016.
 */

public class PhotoPersistenceManager {

    public PhotoPersistenceManager(Context context) {
        FlowManager.init(new FlowConfig.Builder(context).openDatabasesOnInit(true).build());
    }

    public void savePhoto(ClassPhoto photo){
        try {
            photo.save();
        } catch (Exception e) {
            Log.w("Save Photo", e.toString());
        }
    }

    public List<ClassPhoto> getAllPhoto (String string) {
        return SQLite.select()
                .from(ClassPhoto.class)
                .queryList();
    }

    public List<ClassPhoto> getByUrl (String url) {
        return SQLite.select()
                .from(ClassPhoto.class)
                .where(ClassPhoto_Table.url.eq(url))
                .queryList();
    }

    public void deletePhoto(ClassPhoto photo){
            photo.delete();
        }

    public void getUrlPhoto(ClassPhoto photo){
            photo.save();

    }

}
