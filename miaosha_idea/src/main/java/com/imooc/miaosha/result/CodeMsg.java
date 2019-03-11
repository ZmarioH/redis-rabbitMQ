package com.imooc.miaosha.result;

public class CodeMsg {

    private Integer code;
    private String msg;

    //通用异常
    private static CodeMsg SUCCESS = new CodeMsg(0,"success");
    private static CodeMsg SERVCER_ERROR = new CodeMsg(500100,"服务端异常");

    //登录模块5002xx

    //商品模块5003xx

    //订单模块5004xx

    //秒杀模块5005xx

    private CodeMsg (int code ,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}
