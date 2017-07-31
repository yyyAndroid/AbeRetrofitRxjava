package com.abe.dwwd.rxretrofithttputils.base;


/**
 * 结果bean
 */
public class ResultBean<R> {

    public Boolean succeed;
    public int    errCode;
    public String errMsg;
    public R data;

  /*  public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public R getData() {
        return data;
    }

    public void setData(R data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "succeed=" + succeed +
                ", errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                ", data=" + data +
                '}';
    }*/
}
