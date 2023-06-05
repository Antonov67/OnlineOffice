package com.example.onlineoffice.model.frontline;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FrontList {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("parent_id")
    @Expose
    public Integer parentId;
    @SerializedName("account_id")
    @Expose
    public Integer accountId;
    @SerializedName("number")
    @Expose
    public Integer number;
    @SerializedName("offset")
    @Expose
    public Integer offset;
    @SerializedName("hasChild")
    @Expose
    public Integer hasChild;
    @SerializedName("account")
    @Expose
    public Account account;
    @SerializedName("rawProperties")
    @Expose
    public RawProperties rawProperties;
    @SerializedName("properties")
    @Expose
    public List<Property> properties;

    @Override
    public String toString() {
        return "FrontList{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", accountId=" + accountId +
                ", number=" + number +
                ", offset=" + offset +
                ", hasChild=" + hasChild +
                ", account=" + account +
                ", rawProperties=" + rawProperties +
                ", properties=" + properties +
                '}';
    }
}
