package com.example.onlineoffice.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.onlineoffice.R;
import com.example.onlineoffice.model.frontline.FrontList;

import java.util.List;

public class ListAdapter extends ArrayAdapter<FrontList> {

    private Context mContext;
    public ListAdapter(Context context, FrontList[] items) {
        super(context, R.layout.frontline_item_layout, items);

        this.mContext = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final FrontList frontList = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.frontline_item_layout, null);
        }
        TextView id = convertView.findViewById(R.id.front_id_text);
        id.setText(frontList.accountId);
        return convertView;
    }
}