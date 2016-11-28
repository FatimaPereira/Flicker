package com.pereira.fatima.flicker.flickr.dto;

/**
 * Created by Human Booster on 25/11/2016.
 */

public class PhotoDto {
    String id;
    String owner;
    String secret;
    String server;
    String farm;
    String title;
    String ispublic;
    String isfriend;
    String isfamily;


    //***************************************************
    //            CONSTRUCTEUR
    //***************************************************

    public PhotoDto(String id, String owner, String secret, String server, String farm, String title, String ispublic, String isfriend, String isfamily) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
    }


    //Constructeur vide (normalement par défaut)
    // sauf quand on utilise un autre constructeur, il faut le rajouter car celui par défaut est écrasé

    public PhotoDto() {

    }



    //***************************************************
    //            GETTER & SETTER
    //***************************************************

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIspublic() {
        return ispublic;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    public String getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(String isfriend) {
        this.isfriend = isfriend;
    }

    public String getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(String isfamily) {
        this.isfamily = isfamily;
    }

    @Override
    public String toString() {
        return "PhotoDto{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", secret='" + secret + '\'' +
                ", server='" + server + '\'' +
                ", farm='" + farm + '\'' +
                ", title='" + title + '\'' +
                ", ispublic='" + ispublic + '\'' +
                ", isfriend='" + isfriend + '\'' +
                ", isfamily='" + isfamily + '\'' +
                '}';
    }
}
