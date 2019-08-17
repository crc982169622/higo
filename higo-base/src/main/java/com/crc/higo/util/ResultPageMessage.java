package com.crc.higo.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/17 22:52
 **/
public class ResultPageMessage<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code = 200;

    private String msg;

    private Long count;

    private List<T> data;

    public ResultPageMessage(Long count, List<T> data) {
        this.count = count;
        this.data = data;
    }

    public ResultPageMessage() {
        super();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
