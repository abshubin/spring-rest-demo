package com.example;

/**
 * Created by Andrew Shubin on 10/19/16.
 */
public class Greeting {

    private int id;
    private String content;

    public Greeting() {
        this.content = "";
        this.id = 0;
    }

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

    public void setContent(String message) {
        this.content = message;
    }

    public String getContent() {
        return content;
    }
}
