package com.dazhou.entity;

public class ResultData<T> {
    private String msg;
    private T data;
    private int code;
    private long count;

    public ResultData(String msg, T data, int code, long count) {
        this.msg = msg;
        this.data = data;
        this.code = code;
        this.count = count;
    }
    public ResultData()
    {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "layuiTableeResult{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                ", code=" + code +
                ", count=" + count +
                '}';
    }
}

