package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingActivity extends PageBarButton {


    @SuppressLint("WrongViewCast")
    private Button btnEditProfile = findViewById(R.id.edit_profile_btn);
    @SuppressLint("WrongViewCast")
    private Button btnChangePass = findViewById(R.id.change_password_btn);
    @SuppressLint("WrongViewCast")
    private Button btnPaymentMethod = findViewById(R.id.payment_method_btn);
    @SuppressLint("WrongViewCast")
    private TextView tvEditProfile = findViewById(R.id.tv_edit_profile);
    @SuppressLint("WrongViewCast")
    private TextView tvChangePass = findViewById(R.id.tv_change_password);
    @SuppressLint("WrongViewCast")
    private TextView tvPaymentMethod = findViewById(R.id.tv_payment_method);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_setting);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_setting);
        getSupportActionBar().hide();
        setAllBtnClickListener(SettingActivity.this);

        View.OnClickListener onClickEditProfileListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener onClickChangePasswordListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, EditPasswordActivity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener onClickAddPaymentListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, AddPaymentActivity.class);
                startActivity(intent);
            }
        };

        btnEditProfile.setOnClickListener(onClickEditProfileListener);
        tvEditProfile.setOnClickListener(onClickEditProfileListener);
        btnChangePass.setOnClickListener(onClickChangePasswordListener);
        tvChangePass.setOnClickListener(onClickChangePasswordListener);
        btnPaymentMethod.setOnClickListener(onClickAddPaymentListener);
        tvPaymentMethod.setOnClickListener(onClickAddPaymentListener);



    }
}