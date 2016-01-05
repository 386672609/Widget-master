package android.com.widget;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {
    private List<Fragment> mFragments;
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ArrayList<SlideItem> list = new ArrayList<>();
        CustomBtn btn = new CustomBtn();
        btn.setName("阅办单");
        btn.setEvent("阅办单已选中");
        btn.setNumber(0);
        list.add(btn);

        btn = new CustomBtn();
        btn.setName("详细信息");
        btn.setEvent("详细信息已选中");
        btn.setIsCheck(true);
        btn.setNumber(1);
        list.add(btn);

        btn = new CustomBtn();
        btn.setName("查看意见");
        btn.setEvent("查看意见已选中");
        btn.setNumber(2);
        list.add(btn);

        btn = new CustomBtn();
        btn.setName("传阅记录");
        btn.setEvent("传阅记录已选中");
        btn.setNumber(3);
        list.add(btn);

        SlideTitle slideTitle = (SlideTitle)findViewById(R.id.slideTitle);
        // 标题点击监听
        slideTitle
                .setSlideTitleOnClickListener(new SlideTitle.SlideTitleOnClickListener() {
                    @Override
                    public void slideTitleOnClick(SlideItem item) {
                        if (item instanceof CustomBtn) {
                            CustomBtn btn = (CustomBtn) item;
                            Toast.makeText(getBaseContext(), btn.getEvent(), Toast.LENGTH_SHORT).show();
                            setSelect2(btn.getNumber());
                        }

                    }
                });
        slideTitle.setMidChildTitleFlow(list);
        setSelect2(0);
    }
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mFragments = new ArrayList<Fragment>();
        Fragment fg1 = new Fragment1();
        Fragment fg2 = new Fragment2();
        Fragment fg3 = new Fragment3();
        Fragment fg4 = new Fragment4();

        mFragments.add(fg1);
        mFragments.add(fg2);
        mFragments.add(fg3);
        mFragments.add(fg4);
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mFragments.get(arg0);
            }
        };
        mViewPager.setAdapter(mAdapter);

        mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                int currentItem = mViewPager.getCurrentItem();
                setSelect2(currentItem);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

    private void setSelect2(int i) {
        mViewPager.setCurrentItem(i);
    }
    }

