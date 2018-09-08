package pro.sau.potriders.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pro.sau.potriders.Adapter.FoodAdapter;
import pro.sau.potriders.Adapter.OngoingOrdersAdapter;
import pro.sau.potriders.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnGoingOrdersFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_on_going_orders, container, false);
        RecyclerView ongoing_recycler = view.findViewById(R.id.ongoing_recycler);

        ongoing_recycler.setLayoutManager(new GridLayoutManager(getActivity(),1));
        OngoingOrdersAdapter ongoingOrdersAdapter=new OngoingOrdersAdapter(getActivity());
        ongoing_recycler.setAdapter(ongoingOrdersAdapter);
        return  view;
    }

}
