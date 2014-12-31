package cn.edu.buaa.wangye.jiongtu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
		holder.text.setText(item.getDescription());
        if(item.getFormat().equalsIgnoreCase("GIF")){
            final GifImageView gim = holder.gif2;
            ViewGroup.LayoutParams lp = gim.getLayoutParams();
            lp.width = deviceWidth;
            lp.height = deviceWidth * item.getLargeHeight() / item.getLargeWidth();
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
            final ImageView im = holder.gif;
            ViewGroup.LayoutParams lp = im.getLayoutParams();
            lp.width = deviceWidth;
            lp.height = deviceWidth * item.getLargeHeight() / item.getLargeWidth();
            im.setVisibility(View.VISIBLE);
            Picasso.with(mContext)
                    .load(item.getLargeUrl())
                    .resize(deviceWidth, deviceWidth * item.getLargeHeight() / item.getLargeWidth())
                    .into(im);
            holder.gif2.setVisibility(View.GONE);
        }





		return convertView;
	}

	class ViewHolder {
        public GifImageView gif2;
		public ImageView gif;
		public TextView text;
	}


}
