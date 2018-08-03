package com.tian.controller;

import com.tian.common.other.ResponseData;

/**
 * Created by Administrator on 2018/8/2 0002.
 */
public abstract class BaseController {
    protected static ResponseData SUCCESS_RESPONSE = ResponseData.successData;
    protected static ResponseData FAILED_RESPONSE = ResponseData.failedData;
}
