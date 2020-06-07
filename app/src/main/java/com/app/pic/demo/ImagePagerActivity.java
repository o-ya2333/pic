package com.app.pic.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import com.app.pic.demo.adapters.PicAdapter;
import com.app.pic.demo.photoview.HackyViewPager;

import java.util.ArrayList;

public class ImagePagerActivity extends AppCompatActivity {

    private static final String STATE_POSITION = "STATE_POSITION";
    public static final String EXTRA_IMAGE_INDEX = "image_index";
    public static final String EXTRA_IMAGE_URLS = "image_urls";

    private HackyViewPager mPager;
    private int pagerPosition;
    private TextView indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pager);
        mPager = findViewById(R.id.pager);
        indicator = findViewById(R.id.indicator);

        pagerPosition = getIntent().getIntExtra(EXTRA_IMAGE_INDEX, 0);
        ArrayList<Integer> urls = getIntent().getIntegerArrayListExtra(EXTRA_IMAGE_URLS);


        PicAdapter adapter = new PicAdapter(this, urls);
        mPager.setAdapter(adapter);

        if (urls.size() > 1) {//--->图片个数大于1
            CharSequence text = getString(R.string.viewpager_indicator, 1, mPager.getAdapter().getCount());
            indicator.setText(text);
            // 更新下标
            mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageScrollStateChanged(int arg0) {
                }

                @Override
                public void onPageScrolled(int arg0, float arg1, int arg2) {
                }

                @Override
                public void onPageSelected(int arg0) {
                    CharSequence text = getString(R.string.viewpager_indicator,
                            arg0 + 1, mPager.getAdapter().getCount());
                    indicator.setText(text);
                }
            });
        } else {//--->图片个数等于1
            indicator.setVisibility(View.GONE);
        }

        if (savedInstanceState != null) {
            pagerPosition = savedInstanceState.getInt(STATE_POSITION);
        }

        mPager.setCurrentItem(pagerPosition);

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(STATE_POSITION, mPager.getCurrentItem());
    }
}
