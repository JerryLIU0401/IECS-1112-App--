package fcu.app.iecs_1112_app_food;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import java.io.IOException;

public class MainPageActivity extends PageBarButton{
    private Button btnAddImg;

    private ActivityResultLauncher<String> imgPickerLauncher;
    private ImageButton foodImg;
    private LinearLayout scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_main_page);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setPageBarBtnClickListener(MainPageActivity.this);
        btnAddImg = findViewById(R.id.btn_addImgMainPage);
        foodImg = findViewById(R.id.mainPageFood1btn);
        scrollView = findViewById(R.id.mainpageSvLinear);

        View.OnClickListener onClcikbtnAddIngListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        };

        imgPickerLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        if (result != null) {
                            addImageButtonToView(result);
                        }
                    }
                }
        );

        btnAddImg.setOnClickListener(onClcikbtnAddIngListener);
    }

    private void openGallery() {
        imgPickerLauncher.launch("image/*");
    }

    private void addImageButtonToView(Uri imageUri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri); //將 URI 轉換為 Bitmap 物件
            setImageAllAttributes(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 將 dp 值轉換為 px 值
    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
    private void setImageAllAttributes(Bitmap bitmap){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout linearLayoutOuterLayer = new LinearLayout(this);
        linearLayoutOuterLayer.setOrientation(LinearLayout.VERTICAL);
        linearLayoutOuterLayer.setLayoutParams(layoutParams);
        linearLayoutOuterLayer.setGravity(Gravity.CENTER);

        ImageButton imgButton = new ImageButton(this);
        imgButton.setImageBitmap(bitmap);
        LinearLayout.LayoutParams btnLayoutParams = new LinearLayout.LayoutParams(dpToPx(300),dpToPx(200));
        imgButton.setLayoutParams(btnLayoutParams);

        LinearLayout linearLayoutInsideLayer = new LinearLayout(this);
        LinearLayout.LayoutParams insideLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        insideLayoutParams.setMargins(dpToPx(20),0,dpToPx(20),0);
        linearLayoutInsideLayer.setLayoutParams(insideLayoutParams);
        linearLayoutInsideLayer.setGravity(Gravity.CENTER);
        linearLayoutInsideLayer.setOrientation(LinearLayout.HORIZONTAL);

        TextView textView = new TextView(this);
        textView.setText("food");
        LinearLayout.LayoutParams tvLaoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(tvLaoutParams);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);

        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams imgViewLayoutParams = new LinearLayout.LayoutParams(dpToPx(20), dpToPx(20));
        imageView.setLayoutParams(imgViewLayoutParams);

        linearLayoutInsideLayer.addView(textView, tvLaoutParams);
        linearLayoutInsideLayer.addView(imageView, imgViewLayoutParams);
        linearLayoutOuterLayer.addView(imgButton, btnLayoutParams);
        linearLayoutOuterLayer.addView(linearLayoutInsideLayer, insideLayoutParams);

        scrollView.addView(linearLayoutOuterLayer);
    }
}