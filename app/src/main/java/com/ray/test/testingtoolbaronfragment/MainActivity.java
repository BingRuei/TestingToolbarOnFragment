package com.ray.test.testingtoolbaronfragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // I did a test that the value, s, it can transport to other activities or not?
    String s = ".";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ViewPager mixed with Fragment.
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),
                this, s);
        viewPager.setAdapter(adapter);
//        viewPager.setCurrentItem(1);

        // TabLayout mixed with ViewPager.
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        for(int i = 0; i < 5; i++){
//            menu.add(Menu.NONE, Menu.FIRST + i, Menu.NONE, "Item " + Integer.toString(i + 1));
//        }
//        SubMenu subMenu = menu.addSubMenu(3, Menu.FIRST, Menu.NONE, "sub item");
//        for(int i = 0; i < 3; i++){
//            subMenu.add(Menu.FIRST, Menu.FIRST, Menu.NONE, "Sub Item " + Integer.toString(i + 1));
//        }
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getGroupId() == Menu.NONE) {
//            Toast.makeText(getApplicationContext(),
//                    item.getTitle(),
//                    Toast.LENGTH_SHORT).show();
//        } else if(item.getGroupId() == Menu.FIRST){
//            Toast.makeText(getApplicationContext(),
//                    item.getTitle(),
//                    Toast.LENGTH_SHORT).show();
//        }
//        return super.onOptionsItemSelected(item);
//    }

}