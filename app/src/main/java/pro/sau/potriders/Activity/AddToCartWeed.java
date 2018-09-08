package pro.sau.potriders.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import pro.sau.potriders.Adapter.WeedWeightAdapter;
import pro.sau.potriders.R;

public class AddToCartWeed extends AppCompatActivity {
ImageView bactfromweed;
RecyclerView weed_weight_recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart_weed);
      //  TextView  textwriten = findViewById(R.id.textwriten);
        final Animation myAnim = AnimationUtils.loadAnimation(AddToCartWeed.this, R.anim.fade_enter);
        //textwriten.startAnimation(myAnim);
       // weed_weight_recycler =  findViewById(R.id.weed_weight_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        weed_weight_recycler.setLayoutManager(linearLayoutManager);
        WeedWeightAdapter weedWeightAdapter = new WeedWeightAdapter(getApplicationContext());
        weed_weight_recycler.setAdapter(weedWeightAdapter);
       // bactfromweed = findViewById(R.id.bactfromweed);
        bactfromweed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddToCartWeed.this, NavigationDrawer.class);
                startActivity(intent);
            }
        });
    }
}
