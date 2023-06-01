package fcu.app.iecs_1112_app_food;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PageBarButton extends AppCompatActivity {
    private ImageButton homeBtn;
    private ImageButton settingBtn;
    private ImageButton myOrderBtn;
    private ImageButton phoneBtn;
    private int layoutId;
    private boolean phoneCallPermission;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        settingBtn = findViewById(R.id.img_btn_settings);
        homeBtn = findViewById(R.id.img_btn_home);
        phoneBtn = findViewById(R.id.img_btn_phone);
        myOrderBtn = findViewById(R.id.img_btn_my_order);
        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 100);
    }

    @Override
    protected void onResume() {
        super.onResume();
        phoneCallPermission = checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED;
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
                System.out.println(phoneCallPermission);
                if (phoneCallPermission) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + "000000000"));
                    startActivity(intent);
                }
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
