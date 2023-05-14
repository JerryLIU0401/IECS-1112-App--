package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private Button register_btn;
    private Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        register_btn = findViewById(R.id.register_btn_loginpage);
        login_btn = findViewById(R.id.login_btn_loginpage);


        View.OnClickListener onClickRegisterBtnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener onClickLoginBtnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainPageActivity.class);
                startActivity(intent);
            }
        };
        register_btn.setOnClickListener(onClickRegisterBtnListener);
        login_btn.setOnClickListener(onClickLoginBtnListener);
    }


}