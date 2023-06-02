package com.example.onlineoffice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {

    @SerializedName("accessToken")
    @Expose
    public String accessToken;
    @SerializedName("refreshToken")
    @Expose
    public String refreshToken;

}