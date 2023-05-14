package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainPageActivity extends PageBarButton{
    //private ImageButton settingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_main_page);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setAllBtnClickListener(MainPageActivity.this);
    }


}