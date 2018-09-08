package pro.sau.potriders.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pro.sau.potriders.R;

public class LogIn extends AppCompatActivity {
    Button btn_signin;
    TextInputEditText edt_login_email, edt_login_password;
    TextView txt_forgot_password;
    RelativeLayout login_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        edt_login_email = findViewById(R.id.edt_login_email);
        edt_login_password = findViewById(R.id.edt_login_password);
        txt_forgot_password = findViewById(R.id.txt_forgot_password);
        login_register = findViewById(R.id.login_register);
        btn_signin = findViewById(R.id.signin);
        init();
    }

    private void init() {
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, SampleActivity.class);
                startActivity(intent);
           /* if (edt_login_email.getText().toString().equals("")) {
                edt_login_email.setError("Enter Valid Email.");
            } else if (edt_login_password.getText().toString().equals("")) {
                edt_login_password.setError("Enter Valid Password.");
            } else if (!Patterns.EMAIL_ADDRESS.matcher(edt_login_email.getText().toString()).matches()) {
                edt_login_email.setError("Invalid Pattern");
            } else {

            }
            */
            }
        });
        txt_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, ForgotPassword.class);
                startActivity(intent);
            }
        });
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}
