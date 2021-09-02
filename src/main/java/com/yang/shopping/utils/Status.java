package com.yang.shopping.utils;

public class Status {
    private int status;
    private String message;

    public Status(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Status() {
    }

    @Override
    public String toString() {
        return "Status{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
