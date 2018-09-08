package pro.sau.potriders.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import pro.sau.potriders.R;

public class ViewProfile extends AppCompatActivity {
    ImageView change_pwd, back_to_view_profile;
    LinearLayout linearLayout;
    String passwordId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            passwordId = bundle.getString("changePassword");
        }
        if (passwordId != null && !passwordId.isEmpty() && !passwordId.equals("null")) {

            overridePendingTransition(R.anim.fade_enter, R.anim.fade_exit);
        } else {
            overridePendingTransition(R.anim.split_enter, R.anim.split_exit);
        }

        change_pwd = findViewById(R.id.change_pwd);
        back_to_view_profile = findViewById(R.id.back_to_view_profile);
        back_to_view_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewProfile.this, SampleActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.windmill_exit, R.anim.windmill_enter);
            }
        });
        change_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.bounce);
                change_pwd.startAnimation(animation1);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(ViewProfile.this, ChangePassword.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_exit, R.anim.fade_enter);
                    }
                }, 500);
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(ViewProfile.this, SampleActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.windmill_exit, R.anim.windmill_enter);
        super.onBackPressed();
    }
}
