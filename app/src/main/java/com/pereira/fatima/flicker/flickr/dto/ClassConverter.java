package com.pereira.fatima.flicker.flickr.dto;

import com.pereira.fatima.flicker.ClassPhoto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Human Booster on 25/11/2016.
 */

public class ClassConverter {

    public List<ClassPhoto> convert(FlickrResponseDto flickrResponseDto) {
        List<ClassPhoto> converti = new ArrayList<>();
        List<PhotoDto> photoDtoList = flickrResponseDto.getPhotos().getPhoto();

        for (PhotoDto photoDto : photoDtoList ){
            String titre = photoDto.getTitle();
            String farm = photoDto.getFarm();
            String server = photoDto.getServer();
            String id = photoDto.getId();
            String secret = photoDto.getSecret();
            ClassPhoto classPhoto = new ClassPhoto(titre, "https://farm"+farm+".static.flickr.com/"+server+"/"+id+"_"+secret+".jpg");
            converti.add(classPhoto);
        }

       return  converti;
    }

}
