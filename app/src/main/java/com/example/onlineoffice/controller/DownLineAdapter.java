package com.example.onlineoffice.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineoffice.R;
import com.example.onlineoffice.model.downline.DownLineResponse;
import com.example.onlineoffice.model.downline.List3;
import com.example.onlineoffice.model.downline.Profile;
import com.example.onlineoffice.model.downline.Property;

public class DownLineAdapter extends RecyclerView.Adapter<DownLineAdapter.DownLineViewHolder>{

    private DownLineResponse downLineResponse;
    private final LayoutInflater inflater;


    public DownLineAdapter(Context context, DownLineResponse downLineResponse) {
     //   System.out.println(frontLineResponse.payload.list.size());
        this.inflater = LayoutInflater.from(context);
        this.downLineResponse = downLineResponse;
    }

    @NonNull
    @Override
    public DownLineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DownLineViewHolder(inflater.from(parent.getContext()).inflate(R.layout.downline_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DownLineViewHolder holder, int position) {
            holder.setOnboardingData(downLineResponse.payload.list.get(position));
    }

    @Override
    public int getItemCount() {
        return downLineResponse.payload.list.size();
    }

    class DownLineViewHolder extends RecyclerView.ViewHolder{


        private TextView level, id, firstName, lastName, email, pv, nv, rank;


        DownLineViewHolder(@NonNull View itemView) {
            super(itemView);
            level = itemView.findViewById(R.id.down_level);
            id = itemView.findViewById(R.id.down_id);
            firstName = itemView.findViewById(R.id.down_first);
            lastName = itemView.findViewById(R.id.down_last);
            email = itemView.findViewById(R.id.down_email);
            pv = itemView.findViewById(R.id.down_personal);
            nv = itemView.findViewById(R.id.down_network);
            rank = itemView.findViewById(R.id.down_rank);
        }
        void setOnboardingData(List3 list3) {
            id.setText(list3.accountId + "");
            level.setText(list3.level + "");
            for (Profile profile : list3.account.profile) {
                if (profile.alias.equals("email")){
                    email.setText(profile.value.presentable);
                }
                if (profile.alias.equals("firstname")){
                    firstName.setText(profile.value.presentable);
                }
                if (profile.alias.equals("lastname")){
                    lastName.setText(profile.value.presentable);
                }
            }

            for (Property property: list3.properties) {
                if (property.alias.equals("NV")){
                    nv.setText(property.value.presentable);
                }
                if (property.alias.equals("PV")){
                    pv.setText(property.value.presentable);
                }
                if (property.alias.equals("QR")){
                    rank.setText(property.value.presentable);
                }

            }

        }
    }
}
