package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddPaymentActivity extends PageBarButton {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_add_payment);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_add_payment);
        setPageBarBtnClickListener(AddPaymentActivity.this);
        getSupportActionBar().hide();
    }
}