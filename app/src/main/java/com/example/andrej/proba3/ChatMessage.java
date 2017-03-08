package com.example.andrej.proba3;

/**
 * Created by Andrej on 8.3.2017..
 */

public class ChatMessage {
    String name;
    String message;

    public ChatMessage() {
    }

    public ChatMessage(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
