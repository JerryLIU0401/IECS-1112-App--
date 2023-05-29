package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button register_btn;
    private Button login_btn;
    private AccountDatabaseHandler databaseHandler;
    private EditText et_account;
    private EditText et_password;
    //account 123
    //password 123

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        setValueById();
        databaseHandler = new AccountDatabaseHandler(this);
        databaseHandler.open();
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
                if (databaseHandler.loginAccountSearch(et_account.getText().toString(), et_password.getText().toString(), LoginActivity.this)) {
                    Intent intent = new Intent(LoginActivity.this, MainPageActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Wrong account or password", Toast.LENGTH_LONG).show();
                }
            }
        };
        register_btn.setOnClickListener(onClickRegisterBtnListener);
        login_btn.setOnClickListener(onClickLoginBtnListener);


    }

    public void setValueById() {
        register_btn = findViewById(R.id.register_btn_loginpage);
        login_btn = findViewById(R.id.login_btn_loginpage);
        et_account = findViewById(R.id.et_account_loginpage);
        et_password = findViewById(R.id.et_password_loginpage);
    }


}