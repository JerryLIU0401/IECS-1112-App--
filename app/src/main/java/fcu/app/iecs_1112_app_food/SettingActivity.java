package fcu.app.iecs_1112_app_food;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingActivity extends PageBarButton {


    private ImageButton btnEditProfile;
    private ImageButton btnChangePass;
    private ImageButton btnPaymentMethod;
    private ImageButton btnAboutUs;
    private ImageButton btnPrivacyPolicy;
    private ImageButton btnTerm;
    private TextView tvEditProfile;
    private TextView tvChangePass;
    private TextView tvPaymentMethod;
    private TextView tvPaymentManager;
    private TextView tvUserName;
    private ImageView ivUserIcon;
    private ImageButton btnPaymentManager;
    private BroadcastReceiver broadcastReceiver;
    private int userId;

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
                Intent intent = new Intent();
                intent.setClass(SettingActivity.this, AddPaymentActivity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener onClickPaymentManagerListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SettingActivity.this, PaymentManagerActivity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener onClickMoreListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.about_us_btn:
                        Intent intent = new Intent();
                        intent.setClass(SettingActivity.this, AboutUsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.privacy_policy_btn:
                        Intent intent2 = new Intent();
                        intent2.setClass(SettingActivity.this, PrivacyPolicyActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.term_btn:
                        Intent intent3 = new Intent();
                        intent3.setClass(SettingActivity.this, TermActivity.class);
                        startActivity(intent3);
                        break;
                }
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

        btnAboutUs.setOnClickListener(onClickMoreListener);
        btnPrivacyPolicy.setOnClickListener(onClickMoreListener);
        btnTerm.setOnClickListener(onClickMoreListener);


    }


    public void setValuebyId() {
        ivUserIcon = findViewById(R.id.iv_icon_setting);
        tvUserName = findViewById(R.id.tv_userIcon);
        btnEditProfile = findViewById(R.id.edit_profile_btn);
        btnChangePass = findViewById(R.id.change_password_btn);
        btnPaymentMethod = findViewById(R.id.payment_method_btn);
        tvEditProfile = findViewById(R.id.tv_edit_profile);
        tvChangePass = findViewById(R.id.tv_change_password);
        tvPaymentMethod = findViewById(R.id.tv_payment_method);
        tvPaymentManager = findViewById(R.id.tv_payment_manager);
        btnPaymentManager = findViewById(R.id.payment_manager_btn);

        btnAboutUs = findViewById(R.id.about_us_btn);
        btnPrivacyPolicy = findViewById(R.id.privacy_policy_btn);
        btnTerm = findViewById(R.id.term_btn);
    }
}