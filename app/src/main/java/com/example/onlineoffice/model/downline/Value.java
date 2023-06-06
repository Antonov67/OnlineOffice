package com.example.onlineoffice.model.downline;

public class Value {
    public Object raw;
    public String presentable;

    @Override
    public String toString() {
        return "Value{" +
                "raw=" + raw +
                ", presentable='" + presentable + '\'' +
                '}';
    }
}
