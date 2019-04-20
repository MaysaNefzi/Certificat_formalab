package com.example.zaefdfyjhlk.certifprojet;

public class Message {
    private int id;
    private String contenu,sender,time;

    public Message() {
    }

    public Message(String contenu, String sender , String time) {
        this.contenu = contenu;
        this.sender = sender;
        this.time = time;
    }



    public Message(int id, String contenu, String sender, String time) {
        this.id = id;
        this.contenu = contenu;
        this.sender = sender;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
