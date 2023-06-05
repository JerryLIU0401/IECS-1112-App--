package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button register_btn;
    private Button login_btn;
    private AccountDatabaseHandler databaseHandler;
    private ImageView loginUserIcon;
    private EditText et_account;
    private EditText et_password;
    private Handler delayHandler;
    private final long TIME_DELAY = 2000;
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
                    //sendDataViaBroadcast();
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Wrong account or password", Toast.LENGTH_LONG).show();
                }
            }
        };
        register_btn.setOnClickListener(onClickRegisterBtnListener);
        login_btn.setOnClickListener(onClickLoginBtnListener);

        et_account.addTextChangedListener(new TextWatcher() {
            private Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    searchAccountWithImage(et_account.getText().toString());
                }
            };
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                delayHandler.removeCallbacks(runnable);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                delayHandler.postDelayed(runnable, TIME_DELAY);
            }
        });
    }

    public void setValueById() {
        register_btn = findViewById(R.id.register_btn_loginpage);
        login_btn = findViewById(R.id.login_btn_loginpage);
        et_account = findViewById(R.id.et_account_loginpage);
        et_password = findViewById(R.id.et_password_loginpage);
        loginUserIcon = findViewById(R.id.login_usericon);
        delayHandler = new Handler();
    }

    public void searchAccountWithImage(String account){
        Bitmap image = databaseHandler.getImage(account);
        if(image != null){
            loginUserIcon.setImageBitmap(image);
        }else{
            loginUserIcon.setImageResource(R.drawable.usericon);
        }
    }

    public void sendDataViaBroadcast() {
        Intent intent = new Intent("action");
        int i = databaseHandler.getId(et_account.getText().toString(), et_password.getText().toString(), LoginActivity.this);
        intent.putExtra("data", i);
        // 發送廣播
        sendBroadcast(intent);
    }


}