package pro.sau.potriders.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import pro.sau.potriders.R;

public class ScrollingActivityAddToCart extends AppCompatActivity {
    private static final String TAG = "ScrollingActivity";
    CollapsingToolbarLayout collapsingToolbar;
    DrawerLayout drawerLayout;
    RecyclerView pastorder_recycler;
    CircleImageView circleImageView;
    CoordinatorLayout coordinatorLayout;
    TextView txtDiscre;
    TextView txtAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_add_to_cart);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        circleImageView = (CircleImageView) findViewById(R.id.imageAddtoCart);
        txtDiscre = (TextView) findViewById(R.id.txtDiscre);
        txtAddToCart = (TextView) findViewById(R.id.txtAddToCart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.spin_enter);
        circleImageView.startAnimation(animation2);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce);
        txtDiscre.startAnimation(animation1);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                Log.e(TAG, "onOffsetChanged: ");
                if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0) {
                    Log.e(TAG, "onOffsetChanged:2");

                } else {

                    Log.e(TAG, "onOffsetChanged:3");
                }
            }
        });
        clickAddTocart();
    }

    private void clickAddTocart() {
        txtAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScrollingActivityAddToCart.this, ViewCartActivity.class);
                intent.putExtra("Addtocart", "Food");
                startActivity(intent);
                overridePendingTransition(R.anim.card_exit, R.anim.card_enter);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Log.e(TAG, "onBackPressed: ");
        Intent intent = new Intent(ScrollingActivityAddToCart.this, FoodTypeActivity.class);
        intent.putExtra("Addtocart", "1");
        startActivity(intent);
        overridePendingTransition(R.anim.card_exit, R.anim.card_enter);
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(ScrollingActivityAddToCart.this, FoodTypeActivity.class);
                intent.putExtra("Addtocart", "1");
                startActivity(intent);
                overridePendingTransition(R.anim.card_exit, R.anim.card_enter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
