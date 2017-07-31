package com.abe.dwwd.retrofitrxjavasimple.bean;

public class BannerimageInfo {
    public String imageurl;//广告图片地址
    private String imageaddress;//跳转的地址

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getTargetUrl() {
        return imageaddress;
    }

}
