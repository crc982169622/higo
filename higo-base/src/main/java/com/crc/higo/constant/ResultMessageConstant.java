package com.crc.higo.constant;

import org.springframework.http.HttpStatus;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/12 22:37
 **/
public class ResultMessageConstant {

    /**
     * 暂无数据
     */
    public static final int CODE_EMPTY = 1001;
    public static final String CODE_EMPTY_MSG = "暂无数据";

    /**
     * OK
     */
    public static final int CODE_OK = HttpStatus.OK.value();
    public static final String CODE_OK_MSG = "ok";

    /**
     * 操作失败
     */
    public static final int CODE_DEFALT = 400;
    public static final String CODE_DEFALT_MSG = "操作失败";

    /**
     * 参数错误
     */
    public static final int CODE_CONDITION_ERROR = 1002;
    public static final String CODE_CONDITION_ERROR_MSG = "参数错误";

    /**
     * 系统异常
     */
    public static final int CODE_SYSTEM_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();
    public static final String CODE_SYSTEM_ERROR_MSG = "系统异常";

    /**
     * 参数错误
     */
    public static final int CODE_CONDITION_USE = 1100;
    public static final String CODE_CONDITION_USE_MSG = "存在相同信息记录";

    /**
     * 有子类，不能删除
     */
    public static final int CODE_NOT_DELETE = 444;
    public static final String CODE_NOT_DELETE_MSG = "存在子集，不能删除";
}
