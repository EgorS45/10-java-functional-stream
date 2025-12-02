package com.example.task05;

public class Salary extends AbstractSendable<Integer> {

    private final Integer content;

    public Salary(String from, String to, Integer content) {
        super(from, to);
        this.content = content;
    }

    @Override
    public Integer getContent() {
        return content;
    }
}
