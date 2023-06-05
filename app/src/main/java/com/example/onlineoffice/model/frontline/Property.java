package com.example.onlineoffice.model.frontline;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Property {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("fieldType")
    @Expose
    public FieldType fieldType;
    @SerializedName("dictionary_id")
    @Expose
    public Object dictionaryId;
    @SerializedName("alias")
    @Expose
    public String alias;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("order")
    @Expose
    public Integer order;
    @SerializedName("value")
    @Expose
    public Value value;

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", fieldType=" + fieldType +
                ", dictionaryId=" + dictionaryId +
                ", alias='" + alias + '\'' +
                ", description='" + description + '\'' +
                ", order=" + order +
                ", value=" + value +
                '}';
    }
}