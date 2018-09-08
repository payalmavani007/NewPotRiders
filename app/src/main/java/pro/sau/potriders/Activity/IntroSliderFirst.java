package pro.sau.potriders.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import pro.sau.potriders.R;

public class IntroSliderFirst extends Fragment {

    Handler handler;
    View view;
    LinearLayout imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_intro_slider_first, container, false);
        imageView = (LinearLayout) view.findViewById(R.id.lianra);
     /*   Animation animation1 = AnimationUtils.loadAnimation(getActivity(),
                R.anim.diagonal_right_enter);
        imageView.startAnimation(animation1);*/

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        }, 1500);

        return view;
    }

}

