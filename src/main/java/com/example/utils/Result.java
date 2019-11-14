package com.example.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T > implements Serializable {

    private int code;

    private int count = 0;

    private String message;

    private T data;

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
        if(data instanceof Collection){
            this.count = ((Collection)data).size();
        }
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    //返回成功
    public  static <T> Result<T> success(T data){
        return new Result<T>(ResultCode.SUCCESS,data);
    }

    //返回失败
    public  static <T> Result<T> failure(ResultCode resultCode){
        return new Result<T>(resultCode);
    }

    //返回失败
    public  static <T> Result<T> failure(){
        return new Result<T>(ResultCode.FAILURE);
    }
}
