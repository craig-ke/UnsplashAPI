package com.craigke.picflicbackup.api;

import com.craigke.picflicbackup.models.UnsplashAPIResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UnsplashInterface {
    @GET("/search/photos")
    Call<UnsplashAPIResponse> getSearchPhotos(
            @Query("query") String location,
            @Query("client_id") String apiKey
    );
}
//    @GET("businesses/search")
//    Call<UnsplashAPIResponse> getSearchPhotos(
//            @Query("location") String location,
//            @Query("term") String term
//    );
//}