package com.imooc.miaosha.redis;


/*
* 通用缓存key封装
*
* */
public interface KeyPrefix {


    /*有效期*/
    public int expireSeconds() ;

    /*前缀*/
    public String getPrefix();
}
