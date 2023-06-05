package com.example.onlineoffice.model.frontline;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FrontPayload {
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("list")
    @Expose
    public List<FrontList> list;

}