package com.ray.test.testingtoolbaronfragment;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String test;
//    private Context context;

    // Setting your tabs
    private String[] titles = new String[]{"Tab1", "Tab2", "Tab3", "Tab4"};


    public MyFragmentPagerAdapter(FragmentManager fm, Context context, String s) {
        super(fm);
        // Getting values from MainActivity
//        this.context = context;
        test = s;

    }

    @Override
    public Fragment getItem(int position) {
        // Setting your activity on each different tab,
        // and transporting other values that you want at here.
        return new PageFragment().newInstance(position+1, test);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}