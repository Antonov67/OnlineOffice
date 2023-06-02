package com.example.onlineoffice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayloadBonus {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("alias")
    @Expose
    public String alias;
    @SerializedName("currency_id")
    @Expose
    public String currencyId;
    @SerializedName("balance")
    @Expose
    public String balance;
}
