package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class EditProfileActivity extends PageBarButton {
    private ImageButton ibRet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_edit_profile);
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit_profile);
        setPageBarBtnClickListener(EditProfileActivity.this);
        getSupportActionBar().hide();

        ibRet = findViewById(R.id.ib_return);

        View.OnClickListener ibListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };

        ibRet.setOnClickListener(ibListener);
    }

}