package fcu.app.iecs_1112_app_food;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {
    private ImageButton ibRet;
    private ImageButton ibAddr;
    private ImageButton ibCardNum;
    private ImageView imaCard;
    private TextView tvAddr;
    private TextView tv300;
    private Button btnOrder;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ibRet = findViewById(R.id.ib_return);
        ibAddr = findViewById(R.id.ib_addr_ra);
        ibCardNum = findViewById(R.id.ib_card_ra);
        imaCard = findViewById(R.id.ima_card);
        tvAddr = findViewById(R.id.tv_addr);
        tv300 = findViewById(R.id.tv_300);
        btnOrder = findViewById(R.id.btn_order);

        ibRet.setOnClickListener(ibListener);
        ibAddr.setOnClickListener(ibListener);
        ibCardNum.setOnClickListener(ibListener);
        btnOrder.setOnClickListener(btnListener);
    }

    private View.OnClickListener ibListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.ib_return:
                    finish();
                    break;
                case R.id.ib_addr_ra:
                    Intent intent = new Intent();
                    intent.setClass(Payment.this, Address.class);
                    startActivity(intent);
                    break;
                case R.id.ib_card_ra:
                    Intent intent2 = new Intent();
                    intent2.setClass(Payment.this, CreditCard.class);
                    startActivity(intent2);
                    break;
            }
        }
    };

    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
