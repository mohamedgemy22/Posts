package com.enggemy22.codingwithneardsmvvvm.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.enggemy22.codingwithneardsmvvvm.data.PostClient;
import com.enggemy22.codingwithneardsmvvvm.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    MutableLiveData<List<PostModel>> postmutableLiveData= new MutableLiveData<>();

    public void getDataFromRetrofit(){
        PostClient.getInstance().getAllPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
               postmutableLiveData.setValue( response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });

    }

}
