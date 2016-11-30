package com.pereira.fatima.flicker;

import com.pereira.fatima.flicker.bdflow.DatabasePhoto;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Human Booster on 24/11/2016.
 */

@Table(database = DatabasePhoto.class)

public class ClassPhoto extends BaseModel {
    @Column
    @PrimaryKey(autoincrement = true)
    private long id;
    @Column
    private String title;
    @Column
    private String url;


    //***************************************************
    //            CONSTRUCTEUR
    //***************************************************

    public ClassPhoto(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public ClassPhoto() {
    }

    //***************************************************
    //            GETTER & SETTER
    //***************************************************


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ClassPhoto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
