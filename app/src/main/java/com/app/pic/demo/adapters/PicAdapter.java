package com.app.pic.demo.adapters;

import android.content.Context;
import android.view.ViewGroup;

import com.app.pic.demo.photoview.PhotoView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by jinxl on 2017/4/10.
 */

public class PicAdapter extends PicBasePagerAdapter<Integer> {

    public PicAdapter(Context context, ArrayList<Integer> list) {
        super(context, list);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        PhotoView imageView = new PhotoView(context);

        Glide.with(context).load(list.get(position)).into(imageView);
//        BitmapUtil.display(context, list.get(position).getFileUrl(), imageView);

        //将ImageView加入到ViewPager中
        container.addView(imageView);
        return imageView;
    }

}