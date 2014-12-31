package cn.edu.buaa.wangye.jiongtu.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Datum {

    @SerializedName("large_height")
    @Expose
    private Integer largeHeight;
    @SerializedName("user_bury")
    @Expose
    private Integer userBury;
    @SerializedName("user_repin_time")
    @Expose
    private Integer userRepinTime;
    @Expose
    private String format;
    @SerializedName("large_url_list")
    @Expose
    private List<LargeUrlList> largeUrlList = new ArrayList<LargeUrlList>();
    @SerializedName("tag_id")
    @Expose
    private Long tagId;
    @SerializedName("middle_width")
    @Expose
    private Integer middleWidth;
    @Expose
    private String tag;
    @SerializedName("share_url")
    @Expose
    private String shareUrl;
    @SerializedName("middle_url_list")
    @Expose
    private List<MiddleUrlList> middleUrlList = new ArrayList<MiddleUrlList>();
    @SerializedName("user_digg")
    @Expose
    private Integer userDigg;
    @SerializedName("thumbnail_url_list")
    @Expose
    private List<ThumbnailUrlList> thumbnailUrlList = new ArrayList<ThumbnailUrlList>();
    @SerializedName("is_gif")
    @Expose
    private Boolean isGif;
    @Expose
    private String description;
    @SerializedName("large_url")
    @Expose
    private String largeUrl;
    @SerializedName("bury_count")
    @Expose
    private Integer buryCount;
    @SerializedName("repin_count")
    @Expose
    private Integer repinCount;
    @Expose
    private Integer level;
    @SerializedName("digg_count")
    @Expose
    private Integer diggCount;
    @SerializedName("behot_time")
    @Expose
    private Integer behotTime;
    @SerializedName("middle_url")
    @Expose
    private String middleUrl;
    @SerializedName("comment_count")
    @Expose
    private Integer commentCount;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("is_shorten")
    @Expose
    private Boolean isShorten;
    @SerializedName("user_repin")
    @Expose
    private Integer userRepin;
    @SerializedName("middle_height")
    @Expose
    private Integer middleHeight;
    @SerializedName("group_id")
    @Expose
    private Long groupId;
    @SerializedName("large_width")
    @Expose
    private Integer largeWidth;

    /**
     *
     * @return
     * The largeHeight
     */
    public Integer getLargeHeight() {
        return largeHeight;
    }

    /**
     *
     * @param largeHeight
     * The large_height
     */
    public void setLargeHeight(Integer largeHeight) {
        this.largeHeight = largeHeight;
    }

    /**
     *
     * @return
     * The userBury
     */
    public Integer getUserBury() {
        return userBury;
    }

    /**
     *
     * @param userBury
     * The user_bury
     */
    public void setUserBury(Integer userBury) {
        this.userBury = userBury;
    }

    /**
     *
     * @return
     * The userRepinTime
     */
    public Integer getUserRepinTime() {
        return userRepinTime;
    }

    /**
     *
     * @param userRepinTime
     * The user_repin_time
     */
    public void setUserRepinTime(Integer userRepinTime) {
        this.userRepinTime = userRepinTime;
    }

    /**
     *
     * @return
     * The format
     */
    public String getFormat() {
        return format;
    }

    /**
     *
     * @param format
     * The format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     *
     * @return
     * The largeUrlList
     */
    public List<LargeUrlList> getLargeUrlList() {
        return largeUrlList;
    }

    /**
     *
     * @param largeUrlList
     * The large_url_list
     */
    public void setLargeUrlList(List<LargeUrlList> largeUrlList) {
        this.largeUrlList = largeUrlList;
    }

    /**
     *
     * @return
     * The tagId
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     *
     * @param tagId
     * The tag_id
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    /**
     *
     * @return
     * The middleWidth
     */
    public Integer getMiddleWidth() {
        return middleWidth;
    }

    /**
     *
     * @param middleWidth
     * The middle_width
     */
    public void setMiddleWidth(Integer middleWidth) {
        this.middleWidth = middleWidth;
    }

    /**
     *
     * @return
     * The tag
     */
    public String getTag() {
        return tag;
    }

    /**
     *
     * @param tag
     * The tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     *
     * @return
     * The shareUrl
     */
    public String getShareUrl() {
        return shareUrl;
    }

    /**
     *
     * @param shareUrl
     * The share_url
     */
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    /**
     *
     * @return
     * The middleUrlList
     */
    public List<MiddleUrlList> getMiddleUrlList() {
        return middleUrlList;
    }

    /**
     *
     * @param middleUrlList
     * The middle_url_list
     */
    public void setMiddleUrlList(List<MiddleUrlList> middleUrlList) {
        this.middleUrlList = middleUrlList;
    }

    /**
     *
     * @return
     * The userDigg
     */
    public Integer getUserDigg() {
        return userDigg;
    }

    /**
     *
     * @param userDigg
     * The user_digg
     */
    public void setUserDigg(Integer userDigg) {
        this.userDigg = userDigg;
    }

    /**
     *
     * @return
     * The thumbnailUrlList
     */
    public List<ThumbnailUrlList> getThumbnailUrlList() {
        return thumbnailUrlList;
    }

    /**
     *
     * @param thumbnailUrlList
     * The thumbnail_url_list
     */
    public void setThumbnailUrlList(List<ThumbnailUrlList> thumbnailUrlList) {
        this.thumbnailUrlList = thumbnailUrlList;
    }

    /**
     *
     * @return
     * The isGif
     */
    public Boolean getIsGif() {
        return isGif;
    }

    /**
     *
     * @param isGif
     * The is_gif
     */
    public void setIsGif(Boolean isGif) {
        this.isGif = isGif;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The largeUrl
     */
    public String getLargeUrl() {
        return largeUrl;
    }

    /**
     *
     * @param largeUrl
     * The large_url
     */
    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    /**
     *
     * @return
     * The buryCount
     */
    public Integer getBuryCount() {
        return buryCount;
    }

    /**
     *
     * @param buryCount
     * The bury_count
     */
    public void setBuryCount(Integer buryCount) {
        this.buryCount = buryCount;
    }

    /**
     *
     * @return
     * The repinCount
     */
    public Integer getRepinCount() {
        return repinCount;
    }

    /**
     *
     * @param repinCount
     * The repin_count
     */
    public void setRepinCount(Integer repinCount) {
        this.repinCount = repinCount;
    }

    /**
     *
     * @return
     * The level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     *
     * @param level
     * The level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     *
     * @return
     * The diggCount
     */
    public Integer getDiggCount() {
        return diggCount;
    }

    /**
     *
     * @param diggCount
     * The digg_count
     */
    public void setDiggCount(Integer diggCount) {
        this.diggCount = diggCount;
    }

    /**
     *
     * @return
     * The behotTime
     */
    public Integer getBehotTime() {
        return behotTime;
    }

    /**
     *
     * @param behotTime
     * The behot_time
     */
    public void setBehotTime(Integer behotTime) {
        this.behotTime = behotTime;
    }

    /**
     *
     * @return
     * The middleUrl
     */
    public String getMiddleUrl() {
        return middleUrl;
    }

    /**
     *
     * @param middleUrl
     * The middle_url
     */
    public void setMiddleUrl(String middleUrl) {
        this.middleUrl = middleUrl;
    }

    /**
     *
     * @return
     * The commentCount
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     *
     * @param commentCount
     * The comment_count
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     *
     * @return
     * The thumbnailUrl
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     *
     * @param thumbnailUrl
     * The thumbnail_url
     */
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    /**
     *
     * @return
     * The isShorten
     */
    public Boolean getIsShorten() {
        return isShorten;
    }

    /**
     *
     * @param isShorten
     * The is_shorten
     */
    public void setIsShorten(Boolean isShorten) {
        this.isShorten = isShorten;
    }

    /**
     *
     * @return
     * The userRepin
     */
    public Integer getUserRepin() {
        return userRepin;
    }

    /**
     *
     * @param userRepin
     * The user_repin
     */
    public void setUserRepin(Integer userRepin) {
        this.userRepin = userRepin;
    }

    /**
     *
     * @return
     * The middleHeight
     */
    public Integer getMiddleHeight() {
        return middleHeight;
    }

    /**
     *
     * @param middleHeight
     * The middle_height
     */
    public void setMiddleHeight(Integer middleHeight) {
        this.middleHeight = middleHeight;
    }

    /**
     *
     * @return
     * The groupId
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     *
     * @param groupId
     * The group_id
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     *
     * @return
     * The largeWidth
     */
    public Integer getLargeWidth() {
        return largeWidth;
    }

    /**
     *
     * @param largeWidth
     * The large_width
     */
    public void setLargeWidth(Integer largeWidth) {
        this.largeWidth = largeWidth;
    }

}