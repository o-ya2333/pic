package com.app.pic.demo;


import org.litepal.LitePalApplication;



//import cn.jpush.android.api.JPushInterface;


/**
 * Created by gaopeng on 2018/5/7.
 */

public class MyApplication extends LitePalApplication {

    public static final String TAG = "-----------";
    public static final String TAG2 = "++++++++++";
    public static final String TAG_finger = "finger-----------";
    public static String imgPath;//拍照的img路径
    private static MyApplication singleton;

    public static String curUser;

    //单例模式获取MyApplication
    public static MyApplication getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;

    }



}
