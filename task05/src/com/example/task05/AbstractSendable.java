package com.example.task05;

public abstract class AbstractSendable<T> implements Sendable<T> {

    private final String from;
    private final String to;

    protected AbstractSendable(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }
}
