package com.example;

/**
 * Created by Andrew Shubin on 10/19/16.
 */
public class Greeting {

    private int id;
    private String content;

    public Greeting(int id, String content) {
        this.content = content;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
