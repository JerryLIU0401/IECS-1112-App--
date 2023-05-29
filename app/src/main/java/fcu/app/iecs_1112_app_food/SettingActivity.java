package fcu.app.iecs_1112_app_food;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SettingActivity extends PageBarButton {


    private ImageButton btnEditProfile;
    private ImageButton btnChangePass;
    private ImageButton btnPaymentMethod;
    private TextView tvEditProfile;
    private TextView tvChangePass;
    private TextView tvPaymentMethod;
    private TextView tvPaymentManager;
    private ImageButton btnPaymentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_setting);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_setting);
        getSupportActionBar().hide();
        setPageBarBtnClickListener(SettingActivity.this);
        setValuebyId();


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

        View.OnClickListener onClickPaymentManagerListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, PaymentManagerActivity.class);
                startActivity(intent);
            }
        };

        btnEditProfile.setOnClickListener(onClickEditProfileListener);
        tvEditProfile.setOnClickListener(onClickEditProfileListener);
        btnChangePass.setOnClickListener(onClickChangePasswordListener);
        tvChangePass.setOnClickListener(onClickChangePasswordListener);
        btnPaymentMethod.setOnClickListener(onClickAddPaymentListener);
        tvPaymentMethod.setOnClickListener(onClickAddPaymentListener);
        tvPaymentManager.setOnClickListener(onClickPaymentManagerListener);
        btnPaymentManager.setOnClickListener(onClickPaymentManagerListener);


    }

    public void setValuebyId() {
        btnEditProfile = findViewById(R.id.edit_profile_btn);
        btnChangePass = findViewById(R.id.change_password_btn);
        btnPaymentMethod = findViewById(R.id.payment_method_btn);
        tvEditProfile = findViewById(R.id.tv_edit_profile);
        tvChangePass = findViewById(R.id.tv_change_password);
        tvPaymentMethod = findViewById(R.id.tv_payment_method);
        tvPaymentManager = findViewById(R.id.tv_payment_manager);
        btnPaymentManager = findViewById(R.id.payment_method_btn);
    }
}