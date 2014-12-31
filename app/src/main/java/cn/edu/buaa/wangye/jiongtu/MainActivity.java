package cn.edu.buaa.wangye.jiongtu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.buaa.wangye.jiongtu.bean.Datum;
import cn.edu.buaa.wangye.jiongtu.bean.GifItem;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private SwipeRefreshLayout swipeView;
    private ListView listView;
    private List<Datum> gifItemList;
    private GifListAdapter gifListAdapter;
    private GifListService service;

    private String tag = "";
    private String sort = "recent";
    private String day = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        swipeView = (SwipeRefreshLayout) findViewById(R.id.swipe);
        listView = (ListView)findViewById(R.id.listView);
        gifItemList = new ArrayList<>();
        gifListAdapter = new GifListAdapter(this, gifItemList);
        listView.setAdapter(gifListAdapter);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://i.snssdk.com")
                .build();
        service = restAdapter.create(GifListService.class);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int lastItemIndex;//当前ListView中最后一个Item的索引

            //当ListView不在滚动，并且ListView的最后一项的索引等于adapter的项数减一时则自动加载（因为索引是从0开始的）
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                        && lastItemIndex == gifListAdapter.getCount() - 1) {
                    //加载数据代码，此处省略了
                    loadMore();
                }
            }

            //这三个int类型的参数可以自行Log打印一下就知道是什么意思了
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                //ListView 的FooterView也会算到visibleItemCount中去，所以要再减去一
                lastItemIndex = firstVisibleItem + visibleItemCount - 1;
            }
        });

        swipeView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeView.setRefreshing(true);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        reFresh();
                    }
                }, 0);
            }
        });

        reFresh();
    }


    private void reFresh() {
        swipeView.setRefreshing(true);

        service.reFresh(sort, tag, day, new Callback<GifItem>() {
            @Override
            public void success(GifItem gifItem, Response response) {
                gifItemList.clear();
                gifItemList.addAll(gifItem.getData());
                gifListAdapter.notifyDataSetChanged();
                swipeView.setRefreshing(false);
                listView.setSelectionAfterHeaderView();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void loadMore() {
        String time = gifItemList.get(gifItemList.size()-1).getBehotTime().toString();
        System.out.println(time);
        service.loadMore(sort, time, tag, day, new Callback<GifItem>() {
            @Override
            public void success(GifItem gifItem, Response response) {
                gifItemList.addAll(gifItem.getData());
                gifListAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        switch (position){
            case 0:
                tag = "";
                mTitle = getString(R.string.title_section1);
                break;
            case 1:
                tag = "heavy";
                mTitle = getString(R.string.title_section2);
                break;
            case 2:
                tag = "comic";
                mTitle = getString(R.string.title_section3);
                break;
            case 3:
                tag = "meng";
                mTitle = getString(R.string.title_section4);
                break;
            case 4:
                tag = "gif";
                mTitle = getString(R.string.title_section5);
                break;
        }
        myHandler.sendEmptyMessage(0);
    }


    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_newest) {
            sort = "recent";
            day = "";
            myHandler.sendEmptyMessage(0);
            return true;
        }else if(id == R.id.action_dayhot){
            sort = "top";
            day = "1";
            myHandler.sendEmptyMessage(0);
            return true;
        }else if(id == R.id.action_weekhot){
            sort = "top";
            day = "7";
            myHandler.sendEmptyMessage(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            reFresh();
            super.handleMessage(msg);
        }
    };
}
