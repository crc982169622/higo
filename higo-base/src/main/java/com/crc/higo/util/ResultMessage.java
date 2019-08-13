package com.crc.higo.util;

import com.crc.higo.constant.ResultMessageConstant;

import java.io.Serializable;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/12 22:29
 **/
public class ResultMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String stateInfo = "success";

    private Object errorMessage = "";

    public ResultMessage(String stateInfo, Object errorMessage) {
        this.stateInfo = stateInfo;
        this.errorMessage = errorMessage;
    }

    public ResultMessage() {
        super();
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }
}
