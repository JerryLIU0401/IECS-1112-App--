package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PaymentManagerActivity extends PageBarButton {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_payment_manager);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_payment_manager);
        setPageBarBtnClickListener(PaymentManagerActivity.this);
        getSupportActionBar().hide();
    }

}