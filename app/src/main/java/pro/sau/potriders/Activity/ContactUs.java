package pro.sau.potriders.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import pro.sau.potriders.R;

public class ContactUs extends AppCompatActivity {
    ImageView backto_contactus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        backto_contactus = findViewById(R.id.backto_contactus);
        backto_contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUs.this,SampleActivity.class);
                startActivity(intent);

            }
        });
    }
}
