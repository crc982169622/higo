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

    private String stateInfo = "ok";

    private int stateCode = 200;

    private Object data = "";

    private int dataCount = 0;

    public ResultMessage(int stateCode) {
        this.stateCode = stateCode;
        switch (stateCode) {
            case 404:
                this.stateInfo = "接口地址不正确";
                break;
            case 405:
                this.stateInfo = "请求方法不支持";
                break;
            case 500:
                this.stateInfo = "服务内部错误";
                break;
            case 1001:
                this.stateInfo = "暂无数据";
                break;
            case 1002:
                this.stateInfo = "参数错误";
                break;
            default:
                break;
        }
    }

    public ResultMessage(String stateInfo, int stateCode, Object data, int dataCount) {
        super();
        this.stateInfo = stateInfo;
        this.stateCode = stateCode;
        this.data = data;
        this.dataCount = dataCount;
    }

    public ResultMessage() {//暂无数据
        super();
        this.stateInfo = ResultMessageConstant.CODE_EMPTY_MSG;
        this.stateCode = ResultMessageConstant.CODE_EMPTY;
        this.data = "";
        this.dataCount = 0;
    }

    public ResultMessage(Object data) { //正确
        super();
        this.stateInfo = ResultMessageConstant.CODE_OK_MSG;
        this.stateCode = ResultMessageConstant.CODE_OK;
        this.data = data;
        this.dataCount = 1;
    }

    public ResultMessage(Object Data, int DataCount) { //正确
        super();
        this.stateInfo = ResultMessageConstant.CODE_OK_MSG;
        this.stateCode = ResultMessageConstant.CODE_OK;
        this.data = Data;
        this.dataCount = DataCount;
    }


    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }
}
