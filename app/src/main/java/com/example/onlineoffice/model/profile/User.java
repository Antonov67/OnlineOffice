package com.example.onlineoffice.model.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("login")
    @Expose
    public String login;
    @SerializedName("registered_at")
    @Expose
    public String registeredAt;
    @SerializedName("profileFields")
    @Expose
    public Object profileFields;

}
