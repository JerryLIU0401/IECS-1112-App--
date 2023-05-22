package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MyOrderActivity extends AppCompatActivity {

    private ImageButton imgBtnSettings;

    private ListView lvFoods;

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

                lvFoods = findViewById(R.id.lv_foods);

                List<FoodItem> foods = new ArrayList<FoodItem>();
                foods.add(new FoodItem(R.drawable.fried_chicken, "fried chicken", 50));
                foods.add(new FoodItem(R.drawable.hamburger, "hamburger", 23));
                foods.add(new FoodItem(R.drawable.orange, "orange", 64));
                foods.add(new FoodItem(R.drawable.spaghetti, "spaghetti", 67));
                foods.add(new FoodItem(R.drawable.strawberry, "strawberry", 46));

                ListViewAdapter adapter = new ListViewAdapter(MyOrderActivity.this, foods);
                lvFoods.setAdapter(adapter);

            }
        };
        imgBtnSettings.setOnClickListener(onClickListener);
    }
}