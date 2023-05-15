package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MyOrderActivity extends PageBarButton {

    private ImageButton imgBtnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_my_order);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_order);
        getSupportActionBar().hide();
        setAllBtnClickListener(MyOrderActivity.this);
    }

}