package com.imooc.miaosha.redis.Key;

import com.imooc.miaosha.redis.BasePrefix;


/*
* 订单模块key前缀
* */
public class OrderKey extends BasePrefix {


    private OrderKey(int expireSecond, String prefix) {
        super(expireSecond, prefix);
    }

}
