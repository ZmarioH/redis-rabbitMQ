package com.imooc.miaosha.redis;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /*获取单个对象*/
    public <T> T get(KeyPrefix prefix,String key, Class<T> claszz)
    {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的Key
            String realKey = prefix.getPrefix() + key;
            String str = jedis.get(realKey);
            T t = stringToBean(str,claszz);
            return t;
        }finally {
            returnToPool(jedis);
        }
    }

    /*获取对象*/
    public <T> boolean set(KeyPrefix prefix,String key, T value)
    {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            //生成真正的Key
            String realKey = prefix.getPrefix() + key;
            int expireSeconds = prefix.expireSeconds();
            if (expireSeconds <= 0){
                //永不过期
                jedis.set(realKey,str);
            }else{
                jedis.setex(realKey,expireSeconds,str);
            }
            return true;
        }finally {
            returnToPool(jedis);
        }
    }

    /*判断是否存在*/
    public <T> boolean exits(KeyPrefix prefix,String key)
    {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的Key
            String realKey = prefix.getPrefix() + key;
            return jedis.exists(realKey);
        }finally {
            returnToPool(jedis);
        }
    }

    /*增加量*/
    public <T> Long incr(KeyPrefix prefix,String key)
    {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的Key
            String realKey = prefix.getPrefix() + key;
            return jedis.incr(realKey);
        }finally {
            returnToPool(jedis);
        }
    }

    /*减少量*/
    public <T> Long decr(KeyPrefix prefix,String key)
    {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的Key
            String realKey = prefix.getPrefix() + key;
            return jedis.decr(realKey);
        }finally {
            returnToPool(jedis);
        }
    }

    /*
    * 类型转字符串
    * 剩余其他类型待完善
    * */
    private <T> String beanToString(T value) {
        if (value == null){
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class){
            return ""+value;

        }else if (clazz == long.class || clazz == Long.class){
            return ""+value;

        }else if (clazz == String.class){
            return (String)value;
        }else{
        return JSON.toJSONString(value);
        }

    }

    /*
    * 字符串转对应类型
    * */
    private <T> T stringToBean(String str,Class<T> clazz) {

        if (str == null || str.length()<0 || clazz == null){
            return null;
        }
        if (clazz == int.class || clazz == Integer.class){
            return (T) Integer.valueOf(str);

        }else if (clazz == long.class || clazz == Long.class){
            return (T) Long.valueOf(str);

        }else if (clazz == String.class){
            return (T) str;
        }else{
            return JSON.toJavaObject(JSON.parseObject(str),clazz);
        }

    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null){
            jedis.close();
        }
    }
}


