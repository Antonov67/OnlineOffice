package com.example.onlineoffice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenRequest {

    @SerializedName("login")
    @Expose
    public String login;
    @SerializedName("password")
    @Expose
    public String password;
    @SerializedName("networkAccount")
    @Expose
    public Boolean networkAccount;

    public TokenRequest(String login, String password, Boolean networkAccount) {
        this.login = login;
        this.password = password;
        this.networkAccount = networkAccount;
    }
}
