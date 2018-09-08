package pro.sau.potriders.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;

import pro.sau.potriders.R;

public class FoodTypeActivity extends AppCompatActivity {
    private static final String TAG = "FoodTypeActivity";
    CollapsingToolbarLayout collapsingToolbar;
    DrawerLayout drawerLayout;
    RecyclerView pastorder_recycler;
    RelativeLayout relativeLayout;
    CoordinatorLayout coordinatorLayout;
    HorizontalScrollView scrollView;
    String mAddtoCartFlag="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        inittilaztion();
    }

    private void inittilaztion() {
        Intent iin = getIntent();
        Bundle extras = iin.getExtras();
        if (extras != null) {
            mAddtoCartFlag = extras.getString("Addtocart");
        }
        if(mAddtoCartFlag.equals("1")){
            overridePendingTransition(R.anim.card_enter, R.anim.card_exit);

        }
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_enter);
        coordinatorLayout.startAnimation(animation1);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        scrollView = (HorizontalScrollView) findViewById(R.id.horizontalScroll);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_left);
        scrollView.startAnimation(animation2);


        pastorder_recycler = findViewById(R.id.rd);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pastorder_recycler.setLayoutManager(layoutManager);
        PastOrdersAdapter pastOrdersAdapter = new PastOrdersAdapter(FoodTypeActivity.this);
        pastorder_recycler.setAdapter(pastOrdersAdapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bottom_up);
        pastorder_recycler.startAnimation(animation3);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {


                Log.e(TAG, "onOffsetChanged: ");
                if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0) {
                    Log.e(TAG, "onOffsetChanged:2");
                    relativeLayout.post(new Runnable() {
                        @Override
                        public void run() {
                            final DrawerLayout.LayoutParams layoutparams = (DrawerLayout.LayoutParams) relativeLayout.getLayoutParams();
                            layoutparams.setMargins(0, 0, 0, 0);
                            relativeLayout.setLayoutParams(layoutparams);
                            collapsingToolbar.setTitle("Mcdonalds");
                        }
                    });

                } else {
                    relativeLayout.post(new Runnable() {
                        @Override
                        public void run() {
                            final DrawerLayout.LayoutParams layoutparams = (DrawerLayout.LayoutParams) relativeLayout.getLayoutParams();
                            layoutparams.setMargins(0, 210, 0, 0);
                            relativeLayout.setLayoutParams(layoutparams);
                            collapsingToolbar.setTitle(" ");
                        }
                    });


                    Log.e(TAG, "onOffsetChanged:3");
                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                overridePendingTransition(R.anim.windmill_exit, R.anim.windmill_enter);
                Intent intent = new Intent(FoodTypeActivity.this, SampleActivity.class);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {

        overridePendingTransition(R.anim.windmill_exit, R.anim.windmill_enter);

        Intent intent = new Intent(FoodTypeActivity.this, SampleActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}

