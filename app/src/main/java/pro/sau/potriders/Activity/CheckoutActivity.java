package pro.sau.potriders.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import pro.sau.potriders.R;

public class CheckoutActivity extends AppCompatActivity {
    Toolbar toolbar;
    String mBackStack;
    CardView cardViewFood, cardViewWeed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
        initialization();
    }

    private void initialization() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            mBackStack = bundle.getString("Addtocart");
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        cardViewFood = (CardView) findViewById(R.id.cardViewFood);
        cardViewWeed = (CardView) findViewById(R.id.cardViewWeed);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_left);
        cardViewFood.setAnimation(animation);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_right);
        cardViewWeed.setAnimation(animation1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(CheckoutActivity.this, ViewCartActivity.class);
                intent.putExtra("Addtocart", mBackStack);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.zoom_exit, R.anim.zoom_enter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CheckoutActivity.this, ViewCartActivity.class);
        intent.putExtra("Addtocart", mBackStack);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.zoom_exit, R.anim.zoom_enter);
        super.onBackPressed();
    }
}
