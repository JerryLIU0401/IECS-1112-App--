package fcu.app.iecs_1112_app_food;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {
    private Button register_btn;
    private EditText et_account;
    private EditText et_password;
    private EditText et_password_confirm;
    private EditText et_mail;
    private Bitmap userIcon;
    private ImageButton userIcon_btn;
    private AccountDatabaseHandler databaseHandler;
    private ActivityResultLauncher<String> imgPickerLauncher;


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
        userIcon_btn = findViewById(R.id.register_usericon);
//        userIcon = findViewById(R.drawable.usericon);
        databaseHandler = new AccountDatabaseHandler(this);
        databaseHandler.open();

        View.OnClickListener onRegisterBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(et_password.getText().toString().equals(et_password_confirm.getText().toString()))) {
                    Toast.makeText(RegisterActivity.this, "Wrong password confirm", Toast.LENGTH_LONG);
                } else if (et_account.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Account is empty !!", Toast.LENGTH_LONG).show();
                } else if (et_password.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Password is empty !!", Toast.LENGTH_LONG).show();
                } else if (et_password_confirm.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Password confirm is empty !!", Toast.LENGTH_LONG).show();
                } else if (databaseHandler.isAccountExist(et_account.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Account name had been used", Toast.LENGTH_LONG).show();
                } else if (databaseHandler.isMailExist(et_mail.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Mail had been used", Toast.LENGTH_LONG).show();
                } else {
                    databaseHandler.addAccount(et_account.getText().toString(), et_mail.getText().toString(), et_password.getText().toString(), userIcon);
                    finish();
                }
            }
        };

        View.OnClickListener onUserIconBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        };

        imgPickerLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        if (result != null) {
                            addImageButtonToView(result);
                        }
                    }
                }
        );

        userIcon_btn.setOnClickListener(onUserIconBtnClickListener);
        register_btn.setOnClickListener(onRegisterBtnClickListener);
    }

    private void openGallery() {
        imgPickerLauncher.launch("image/*");
    }

    private void addImageButtonToView(Uri imageUri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri); //將 URI 轉換為 Bitmap 物件
            userIcon = bitmap;
            userIcon_btn.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}