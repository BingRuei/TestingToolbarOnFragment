package com.ray.test.testingtoolbaronfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PageFragment extends Fragment {
    public static final String ARGS_PAGE = "args_page";
    private int mPage;
    private View view;
    private String test;

    public static PageFragment newInstance(int page, String test) {
        Bundle args = new Bundle();

        // Getting values from MyFragmentPagerAdapter.
        // You have to set a key for using the value
        args.putInt(ARGS_PAGE, page);
        args.putString("ARGS_TEST", test);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Getting values with key.
        mPage = getArguments().getInt(ARGS_PAGE);
        test = getArguments().getString("ARGS_TEST");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pager_item,container,false);
        TextView textView = (TextView) view.findViewById(R.id.item_title);
        textView.setText(mPage+test);
        if(mPage<3){
            setHasOptionsMenu(true);    //重點
        }

        getActivity().setTitle("Page "+mPage);


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_boardsearch, menu);
        for(int i = 0; i < 5; i++){
            menu.add(Menu.NONE, Menu.FIRST + i, Menu.NONE, "Item " + Integer.toString(i + 1));
        }
        SubMenu subMenu = menu.addSubMenu(3, Menu.FIRST, Menu.NONE, "sub item");
        for(int i = 0; i < 3; i++){
            subMenu.add(Menu.FIRST, Menu.FIRST, Menu.NONE, "Sub Item " + Integer.toString(i + 1));
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getGroupId() == Menu.NONE) {
            Toast.makeText(view.getContext(),
                    item.getTitle(),
                    Toast.LENGTH_SHORT).show();
        } else if(item.getGroupId() == Menu.FIRST){
            Toast.makeText(view.getContext(),
                    item.getTitle(),
                    Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}