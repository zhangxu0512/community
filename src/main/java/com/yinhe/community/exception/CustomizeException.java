package com.yinhe.community.exception;

/**
 * @author 张旭
 * @create 2021-03-29 13:48
 */
public class CustomizeException extends  RuntimeException{
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode){
        this.code=errorCode.getCode();
        this.message=errorCode.getMessage();
    }
    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
