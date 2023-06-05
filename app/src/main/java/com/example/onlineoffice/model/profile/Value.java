package com.example.onlineoffice.model.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

    @SerializedName("raw")
    @Expose
    public Object raw;
    @SerializedName("presentable")
    @Expose
    public String presentable;

}
