package fcu.app.iecs_1112_app_food;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MyOrderActivity extends PageBarButton {
    private ListView lvFoods;
    private Button btnPay;

    private Button btnCancel;
//    private Bundle bundle;
    private ListViewAdapter listViewAdapter;
    private List<FoodItem> foodItems;
    private TextView tv_total;
    private int totalPrice = 0;

    private ImageButton ibOrder;
    public static TextView tvTotalPrice;
    public static Boolean ifOrder = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayoutId(R.layout.activity_my_order);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_order);
        getSupportActionBar().hide();

        lvFoods = findViewById(R.id.lv_foods);
        btnPay = findViewById(R.id.btn_pay);

        //btnCancel = findViewById(R.id.btn_cancel_pay);
        tv_total = findViewById(R.id.tv_total);
        setPageBarBtnClickListener(MyOrderActivity.this);

        ibOrder = findViewById(R.id.ib_order);
        tvTotalPrice = findViewById(R.id.tv_total_price);


        foodItems = new ArrayList<FoodItem>();
        listViewAdapter = new ListViewAdapter(this, foodItems);
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

                Intent intent = new Intent(MyOrderActivity.this, MainPageActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);

                //Intent intent;
                if(ifOrder == false) {
                    intent = new Intent(MyOrderActivity.this, NoOrderActivity.class);
                    startActivity(intent);
                }else if(ifOrder == true) {
                    intent = new Intent(MyOrderActivity.this, MakeAnOrderActivity.class);
                    startActivity(intent);
                }
            }
        };

        lvFoods.setAdapter(listViewAdapter);
        btnPay.setOnClickListener(onClickPayListener);

        //btnCancel.setOnClickListener(onClickCancelPayListener);
        enableLongPressToDelete();

        ibOrder.setOnClickListener(onClickOrderListener);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        String str = "Total: " + Integer.toString(totalPrice) + " NTD";
        tv_total.setText(str);
        Bundle bundle = getIntent().getExtras();
        addFoodToShopCar(bundle);
    }

    public void addFoodToShopCar(Bundle bundle){
        if(bundle != null){
            foodItems.add(new FoodItem(bundle.getByteArray("img"),
                    bundle.getString("name"),
                    bundle.getInt("price")));
            totalPrice +=  bundle.getInt("price");
            String str = "Total: " + Integer.toString(totalPrice) + " NTD";
            tv_total.setText(str);
        }

        listViewAdapter.notifyDataSetChanged();
    }

    private void enableLongPressToDelete() {
        lvFoods.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                foodItems.remove(position);
                TextView price = view.findViewById(R.id.tv_food_price_shopcar);
                totalPrice -= Integer.parseInt(price.getText().toString());
                String str = "Total: " + Integer.toString(totalPrice) + " NTD";
                tv_total.setText(str);
                listViewAdapter.notifyDataSetChanged();
                return true;
            }
        });

        lvFoods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = view.findViewById(R.id.tv_food_name_shopcar);
                String selectedItemText = textView.getText().toString();
                //Toast.makeText(MyOrderActivity.this, "Selected item text: " + selectedItemText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

