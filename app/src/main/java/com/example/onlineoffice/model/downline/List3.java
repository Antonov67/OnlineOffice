package com.example.onlineoffice.model.downline;

import java.util.ArrayList;

public class List3{
    public int id;
    public int level;
    public int treeLevel;
    public String accountId;
    public int parentPositionId;
    public ParentPosition parentPosition;
    public int number;
    public Object spillLeg;
    public int childrenCount;
    public String createdAt;
    public Account account;
    public ArrayList<Property> properties;

    @Override
    public String toString() {
        return "List3{" +
                "id=" + id +
                ", level=" + level +
                ", treeLevel=" + treeLevel +
                ", accountId='" + accountId + '\'' +
                ", parentPositionId=" + parentPositionId +
                ", parentPosition=" + parentPosition +
                ", number=" + number +
                ", spillLeg=" + spillLeg +
                ", childrenCount=" + childrenCount +
                ", createdAt='" + createdAt + '\'' +
                ", account=" + account +
                ", properties=" + properties +
                '}';
    }
}
