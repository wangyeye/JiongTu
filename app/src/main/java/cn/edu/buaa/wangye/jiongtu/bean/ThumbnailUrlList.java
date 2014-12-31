package cn.edu.buaa.wangye.jiongtu.bean;

import com.google.gson.annotations.Expose;


public class ThumbnailUrlList {

    @Expose
    private String url;

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}