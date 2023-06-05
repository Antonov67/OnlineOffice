package com.example.onlineoffice.model.register_member;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Payload {

    @SerializedName("info")
    @Expose
    public String info;

}

public class RegMemberResponse {

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