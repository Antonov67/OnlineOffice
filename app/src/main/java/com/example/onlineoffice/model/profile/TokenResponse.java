package com.example.onlineoffice.model.profile;

import com.example.onlineoffice.model.profile.Payload;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenResponse {

    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("requestId")
    @Expose
    public String requestId;
    @SerializedName("payload")
    @Expose
    public Payload payload;
}

