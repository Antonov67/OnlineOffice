package com.example.onlineoffice.model.frontline;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class FieldType {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("alias")
    @Expose
    public String alias;

}

public class FrontLineResponse {

    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("requestId")
    @Expose
    public String requestId;
    @SerializedName("payload")
    @Expose
    public FrontPayload payload;

}
class RawProperties {

    @SerializedName("100")
    @Expose
    public Float _100;
    @SerializedName("101")
    @Expose
    public Integer _101;

}

class Value {

    @SerializedName("raw")
    @Expose
    public String raw;
    @SerializedName("presentable")
    @Expose
    public String presentable;

}