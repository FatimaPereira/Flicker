package com.pereira.fatima.flicker;

/**
 * Created by Human Booster on 24/11/2016.
 */

public class ClassPhoto {
    String title;
    String url;


    // Constructeur
    public ClassPhoto(String title, String url) {
        this.title = title;
        this.url = url;
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
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
