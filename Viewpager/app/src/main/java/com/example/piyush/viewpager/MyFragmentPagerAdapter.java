package com.example.piyush.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Piyush on 07-08-2016.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = BlankFragment.newInstance("frag", "one");
                break;
            case 1:
                frag = BlankFragment.newInstance("frag", "two");
                break;
            case 2:
                frag = BlankFragment.newInstance("frag", "three");
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
