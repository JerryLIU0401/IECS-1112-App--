package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button register_btn;
    private EditText et_account;
    private EditText et_password;
    private EditText et_password_confirm;
    private EditText et_mail;
    private String userIcon;
    private AccountDatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        register_btn = findViewById(R.id.register_btn_registerpage);
        et_account = findViewById(R.id.et_account_registerpage);
        et_password = findViewById(R.id.et_password_registerpage);
        et_password_confirm = findViewById(R.id.et_password_confirm_registerpage);
        et_mail = findViewById(R.id.et_mail_registerpage);
        databaseHandler = new AccountDatabaseHandler(this);
        databaseHandler.open();

        View.OnClickListener onRegisterBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(et_password.getText().toString().equals(et_password_confirm.getText().toString()))){
                    Toast.makeText(RegisterActivity.this,"Wrong password confirm",Toast.LENGTH_LONG);
                } else if (et_account.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Account is empty !!", Toast.LENGTH_LONG).show();
                } else if (et_password.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Password is empty !!", Toast.LENGTH_LONG).show();
                } else if (et_password_confirm.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Password confirm is empty !!", Toast.LENGTH_LONG).show();
                } else {
                    userIcon = "demoIcon";
                    databaseHandler.addAccount(et_account.getText().toString(), et_mail.getText().toString(), et_password.getText().toString(), userIcon);
                    finish();
                }
            }
        };

        register_btn.setOnClickListener(onRegisterBtnClickListener);
    }
    
}