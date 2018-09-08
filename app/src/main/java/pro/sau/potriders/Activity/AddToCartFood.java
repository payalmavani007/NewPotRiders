package pro.sau.potriders.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import pro.sau.potriders.R;

public class AddToCartFood extends AppCompatActivity {
ImageView bactonavigation;
RelativeLayout addtocartfood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart_food);
        addtocartfood = findViewById(R.id.addtocartfood);
        addtocartfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddToCartFood.this, ViewCart.class);
                startActivity(intent);
            }
        });
        bactonavigation = findViewById(R.id.bactonavigation);
        bactonavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddToCartFood.this, NavigationDrawer.class);
                startActivity(intent);
            }
        });
    }
}
