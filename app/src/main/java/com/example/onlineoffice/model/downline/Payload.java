package com.example.onlineoffice.model.downline;

import java.util.ArrayList;

public class Payload{
    public ArrayList<List3> list;
    public int total;

    @Override
    public String toString() {
        return "Payload{" +
                "list=" + list +
                ", total=" + total +
                '}';
    }
}