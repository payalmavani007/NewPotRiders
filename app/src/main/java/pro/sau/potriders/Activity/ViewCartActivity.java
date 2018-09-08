package pro.sau.potriders.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import pro.sau.potriders.R;

public class ViewCartActivity extends AppCompatActivity {
    Spinner spinner;
    String[] country = {"1G", "2G", "1/8", "1/4", "1/2", "OZ"};
    String mBackStack;
    ImageView imgBackArrow;
    Button btnCheckOut;
    CardView card_viewFood, card_viewWeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
        inittilaztion();
    }

    private void inittilaztion() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            mBackStack = bundle.getString("Addtocart");
        }
        card_viewFood = (CardView) findViewById(R.id.card_viewFood);
        card_viewWeed = (CardView) findViewById(R.id.card_viewWeed);

        spinner = (Spinner) findViewById(R.id.spinnerItemList);
        imgBackArrow = (ImageView) findViewById(R.id.imgBackArrow);
        btnCheckOut = (Button) findViewById(R.id.btnCheckOut);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_left);
        card_viewFood.setAnimation(animation);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_right);
        card_viewWeed.setAnimation(animation1);

        setDataSpinner();
        backArrowClick();
        btnCheckOutClick();
    }

    private void btnCheckOutClick() {
        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewCartActivity.this, CheckoutActivity.class);
                intent.putExtra("Addtocart", mBackStack);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.zoom_exit, R.anim.zoom_enter);
            }
        });
    }

    private void backArrowClick() {
        imgBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBackStack.equals("weed")) {
                    Intent intent = new Intent(ViewCartActivity.this, ScrollingActivityAddToCartWeed.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.card_enter, R.anim.card_exit);
                } else {
                    Intent intent = new Intent(ViewCartActivity.this, ScrollingActivityAddToCart.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.card_enter, R.anim.card_exit);
                }
            }
        });
    }

    private void setDataSpinner() {
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
    }

    @Override
    public void onBackPressed() {
        if (mBackStack.equals("weed")) {
            Intent intent = new Intent(ViewCartActivity.this, ScrollingActivityAddToCartWeed.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.card_enter, R.anim.card_exit);
        } else {
            Intent intent = new Intent(ViewCartActivity.this, ScrollingActivityAddToCart.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.card_enter, R.anim.card_exit);
        }

        super.onBackPressed();
    }
}
