package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MyOrderActivity extends AppCompatActivity {

    private ImageButton imgBtnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        imgBtnSettings = findViewById(R.id.img_btn_settings);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyOrderActivity.this, SettingActivity.class);
                startActivity(intent);

            }
        };
        imgBtnSettings.setOnClickListener(onClickListener);
    }
}