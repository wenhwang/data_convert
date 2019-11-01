package com.example.utils;

public enum ResultCode {

    SUCCESS(1,"成功"),
    FAILURE(0,"失败");

    private  int code;

    private  String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }




}
