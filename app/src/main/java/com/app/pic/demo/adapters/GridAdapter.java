package com.app.pic.demo.adapters;

import android.content.Context;
import android.widget.ImageView;

import com.app.pic.demo.R;
import com.app.pic.demo.base.CommonAdapter;
import com.app.pic.demo.base.ViewHolder;

import java.util.ArrayList;

/**
 * @anthor : 大海
 * 每天进步一点点
 * @time :   2019/12/31
 * @description : 图片预览布局适配器
 */


public class GridAdapter extends CommonAdapter {

    public GridAdapter(Context context, ArrayList datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void setView(ViewHolder holder, Object o, int position) {
        int img = (int) o;
        ImageView imgv_item = holder.getView(R.id.imgv_item);
        imgv_item.setImageResource(img);
    }
}
