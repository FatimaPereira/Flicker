package com.pereira.fatima.flicker.service;

import com.pereira.fatima.flicker.flickr.dto.FlickrResponseDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Human Booster on 28/11/2016.
 */

public interface FlickerRetrofit {

    @GET("services/rest/?method=flickr.photos.search&per_page=20&format=json&nojsoncallback=1")
    Call<FlickrResponseDto> getPhotosRetrofit(@Query("tags") String query, @Query("api_key")String apiKey);
}
