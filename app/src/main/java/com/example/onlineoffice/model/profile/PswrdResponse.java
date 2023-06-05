package com.example.onlineoffice.model.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PswrdResponse {

    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("requestId")
    @Expose
    public String requestId;

}
