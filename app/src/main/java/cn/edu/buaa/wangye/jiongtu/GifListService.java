package cn.edu.buaa.wangye.jiongtu;

import cn.edu.buaa.wangye.jiongtu.bean.GifItem;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GifListService {
    @GET("/2/image/recent/")
    GifItem listGifItem();

    @GET("/2/image/recent/")
    void listGifItem(Callback<GifItem> callback);


    @GET("/2/image/recent/")
    GifItem reFresh();

    @GET("/2/image/recent/")
    void reFresh(Callback<GifItem> callback);

    @GET("/2/image/recent/")
    GifItem loadMore(@Query("max_behot_time") String time);

    @GET("/2/image/recent/")
    void loadMore(@Query("max_behot_time") String time, Callback<GifItem> callback);
}