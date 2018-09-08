package pro.sau.potriders.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pro.sau.potriders.Adapter.OngoingOrdersAdapter;
import pro.sau.potriders.Adapter.PastOrdersAdapter;
import pro.sau.potriders.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastOrdersFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_past_orders, container, false);
        RecyclerView pastorder_recycler = view.findViewById(R.id.pastorder_recycler);

        pastorder_recycler.setLayoutManager(new GridLayoutManager(getActivity(),1));
        PastOrdersAdapter pastOrdersAdapter=new PastOrdersAdapter(getActivity());
        pastorder_recycler.setAdapter(pastOrdersAdapter);
        return  view;
    }

}
