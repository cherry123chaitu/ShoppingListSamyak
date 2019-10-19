package com.example.shoppinglist;

public class Shopping_List {
    String item_name;
    int q;

    public Shopping_List() {

    }

    public Shopping_List(String item_name, int q) {
        this.item_name = item_name;
        this.q = q;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getQ() {
        return q;
    }
}
