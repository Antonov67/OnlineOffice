package com.example.onlineoffice.model.register_member;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("firstname")
    @Expose
    public String firstname;

    @SerializedName("lastname")
    @Expose
    public String lastname;

    public Profile(String email, String firstname, String lastname) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}