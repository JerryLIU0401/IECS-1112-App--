package fcu.app.iecs_1112_app_food;

import android.os.Bundle;

public class MainPageActivity extends PageBarButton{
    //private ImageButton settingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_main_page);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setPageBarBtnClickListener(MainPageActivity.this);
    }


}