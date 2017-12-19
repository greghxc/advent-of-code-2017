package org.hacksy.day18;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    List<T> messages;
    Integer cursor;

    Queue() {
        messages = new ArrayList<>();
        cursor = 0;
    }

    void addMsg(T message) {
        messages.add(message);
    }

    boolean hasNext() {
        return cursor < messages.size();
    }

    T getMsg() {
        T message = messages.get(cursor);
        cursor++;
        return message;
    }
}
