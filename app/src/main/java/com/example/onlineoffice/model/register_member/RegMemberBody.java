package com.example.onlineoffice.model.register_member;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RegMemberBody {

    @SerializedName("login")
    @Expose
    public String login;
    @SerializedName("sponsorId")
    @Expose
    public Integer sponsorId;
    @SerializedName("password")
    @Expose
    public String password;
    @SerializedName("profile")
    @Expose
    public Profile profile;

    public RegMemberBody(String login, Integer sponsorId, String password, Profile profile) {
        this.login = login;
        this.sponsorId = sponsorId;
        this.password = password;
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "RegMemberBody{" +
                "login='" + login + '\'' +
                ", sponsorId=" + sponsorId +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                '}';
    }
}