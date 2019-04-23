package com.imooc.miaosha.redis;

/**
 * BasePrefix class
 * @author zhuhao
 */
public abstract class BasePrefix implements KeyPrefix {

    private int expireSeconds;

    private String prefix;


    public BasePrefix(String prefix){//默认永不过期0
        this(0,prefix);

    }
    public BasePrefix(int expireSecond, String prefix) {
        this.expireSeconds = expireSecond;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className+":"+prefix;
    }
}
