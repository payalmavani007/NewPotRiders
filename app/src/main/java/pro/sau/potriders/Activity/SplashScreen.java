package pro.sau.potriders.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import pro.sau.potriders.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    LinearLayout gifImage;
    View view;
    private Handler mHandler = new Handler();
    private Runnable mRunnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        initlati();
    }

    private void initlati() {
        gifImage = (LinearLayout) findViewById(R.id.gifImage);


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent intent = new Intent(SplashScreen.this, SplachScreeenAcivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.diagonal_right_exit, R.anim.diagonal_right_exit);

            }
        }, 1500);

    }

}