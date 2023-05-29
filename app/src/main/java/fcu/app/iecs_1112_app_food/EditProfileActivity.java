package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EditProfileActivity extends PageBarButton {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_edit_profile);
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit_profile);
        setPageBarBtnClickListener(EditProfileActivity.this);
        getSupportActionBar().hide();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}