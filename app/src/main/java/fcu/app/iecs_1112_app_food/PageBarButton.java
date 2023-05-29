package fcu.app.iecs_1112_app_food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PageBarButton extends AppCompatActivity {
    private ImageButton homeBtn;
    private ImageButton settingBtn;
    private ImageButton myOrderBtn;
    private ImageButton phoneBtn;
    private Intent homeIntent;
    private int layoutId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        settingBtn = findViewById(R.id.img_btn_settings);
        homeBtn = findViewById(R.id.img_btn_home);
        phoneBtn = findViewById(R.id.img_btn_phone);
        myOrderBtn = findViewById(R.id.img_btn_my_order);
    }


    public void setPageBarBtnClickListener(Context context) {
        View.OnClickListener onSettingBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context.getClass() != SettingActivity.class) {
                    Intent intent = new Intent(context, SettingActivity.class);
                    context.startActivity(intent);
                }
            }
        };

        View.OnClickListener onHomeBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context.getClass() != MainPageActivity.class) {
                    Intent intent = new Intent(context, MainPageActivity.class);
                    context.startActivity(intent);
                }
            }
        };

        View.OnClickListener onPhoneBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Phone call frame
            }
        };

        View.OnClickListener onMyOrderBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context.getClass() != MyOrderActivity.class) {
                    Intent intent = new Intent(context, MyOrderActivity.class);
                    context.startActivity(intent);
                }
            }
        };

        homeBtn.setOnClickListener(onHomeBtnClickListener);
        settingBtn.setOnClickListener(onSettingBtnClickListener);
        phoneBtn.setOnClickListener(onPhoneBtnClickListener);
        myOrderBtn.setOnClickListener(onMyOrderBtnClickListener);

    }

    public void setLayoutId(int n) {
        layoutId = n;
    }
}
