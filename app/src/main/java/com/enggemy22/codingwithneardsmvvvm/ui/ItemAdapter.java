package com.enggemy22.codingwithneardsmvvvm.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.enggemy22.codingwithneardsmvvvm.R;
import com.enggemy22.codingwithneardsmvvvm.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
List<PostModel> mlist= new ArrayList<>();


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        holder.txtitle.setText(mlist.get(position).getTitle());
        holder.txuserId.setText(mlist.get(position).getUserId()+"");
        holder.txpost.setText(mlist.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    public void setList(List<PostModel> moviesList) {
        this.mlist = moviesList;
        notifyDataSetChanged();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
     TextView txtitle,txuserId,txpost;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            txtitle=itemView.findViewById(R.id.title);
            txuserId=itemView.findViewById(R.id.userid);
            txpost=itemView.findViewById(R.id.post);
        }
    }

}
