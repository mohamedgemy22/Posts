package com.enggemy22.codingwithneardsmvvvm.data;

import com.enggemy22.codingwithneardsmvvvm.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {

    public static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    PostInterface postInterface;
    private static PostClient Instance;

    public PostClient() {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface= retrofit.create(PostInterface.class);
    }

    public static PostClient getInstance(){
        if(Instance== null){
            Instance= new PostClient();
        }
        return Instance;
    }

    public Call<List<PostModel>> getAllPosts(){
        return postInterface.getAllPosts();
    }
}
