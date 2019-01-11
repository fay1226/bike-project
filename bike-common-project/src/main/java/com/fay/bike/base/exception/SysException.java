package com.fay.bike.base.exception;

import lombok.Getter;

/**
 * 系统运行异常类
 * @author fanqingfeng
 * @date 2018/10/31 17:02
 */
@Getter
public class SysException extends RuntimeException {

    /**异常码*/
    private Integer code;
    /**异常信息*/
    private String errorMsg;

    public SysException(){
        super();
    }
    public SysException(String errorMsg){
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public SysException(String errorMsg, Integer code){
        this(errorMsg);
        this.code = code;
    }
    public SysException(Throwable throwable){
        super(throwable);
    }
    public SysException(String errorMsg, Throwable throwable){
        this(throwable);
        this.errorMsg = errorMsg;
    }
    public SysException(String errorMsg, Throwable throwable, boolean enableSuppression,
                        boolean writableStackTrace){
        super(errorMsg, throwable, enableSuppression, writableStackTrace);
    }

    @Override
    public String toString() {
        return code + ":" + errorMsg;
    }
}
