package com.seven.designbox.designpatterns.patterns.proxy;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.seven.designbox.R;
import com.seven.designbox.designpatterns.common.PatternsCommonActivity;
import com.seven.designbox.designpatterns.patterns.state.StateDemoFragment;
import com.seven.designbox.designpatterns.patterns.state.StateDesFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

public class ProxyPattern extends PatternsCommonActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patterns_composite);
        setTitle(R.string.proxy_pattern_title);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(R.string.composite_pattern_des, ProxyDesFragment.class)
                .add(R.string.composite_pattern_demo, ProxyDemoFragment.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
    }
}
