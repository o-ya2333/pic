package com.app.pic.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.app.pic.demo.adapters.ListAdapter;
import com.app.pic.demo.beans.ListBean;

import java.util.ArrayList;
import java.util.List;


/**
 * 启动主页
 */
public class MainActivity extends AppCompatActivity {


    ListView listView;
    ListAdapter adapter;
    private List<ListBean> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取控件
        listView = findViewById(R.id.listview);


        //模拟数据
        initData();

        //适配器
        initAdapter();
    }


    /**
     * 设置适配器
     */
    private void initAdapter() {

        adapter = new ListAdapter(this, (ArrayList) list, R.layout.item_listview);
        listView.setAdapter(adapter);


        //条目点击监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ImageListActivity.class);
                intent.putExtra("position", position % 5);
                startActivity(intent);
            }
        });

    }


    /**
     * 创建模拟数据
     */
    private void initData() {

        //创建模拟数据
        for (int i = 0; i < 10; i++) {
            ListBean bean = new ListBean();
            String name = "文件夹";
            int pic = 0;
            if (i % 5 == 1) {
                name = "自然风景";
                pic = R.mipmap.pic_1;
            } else if (i % 5 == 2) {
                name = "影视";
                pic = R.mipmap.pic_zhongguojizhang;
            } else if (i % 5 == 3) {
                name = "明星";
                pic = R.mipmap.pic_wangzuxian;
            } else if (i % 5 == 4) {
                name = "动漫";
                pic = R.mipmap.pic_12;
            } else {
                name = "游戏";
                pic = R.mipmap.pic_youxi3;
            }

            bean.setName(name);
            bean.setPic(pic);
            list.add(bean);
        }
    }
}
