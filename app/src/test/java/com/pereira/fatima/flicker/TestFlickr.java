package com.pereira.fatima.flicker;

import android.graphics.Picture;

import com.pereira.fatima.flicker.flickr.dto.ClassConverter;
import com.pereira.fatima.flicker.flickr.dto.FlickrPhotosDto;
import com.pereira.fatima.flicker.flickr.dto.FlickrResponseDto;
import com.pereira.fatima.flicker.flickr.dto.PhotoDto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Human Booster on 25/11/2016.
 */

public class TestFlickr {

    @Test
    public void test () throws Exception {

        List<PhotoDto> photo = new ArrayList<>();
        //photo.add(new PhotoDto("id", "owner", "secret", "server", "farm", "title", "ispublic", "isfriend", "isfamily"));
        photo.add(new PhotoDto("30861297610", "145052384@N05", "299d2972ed", "5634", "6", "4339316232", "1", "0", "0"));
        photo.add(new PhotoDto("30407771724", "145052384@N05", "d82cfff779", "5833", "6", "3488367654", "1", "0", "0"));


        //FlickrPhotosDto flickrPhotosDto = new FlickrPhotosDto("page","pages","perpage","total")
        FlickrPhotosDto flickrPhotosDto = new FlickrPhotosDto("1", "65447","5","327232", photo);

        //FlickrResponseDto flickrResponseDto = new FlickrResponseDto("photos","stat");
        FlickrResponseDto flickrResponseDto = new FlickrResponseDto(flickrPhotosDto,"OK");

        List<ClassPhoto> classPhotos = new ArrayList<>();
       // pictureList.add(new Picture("title", "//https://farmfarm.static.flickr.com/server/id_secret.jpg) );
        classPhotos.add(new ClassPhoto("4339316232", "https://farm6.static.flickr.com/5634/30861297610_299d2972ed.jpg") );
        classPhotos.add(new ClassPhoto("3488367654", "https://farm6.static.flickr.com/5833/30407771724_d82cfff779.jpg") );

        ClassConverter classConverter = new ClassConverter();
        List<ClassPhoto> convertClassPhoto = classConverter.convert(flickrResponseDto);



        assertEquals(classPhotos.toString(), convertClassPhoto.toString());
    }
}
