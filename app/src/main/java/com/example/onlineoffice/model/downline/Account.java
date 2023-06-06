package com.example.onlineoffice.model.downline;

import java.util.ArrayList;

public class Account {
    public String id;
    public IdValue idValue;
    public int status;
    public String created_at;
    public String activated_at;
    public ArrayList<Profile> profile;

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", idValue=" + idValue +
                ", status=" + status +
                ", created_at='" + created_at + '\'' +
                ", activated_at='" + activated_at + '\'' +
                ", profile=" + profile +
                '}';
    }
}
