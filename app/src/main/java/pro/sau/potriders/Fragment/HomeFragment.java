package pro.sau.potriders.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.github.florent37.bubbletab.BubbleTab;

import pro.sau.potriders.Adapter.HomePagerAdapter;
import pro.sau.potriders.R;


public class HomeFragment extends Fragment {
    TabLayout tabLayout;
    RelativeLayout linearLayout;
    BubbleTab tab;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tab = (BubbleTab) view.findViewById(R.id.tabs);

        viewPager = view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tab.setupWithViewPager(viewPager);
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        HomePagerAdapter adapter = new HomePagerAdapter(getChildFragmentManager());
        adapter.addFragment(new FoodFragment(), "FOOD");
        adapter.addFragment(new WeedFragment(), "WEED");
        viewPager.setAdapter(adapter);
    }

}
