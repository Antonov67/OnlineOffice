package com.example.onlineoffice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class IdValue {

    @SerializedName("raw")
    @Expose
    public String raw;
    @SerializedName("presentable")
    @Expose
    public String presentable;

}







public class Profile {

    @SerializedName("payload")
    @Expose
    public PayloadProfile payload;
    @SerializedName("error")
    @Expose
    public Object error;
    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("requestId")
    @Expose
    public String requestId;

    @Override
    public String toString() {
        return "Profile{" +
                "payload=" + payload +
                ", error=" + error +
                ", success=" + success +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}









