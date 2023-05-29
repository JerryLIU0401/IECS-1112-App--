package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EditPasswordActivity extends PageBarButton {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_edit_password);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_edit_password);
        setPageBarBtnClickListener(EditPasswordActivity.this);
        getSupportActionBar().hide();
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}