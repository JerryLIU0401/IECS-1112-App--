package fcu.app.iecs_1112_app_food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyOrderActivity extends PageBarButton {

    private ListView lvFoods;
    private Button btnPay;
    private ImageButton ibOrder;
    public static TextView tvTotalPrice;
    public static Boolean ifOrder = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_my_order);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_order);
        getSupportActionBar().hide();
        setPageBarBtnClickListener(MyOrderActivity.this);

        lvFoods = findViewById(R.id.lv_foods);

        btnPay = findViewById(R.id.btn_pay);
        ibOrder = findViewById(R.id.ib_order);
        tvTotalPrice = findViewById(R.id.tv_total_price);



        List<FoodItem> foods = new ArrayList<FoodItem>();
        foods.add(new FoodItem(R.drawable.fried_chicken, "fried chicken", 50));
        foods.add(new FoodItem(R.drawable.hamburger, "hamburger", 23));
        foods.add(new FoodItem(R.drawable.orange, "orange", 64));
        foods.add(new FoodItem(R.drawable.spaghetti, "spaghetti", 67));
        foods.add(new FoodItem(R.drawable.strawberry, "strawberry", 46));

        ListViewAdapter adapter = new ListViewAdapter(MyOrderActivity.this, foods);
        lvFoods.setAdapter(adapter);

        View.OnClickListener onClickPayListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                intent2.setClass(MyOrderActivity.this, Payment.class);
                startActivity(intent2);
            }
        };
        View.OnClickListener onClickOrderListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ifOrder == false) {
                    Intent intent = new Intent(MyOrderActivity.this, NoOrderActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MyOrderActivity.this, MakeAnOrderActivity.class);
                    startActivity(intent);
                }
            }
        };
        btnPay.setOnClickListener(onClickPayListener);
        ibOrder.setOnClickListener(onClickOrderListener);
    }
}