package com.pereira.fatima.flicker.flickr.dto;

import com.pereira.fatima.flicker.flickr.dto.FlickrPhotosDto;

/**
 * Created by Human Booster on 25/11/2016.
 */

public class FlickrResponseDto {
    private FlickrPhotosDto photos;
    private String stat;


    //***************************************************
    //            CONSTRUCTEUR
    //***************************************************

    public FlickrResponseDto(FlickrPhotosDto photos, String stat) {
        this.photos = photos;
        this.stat = stat;
    }

    //Constructeur vide (normalement par défaut)
    // sauf quand on utilise un autre constructeur, il faut le rajouter car celui par défaut est écrasé

    public FlickrResponseDto() {
    }


    //***************************************************
    //            GETTER & SETTER
    //***************************************************

    public FlickrPhotosDto getPhotos() {
        return photos;
    }

    public void setPhotos(FlickrPhotosDto photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "FlickrResponseDto{" +
                "photos=" + photos +
                ", stat='" + stat + '\'' +
                '}';
    }
}
