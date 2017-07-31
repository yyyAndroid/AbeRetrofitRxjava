package com.abe.dwwd.retrofitrxjavasimple.bean;

/**
 * Created by abe on 2017/7/26.
 */

public class Ica {
    int status;
    Content content;
    public static class Content{
        String from;
        String to;
        String out;
        String vendor;
        String err_no;
    }
}
