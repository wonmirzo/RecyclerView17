package com.wonmirzo.model;

public class Message {
    private String sendersName;
    private String message;
    private String date;
    private Boolean isConnected;

    public Message(String sendersName, String message, String date, Boolean isConnected) {
        this.sendersName = sendersName;
        this.message = message;
        this.date = date;
        this.isConnected = isConnected;
    }

    public String getSendersName() {
        return sendersName;
    }

    public void setSendersName(String sendersName) {
        this.sendersName = sendersName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean isConnected() {
        return isConnected;
    }

    public void setConnected(Boolean connected) {
        isConnected = connected;
    }
}
