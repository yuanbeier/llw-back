package com.ybe.llwback.entity.base;

/**
 * @author: beier
 * @date: 2020/3/14
 * @description: sms.platform.common.entity.base
 * 返回结果
 * @version: 1.0
 */
public class ResultEntity<T> {
    /**
     * 是否成功
     */
    private boolean success ;
    /**
     * 编码 200 成功
     */
    private int code ;

    /**
     * 消息
     */
    private String message ;

    /**
     * 数据类容
     */
    private T data;
    

    public ResultEntity(boolean success,int code,String message,T data){

        /**
         * 功能描述
         * @param [success, code, message, data]
         * @return
         * @auther beier
         * @date  2020/3/14 17:55
         */
        this.success = success;
        this.code = code;
        this.message = message;
        this.data  = data;
    }

    /**
     * 功能描述
     * @param [data]
     * @return sms.platform.common.entity.base.ResultEntity<T>
     * @auther beier
     * @date  2020/3/14 17:58
     */
    public ResultEntity<T> ok(T data){
        this.code = 200;
        this.success = true;
        this.message = "";
        this.data = data;
        return this;
    }

    public ResultEntity<T> ok(String message){
        /**
         * 功能描述
         * @param [message]
         * @return sms.platform.common.entity.base.ResultEntity<T>
         * @auther beier
         * @date  2020/3/14 18:01
         */
        this.code = 200;
        this.message = message;
        this.success = true;
        return this;
    }


    public  ResultEntity<T> error(int code,String message)
    {
        /**
         * 功能描述
         * @param [code, message]
         * @return sms.platform.common.entity.base.ResultEntity<T>
         * @auther beier
         * @date  2020/3/14 17:54
         */
        this.success = false;
        this.message = message;
        this.code = code;
        return this;
    }

    public  ResultEntity<T> error(String message)
    {
        /**
         * 功能描述
         * @param [ message]
         * @return sms.platform.common.entity.base.ResultEntity<T>
         * @auther beier
         * @date  2020/3/14 17:54
         */
        this.success = false;
        this.message = message;
        this.code = 500;
        return this;
    }

    
}
