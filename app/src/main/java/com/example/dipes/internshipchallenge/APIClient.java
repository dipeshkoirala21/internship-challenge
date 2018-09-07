package com.example.dipes.internshipchallenge;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIClient {
    String BASE_URL="https://jsonplaceholder.typicode.com/";

    @GET("posts/")
    Call<List<PostData>> getPosts();

}
