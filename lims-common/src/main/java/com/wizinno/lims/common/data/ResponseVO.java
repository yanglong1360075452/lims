package com.wizinno.lims.common.data;

import java.io.Serializable;

/**
 * @author LiuMei on 2017-05-22.
 */
public class ResponseVO implements Serializable{
    private Integer code;

    private Object data;

    public ResponseVO(){
        this.code = 0;
    }

    public ResponseVO(Integer code){
        this.code = code;
    }

    public ResponseVO(Object data){
        this.code = 0;
        this.data = data;
    }

    public ResponseVO(Integer code, Object data){
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
