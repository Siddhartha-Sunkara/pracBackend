package com.daoprac.dao.models;

public class CustomResponse<T> {
    private final String status;
    private final T data;

    public CustomResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}

