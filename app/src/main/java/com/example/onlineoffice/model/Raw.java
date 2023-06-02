package com.example.onlineoffice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Raw {
    @SerializedName("imageUrl")
    @Expose
    public String imageUrl;
    @SerializedName("thumbUrl")
    @Expose
    public String thumbUrl;

}
