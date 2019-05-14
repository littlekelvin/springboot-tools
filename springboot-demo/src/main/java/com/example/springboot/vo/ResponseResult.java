package com.example.springboot.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */

@ApiModel("response model object")
public class ResponseResult<T> {
    @ApiModelProperty(value = "响应码", name = "code", required = true, example = "0")
    private int code;
    @ApiModelProperty(value = "响应消息", name = "message", required = true, example = "success")
    private String message;
    @ApiModelProperty(value = "响应数据体", name = "data")
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
