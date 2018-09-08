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

public class ChangePassword extends AppCompatActivity {

    ImageView backfrom_changepwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        overridePendingTransition(R.anim.fade_enter, R.anim.fade_exit);
        backfrom_changepwd = findViewById(R.id.backfrom_changepwd);
        backfrom_changepwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ChangePassword.this, ViewProfile.class);
                intent.putExtra("changePassword", "1");
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fade_exit, R.anim.fade_enter);
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(ChangePassword.this, ViewProfile.class);
        intent.putExtra("changePassword", "1");
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.fade_exit, R.anim.fade_enter);
        super.onBackPressed();
    }
}
