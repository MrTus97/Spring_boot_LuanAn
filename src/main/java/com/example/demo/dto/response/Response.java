package com.example.demo.dto.response;

public class Response<T> {
    private int success;
    private T data;
    private String message;

    public Response() {
    }

    public Response(int success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public int isSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
