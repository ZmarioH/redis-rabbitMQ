package com.imooc.miaosha.redis;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * RedisConfig class
 *
 * @author zhuhao
 */
@Component
@ConfigurationProperties(prefix="redis")
public class RedisConfig {

    private String host;
    private int port;
    private int timeOut;
    private String password;
    private int poolMaxTotal;
    private int poolMaxIdle;
    private int maxWait;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPoolMaxTotal(int poolMaxTotal) {
        this.poolMaxTotal = poolMaxTotal;
    }

    public void setPoolMaxIdle(int poolMaxIdle) {
        this.poolMaxIdle = poolMaxIdle;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public String getPassword() {
        return password;
    }

    public int getPoolMaxTotal() {
        return poolMaxTotal;
    }

    public int getPoolMaxIdle() {
        return poolMaxIdle;
    }

    public int getMaxWait() {
        return maxWait;
    }
}
