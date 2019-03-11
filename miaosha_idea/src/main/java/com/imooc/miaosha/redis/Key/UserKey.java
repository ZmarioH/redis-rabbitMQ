package com.imooc.miaosha.redis.Key;

import com.imooc.miaosha.redis.BasePrefix;


/*
* 用户模块key前缀
* */
public class UserKey extends BasePrefix {


    private UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");

}
