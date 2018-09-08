package pro.sau.potriders.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import pro.sau.potriders.Fragment.SplashScreenViewpager;
import pro.sau.potriders.R;

public class SplachScreeenAcivity extends AppCompatActivity {
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screeen_acivity);
        initialization();

    }

    private void initialization() {
        linearLayout = (LinearLayout) findViewById(R.id.mainScreen);
        overridePendingTransition(R.anim.diagonal_right_enter, R.anim.diagonal_right_exit);


        Handler mHandler4 = new Handler();
        mHandler4.postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent intent = new Intent(SplachScreeenAcivity.this, SampleActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.windmill_exit, R.anim.windmill_enter);

            }
        }, 2500);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.viewFrame, new SplashScreenViewpager());
        fragmentTransaction.commit();
    }

}
