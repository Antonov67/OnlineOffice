package com.example.onlineoffice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileIn {

    @SerializedName("alias")
    @Expose
    public String alias;
    @SerializedName("value")
    @Expose
    public Value value;

}
