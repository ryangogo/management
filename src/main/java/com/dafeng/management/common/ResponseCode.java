package com.dafeng.management.common;

/**
 * describe：
 * Created with IDEA
 * author:ryan
 * Date:2019/8/27
 * Time:下午2:37
 */

public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc() {
        return desc;
    }



}
