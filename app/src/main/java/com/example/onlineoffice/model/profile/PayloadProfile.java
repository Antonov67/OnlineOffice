package com.example.onlineoffice.model.profile;

import com.example.onlineoffice.model.profile.IdValue;
import com.example.onlineoffice.model.profile.ProfileIn;
import com.example.onlineoffice.model.profile.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PayloadProfile {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("idValue")
    @Expose
    public IdValue idValue;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("activated_at")
    @Expose
    public String activatedAt;
    @SerializedName("invite_code")
    @Expose
    public String inviteCode;
    @SerializedName("users")
    @Expose
    public List<User> users;
    @SerializedName("profile")
    @Expose
    public List<ProfileIn> profile;

    @Override
    public String toString() {
        return "PayloadProfile{" +
                "id='" + id + '\'' +
                ", idValue=" + idValue +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", createdAt='" + createdAt + '\'' +
                ", activatedAt='" + activatedAt + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                ", users=" + users +
                ", profile=" + profile +
                '}';
    }
}