package com.example.trashbusters;

/**
 * Created by Daniel Oh
 * this is invoice class for project
 */

public class invoice {

    public int id;
    public String name;
    public String itemInfo;
    public String pay;
    public String time;
    public String status;

    public invoice(){

    }

    public invoice(int id_, String name_, String itemInfo_, String pay_, String time_, String status_) {
        this.id = id_;
        this.name = name_;
        this.itemInfo = itemInfo_;
        this.pay = pay_;
        this.time = time_;
        this.status = status_;
    }

    public void setId(int n) {
        this.id = n;
    }

    public int getId() {
        return id;
    }

    public void setName(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    public void setItemInfo(String s) {
        this.itemInfo = s;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setPay(String s) {
        this.pay = s;
    }

    public String getPay() {
        return pay;
    }

    public void setTime(String s) {
        this.time = s;
    }

    public String getTime() {
        return time;
    }

    public void setStatus(String s) {
        this.status = s;
    }

    public String getStatus() {
        return status;
    }

}
