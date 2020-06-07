package com.app.pic.demo.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.pic.demo.R;
import com.app.pic.demo.base.CommonAdapter;
import com.app.pic.demo.base.ViewHolder;
import com.app.pic.demo.beans.ListBean;

import java.util.ArrayList;

/**
 * @anthor : 大海
 * 每天进步一点点
 * @time :   2019/12/31
 * @description :
 * <p>
 * 首页文件列表的适配器
 */


public class ListAdapter extends CommonAdapter {
    public ListAdapter(Context context, ArrayList datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void setView(ViewHolder holder, Object o, int position) {
        ListBean bean = (ListBean) o;
        ImageView imageView = holder.getView(R.id.imgv_pic);
        TextView textView = holder.getView(R.id.tv_listview_item);
        textView.setText(bean.getName());
        imageView.setImageResource(bean.getPic());

    }
}
