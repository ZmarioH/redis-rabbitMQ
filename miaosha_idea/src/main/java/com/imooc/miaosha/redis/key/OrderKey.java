package com.imooc.miaosha.redis.key;

import com.imooc.miaosha.redis.BasePrefix;


/*
* 订单模块key前缀
* */
public class OrderKey extends BasePrefix {


    private OrderKey(int expireSecond, String prefix) {
        super(expireSecond, prefix);
    }

}
