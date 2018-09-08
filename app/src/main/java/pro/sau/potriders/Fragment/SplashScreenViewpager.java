package pro.sau.potriders.Fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import pro.sau.potriders.Activity.IntroSliderFirst;
import pro.sau.potriders.Activity.IntroSlierSecond;
import pro.sau.potriders.Activity.SampleActivity;
import pro.sau.potriders.Activity.SplashScreen;
import pro.sau.potriders.Adapter.SplashScreenAdapter;
import pro.sau.potriders.R;


public class SplashScreenViewpager extends Fragment {
    private static final String TAG = "SplashScreenViewpager";
    View view;
    Timer timer;
    int page = 0;
    Handler handler;
    private ViewPager viewPager;
    RelativeLayout relativeLayout;
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_splash_sreen, container, false);
        viewPager = view.findViewById(R.id.viewpager2);

        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);

        setupViewPager(viewPager);
        indicator.setViewPager(viewPager);
        handler = new Handler();

        pageSwitcher(2);


        return view;

    }

    private void setupViewPager(ViewPager viewPager) {
        SplashScreenAdapter adapter = new SplashScreenAdapter(getChildFragmentManager());
        /*adapter.addFragment(new SplashScreen(), "splash");*/
        adapter.addFragment(new IntroSliderFirst(), "FOOD");
        adapter.addFragment(new IntroSlierSecond(), "WEED");

        viewPager.setAdapter(adapter);
    }

    public void pageSwitcher(int seconds) {

        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay


    }

    class RemindTask extends TimerTask {

        @Override
        public void run() {

            handler.post(new Runnable() {
                public void run() {

                    if (page > 4) {
                        timer.cancel();

                    } else {
                        viewPager.setCurrentItem(page++);
                    }
                }
            });

        }
    }

}
