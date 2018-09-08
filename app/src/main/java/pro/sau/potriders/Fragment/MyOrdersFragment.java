package pro.sau.potriders.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.bubbletab.BubbleTab;

import pro.sau.potriders.Adapter.HomePagerAdapter;
import pro.sau.potriders.Adapter.OrderPagerAdapter;
import pro.sau.potriders.R;

public class MyOrdersFragment extends Fragment {

    private ViewPager orderviewPager;
    BubbleTab tab;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_orders, container, false);
        orderviewPager =  view.findViewById(R.id.orderviewpager);
        getActivity().setTitle("MY ORDERS");
        setupViewPager(orderviewPager);
        tab = (BubbleTab) view.findViewById(R.id.tabs);
        tab.setupWithViewPager(orderviewPager);
        return view;
    }
    private void setupViewPager(ViewPager viewPager) {
        OrderPagerAdapter adapter = new OrderPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new OnGoingOrdersFragment(), "Ongoing Orders");
        adapter.addFragment(new PastOrdersFragment(), "Past Orders");
        viewPager.setAdapter(adapter);
    }
}
