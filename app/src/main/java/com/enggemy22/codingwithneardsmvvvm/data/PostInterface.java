package com.enggemy22.codingwithneardsmvvvm.data;

import com.enggemy22.codingwithneardsmvvvm.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {

    @GET("posts")
    public Call<List<PostModel>> getAllPosts();

}
