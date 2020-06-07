package com.app.pic.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.app.pic.demo.adapters.GridAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class ImageListActivity extends AppCompatActivity {

    TextView tvBack;  //返回
    GridView gridview; //网格布局
    GridAdapter adapter; //适配器
    ArrayList<Integer> list = new ArrayList<>(); //数据源
    private int position; //位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        //获取控件
        gridview = findViewById(R.id.gridview);
        tvBack = findViewById(R.id.tv_back);

        //模拟数据
        initData();

        //适配器
        initAdapter();


        //界面点击事件
        initListener();
    }

    private void initListener() {
        //点击事件
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ImageListActivity.this, ImagePagerActivity.class);

                intent.putIntegerArrayListExtra("image_urls", list);
                intent.putExtra("picNum", list.size());
                intent.putExtra("image_index", position);

                startActivity(intent);
            }
        });

        //返回
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


    /**
     * 界面适配器
     */
    private void initAdapter() {
        adapter = new GridAdapter(this, list, R.layout.item_gridview);
        gridview.setAdapter(adapter);


    }


    /**
     * 界面数据
     */
    private void initData() {

        //获取上个界面带过来的数据
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);


        if (position == 0) { //游戏
            list.add(R.mipmap.pic_youxi1);
            list.add(R.mipmap.pic_youxi2);
            list.add(R.mipmap.pic_youxi3);
            list.add(R.mipmap.pic_youxi4);
            list.add(R.mipmap.pic_youxi5);
            list.add(R.mipmap.pic_youxi6);
            list.add(R.mipmap.pic_youxi7);
        } else if (position == 1) {//风景
            list.add(R.mipmap.pic_1);
            list.add(R.mipmap.pic_2);
            list.add(R.mipmap.pic_3);
            list.add(R.mipmap.pic_4);
            list.add(R.mipmap.pic_5);
            list.add(R.mipmap.pic_6);
            list.add(R.mipmap.pic_7);
            list.add(R.mipmap.pic_8);
            list.add(R.mipmap.pic_9);
            list.add(R.mipmap.pic_10);
            list.add(R.mipmap.pic_11);
        } else if (position == 2) {//影视
            list.add(R.mipmap.pic_chubukeji);
            list.add(R.mipmap.pic_fuchouzhe);
            list.add(R.mipmap.pic_haishanggangqinshi);
            list.add(R.mipmap.pic_wusha);
            list.add(R.mipmap.pic_yewen);
            list.add(R.mipmap.pic_zhongguojizhang);
        } else if (position == 3) {//明星
            list.add(R.mipmap.pic_chenglong);
            list.add(R.mipmap.pic_guanzhilin);
            list.add(R.mipmap.pic_lilianjie);
            list.add(R.mipmap.pic_liudehua);
            list.add(R.mipmap.pic_wangzuxian);
            list.add(R.mipmap.pic_zhangxueyou);
            list.add(R.mipmap.pic_zhouxingchi);
            list.add(R.mipmap.pic_zhuyin);
        } else if (position == 4) {//动漫
            list.add(R.mipmap.pic_12);
            list.add(R.mipmap.pic_13);
            list.add(R.mipmap.pic_14);
            list.add(R.mipmap.pic_15);
        } else {
            list.add(R.mipmap.pic_youxi1);
            list.add(R.mipmap.pic_2);
            list.add(R.mipmap.pic_lilianjie);
            list.add(R.mipmap.pic_13);
        }
    }
}
