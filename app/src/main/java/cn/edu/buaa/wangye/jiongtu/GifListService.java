package cn.edu.buaa.wangye.jiongtu;

import cn.edu.buaa.wangye.jiongtu.bean.GifItem;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface GifListService {

    @GET("/2/image/{sort}/")
    GifItem reFresh(@Path("sort") String sort,
                    @Query("tag") String tag,
                    @Query("day") String day
    );

    @GET("/2/image/{sort}/")
    void reFresh(@Path("sort") String sort,
                 @Query("tag") String tag,
                 @Query("day") String day,
            Callback<GifItem> callback

    );

    @GET("/2/image/{sort}/")
    GifItem loadMore(@Path("sort") String sort,
                     @Query("max_behot_time") String time,
                     @Query("tag") String tag,
                     @Query("day") String day
    );

    @GET("/2/image/{sort}/")
    void loadMore(@Path("sort") String sort,
                  @Query("max_behot_time") String time,
                  @Query("tag") String tag,
                  @Query("day") String day,
                  Callback<GifItem> callback
    );
}