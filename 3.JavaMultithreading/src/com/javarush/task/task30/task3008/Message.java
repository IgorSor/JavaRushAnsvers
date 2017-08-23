package com.javarush.task.task30.task3008;

import java.io.Serializable;

/**
 * Created by MadHarry on 09.05.2017.
 */
public class Message implements Serializable{

    private final String data;
    private final MessageType type;
    public Message(MessageType type) {
        this.type = type;
        this.data = null;
    }

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }

    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}

