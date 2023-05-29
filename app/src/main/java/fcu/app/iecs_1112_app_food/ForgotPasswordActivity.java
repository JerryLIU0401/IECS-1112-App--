package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ForgotPasswordActivity extends PageBarButton {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayoutId(R.layout.activity_forgot_password);
        //setContentView(R.layout.activity_forgot_password);
        setPageBarBtnClickListener(ForgotPasswordActivity.this);
        getSupportActionBar().hide();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}