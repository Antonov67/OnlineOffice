package com.example.onlineoffice.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineoffice.R;

import com.example.onlineoffice.model.frontline.Account;
import com.example.onlineoffice.model.frontline.FrontLineResponse;
import com.example.onlineoffice.model.frontline.FrontList;
import com.example.onlineoffice.model.profile.Raw;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;


import java.util.List;

public class FrontLineAdapter extends RecyclerView.Adapter<FrontLineAdapter.FrontLineViewHolder>{

    private FrontLineResponse frontLineResponse;
    private final LayoutInflater inflater;


    public FrontLineAdapter(Context context, FrontLineResponse frontLineResponse) {
     //   System.out.println(frontLineResponse.payload.list.size());
        this.inflater = LayoutInflater.from(context);
        this.frontLineResponse = frontLineResponse;
    }

    @NonNull
    @Override
    public FrontLineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FrontLineViewHolder(inflater.from(parent.getContext()).inflate(R.layout.frontline_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FrontLineViewHolder holder, int position) {
            holder.setOnboardingData(frontLineResponse.payload.list.get(position));
    }

    @Override
    public int getItemCount() {
        return frontLineResponse.payload.list.size();
    }

    class FrontLineViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView fio, id;
        private MaterialButton button;

        FrontLineViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.front_image_view);
            fio = itemView.findViewById(R.id.front_fio_text);
            id = itemView.findViewById(R.id.front_id_text);
            button = itemView.findViewById(R.id.front_show_details_button);
        }
        void setOnboardingData(FrontList frontList) {
            id.setText(frontList.account.idValue.presentable);
            fio.setText(frontList.account.title);
        }
    }
}
