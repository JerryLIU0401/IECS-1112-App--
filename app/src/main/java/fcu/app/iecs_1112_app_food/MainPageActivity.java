package fcu.app.iecs_1112_app_food;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import java.io.IOException;
import java.util.Map;

public class MainPageActivity extends PageBarButton{
    private Button btnAddImg;
    private ListView lv_restaurant;
    private ActivityResultLauncher<String> imgPickerLauncher;
    private RestaurantDatabaseHandler databaseHandler;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_main_page);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setPageBarBtnClickListener(MainPageActivity.this);
        btnAddImg = findViewById(R.id.btn_addImgMainPage);
        lv_restaurant = findViewById(R.id.lv_restaurant);
        bundle = new Bundle();
        databaseHandler = new RestaurantDatabaseHandler(this);
        databaseHandler.open();

       View.OnClickListener onClickRestaurantBtnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPageActivity.this, MealSelectActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        };

        View.OnClickListener onClcikbtnAddIngListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPageActivity.this, AddRestaurantActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        };

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor cursor = databaseHandler.getAllRestaurant();
                cursor.moveToFirst();
                int index = 0 , id = 0;
                if(i == index){                 //獲取id
                    id = cursor.getInt(0);
                }else {
                    index++;
                    while(cursor.moveToNext()){
                        id = cursor.getInt(0);
                        if(index >= i){
                            break;
                        }else{
                            index++;
                        }
                    }
                }
                //Toast.makeText(MainPageActivity.this, Integer.toString(id), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainPageActivity.this, MealSelectActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
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
        lv_restaurant.setOnItemClickListener(onItemClickListener);
        showAllRestaurant();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showAllRestaurant();
    }

    private void showAllRestaurant(){
        Cursor cursor = databaseHandler.getAllRestaurant();
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.restaurant_item,
                cursor, new String[]{"name", "img"}, new int[]{R.id.tv_restaurant_item, R.id.item_restaurant_imgBtn});

        adapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Cursor cursor, int i) {
                if(view.getId() == R.id.item_restaurant_imgBtn){
                    byte imageData[] = cursor.getBlob(i);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
                    ImageView img = (ImageView) view;
                    img.setImageBitmap(bitmap);
                    return true;
                }
                return false;
            }
        });
        lv_restaurant.setAdapter(adapter);
    }

    private void openGallery() {
        imgPickerLauncher.launch("image/*");
    }

    private void addImageButtonToView(Uri imageUri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri); //將 URI 轉換為 Bitmap 物件
            //setImageAllAttributes(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 將 dp 值轉換為 px 值
    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}