package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SettingActivity extends PageBarButton {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_setting);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_setting);
        getSupportActionBar().hide();
        setAllBtnClickListener(SettingActivity.this);
    }
}