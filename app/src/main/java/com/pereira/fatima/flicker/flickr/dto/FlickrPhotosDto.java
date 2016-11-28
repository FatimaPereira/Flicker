package com.pereira.fatima.flicker.flickr.dto;

import com.pereira.fatima.flicker.flickr.dto.PhotoDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Human Booster on 25/11/2016.
 */

public class FlickrPhotosDto {
    private String page;
    private String pages;
    private String perpage;
    private String total;
    private List<PhotoDto> photo = new ArrayList<>();

    //***************************************************
    //            CONSTRUCTEUR
    //***************************************************


    public FlickrPhotosDto(String page, String pages, String perpage, String total, List<PhotoDto> photo) {
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photo = photo;
    }

    //Constructeur vide (normalement par défaut)
    // sauf quand on utilise un autre constructeur, il faut le rajouter car celui par défaut est écrasé
    public FlickrPhotosDto() {
    }

    //***************************************************
    //            GETTER & SETTER
    //***************************************************

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPerpage() {
        return perpage;
    }

    public void setPerpage(String perpage) {
        this.perpage = perpage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<PhotoDto> getPhoto() {
        return photo;
    }

    public void setPhoto(List<PhotoDto> photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "FlickrPhotosDto{" +
                "page='" + page + '\'' +
                ", pages='" + pages + '\'' +
                ", perpage='" + perpage + '\'' +
                ", total='" + total + '\'' +
                ", photo=" + photo +
                '}';
    }
}
