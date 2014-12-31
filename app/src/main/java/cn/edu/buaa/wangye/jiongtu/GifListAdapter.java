package cn.edu.buaa.wangye.jiongtu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import cn.edu.buaa.wangye.jiongtu.bean.Datum;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class GifListAdapter extends BaseAdapter {
    protected LayoutInflater mInflater;
    protected List<Datum> gifItemList;
    protected Context mContext;
    private int deviceWidth;

	public GifListAdapter(Context context, List<Datum> list) {
		this.gifItemList = list;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.deviceWidth = context.getResources().getDisplayMetrics().widthPixels;
	}

    @Override
    public int getCount() {
        return gifItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return gifItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {

			holder = new ViewHolder();

			convertView = mInflater.inflate(R.layout.list_item_gif, null);
			holder.gif = (ImageView) convertView
					.findViewById(R.id.list_item_gif);
			holder.text = (TextView) convertView
					.findViewById(R.id.list_item_text);
            holder.gif2 = (GifImageView) convertView
                    .findViewById(R.id.list_item_gif2);
			convertView.setTag(holder);

		} else {

			holder = (ViewHolder) convertView.getTag();
		}

        final Datum item = gifItemList.get(position);
        final ImageView im = holder.gif;
        final GifImageView gim = holder.gif2;

        holder.text.setText(item.getDescription());

        int height = deviceWidth * item.getLargeHeight() / item.getLargeWidth();
        if(height > 4096){
            height = 4096;
        }

        if(item.getFormat().equalsIgnoreCase("GIF")){
            ViewGroup.LayoutParams lp = gim.getLayoutParams();
            lp.width = deviceWidth;
            lp.height = height;
            try {
                GifDrawable gd = new GifDrawable(mContext.getResources(), R.drawable.loading);
                gim.setImageDrawable(gd);
            } catch (IOException e) {
                e.printStackTrace();
            }
            gim.setVisibility(View.VISIBLE);

            AsyncImageLoader.createObject().loadInputStream(item.getLargeUrl(), new AsyncImageLoader.FileCallback2() {
                @Override
                public void fileLoaded(String filename, String imageUrl) {
                    try {
                        GifDrawable gd = new GifDrawable(filename);
                        gim.setImageDrawable(gd);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            holder.gif.setVisibility(View.GONE);
        }else{
            ViewGroup.LayoutParams lp = im.getLayoutParams();
            lp.width = deviceWidth;
            lp.height = height;
            im.setVisibility(View.GONE);
            ViewGroup.LayoutParams lp2 = gim.getLayoutParams();
            lp2.width = deviceWidth;
            lp2.height = height;
            try {
                GifDrawable gd = new GifDrawable(mContext.getResources(), R.drawable.loading);
                gim.setImageDrawable(gd);
            } catch (IOException e) {
                e.printStackTrace();
            }
            gim.setVisibility(View.VISIBLE);

            Picasso.with(mContext)
                    .load(item.getLargeUrl())
                    .resize(deviceWidth, deviceWidth * item.getLargeHeight() / item.getLargeWidth())
                    .into(im, new Callback() {
                        @Override
                        public void onSuccess() {
                            gim.setVisibility(View.GONE);
                            im.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onError() {

                        }
                    });
        }





		return convertView;
	}

	class ViewHolder {
        public GifImageView gif2;
		public ImageView gif;
		public TextView text;
	}


}
