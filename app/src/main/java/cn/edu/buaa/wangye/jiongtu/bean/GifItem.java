package cn.edu.buaa.wangye.jiongtu.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GifItem {

    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @Expose
    private String message;
    @Expose
    private List<Datum> data = new ArrayList<Datum>();
    @SerializedName("total_number")
    @Expose
    private Integer totalNumber;

    /**
     *
     * @return
     * The hasMore
     */
    public Boolean getHasMore() {
        return hasMore;
    }

    /**
     *
     * @param hasMore
     * The has_more
     */
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }

    /**
     *
     * @return
     * The totalNumber
     */
    public Integer getTotalNumber() {
        return totalNumber;
    }

    /**
     *
     * @param totalNumber
     * The total_number
     */
    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

}