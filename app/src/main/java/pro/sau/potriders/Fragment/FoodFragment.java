package pro.sau.potriders.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;

import pro.sau.potriders.Adapter.FoodAdapter;
import pro.sau.potriders.R;


public class FoodFragment extends Fragment {

    HorizontalScrollView scrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        scrollView = (HorizontalScrollView) view.findViewById(R.id.horizontalScroll);
        Animation animation1 = AnimationUtils.loadAnimation(getActivity(),
                R.anim.slide_in_left);
        scrollView.startAnimation(animation1);
        RecyclerView foodbrand_recycler = view.findViewById(R.id.foodbrand_recycler);

        foodbrand_recycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        FoodAdapter restaurantListAdapter = new FoodAdapter(getActivity());
        foodbrand_recycler.setAdapter(restaurantListAdapter);

        return view;
    }

}
