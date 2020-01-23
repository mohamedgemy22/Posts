package com.enggemy22.codingwithneardsmvvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.enggemy22.codingwithneardsmvvvm.R;
import com.enggemy22.codingwithneardsmvvvm.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView= findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        final ItemAdapter adapter= new ItemAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModel= ViewModelProviders.of(this).get(PostViewModel.class);
        viewModel.getDataFromRetrofit();
        viewModel.postmutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
               adapter.setList(postModels);
            }
        });

    }
}
