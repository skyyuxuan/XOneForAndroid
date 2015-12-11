package com.xuanstudio.xone.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.xuanstudio.xone.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import datahelper.model.HomeData;

/**
 * Created by j-xuanyu on 2015/12/10.
 */
public class FlipAdapter extends BaseAdapter implements View.OnClickListener {

    private Context context;

    static class ViewHolder {
        TextView contentTextView;
        ImageView mainImageView;
    }

    public interface Callback {
        public void onPageRequested(int page);
    }

    private LayoutInflater inflater;
    private Callback callback;
    private List<HomeData.HomeDataItem> items = new ArrayList<>();

    public void setItems(List<HomeData.HomeDataItem> items) {
        this.items = items;
    }

    public FlipAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {

            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.mainpage, parent, false);

            holder.contentTextView = (TextView) convertView.findViewById(R.id.mainContentTextView);
            holder.mainImageView = (ImageView) convertView.findViewById(R.id.mainImageView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.contentTextView.setText(items.get(position).Content);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(items.get(position).OriginalImgUrl, holder.mainImageView);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public void onClick(View v) {

    }

    public void addItems(HomeData.HomeDataItem item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public void addItemsBefore(HomeData.HomeDataItem item) {
        items.add(0, item);
        notifyDataSetChanged();
    }

}
