package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一的响应，对应有统一的结构
 * T泛型
 * @Data是lombok注解，用于生成get set
 * @NoArgsConstructor无参的构造函数
 * @AllArgsConstructor全参的构造函数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public  CommonResponse(Integer code,String message){

        this.code = code;

        this.message = message;

    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
