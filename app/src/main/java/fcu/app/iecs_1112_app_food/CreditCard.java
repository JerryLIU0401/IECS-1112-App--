package fcu.app.iecs_1112_app_food;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreditCard extends AppCompatActivity {
    private ImageButton ibRet;
    private ImageButton ibPlus;
    private ImageView imaCheckCard0501;
    private ImageView imaCheckCard9437;
    private ImageView imaCheckCard2048;
    private TextView card0501;
    private TextView card9437;
    private TextView card2048;

    private Button btnCard0501;
    private Button btnCard9437;
    private Button btnCard2048;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);
        getSupportActionBar().hide();

        ibRet = findViewById(R.id.ib_return);
        ibPlus = findViewById(R.id.ib_plus_method);

        imaCheckCard0501 = findViewById(R.id.ima_check_card1);
        imaCheckCard9437 = findViewById(R.id.ima_check_card2);
        imaCheckCard2048 = findViewById(R.id.ima_check_card3);

        btnCard0501 = findViewById(R.id.btn_card0501);
        btnCard9437 = findViewById(R.id.btn_card9437);
        btnCard2048 = findViewById(R.id.btn_card2048);

        card0501 = findViewById(R.id.tv_card0501);
        card9437 = findViewById(R.id.tv_card9437);
        card2048 = findViewById(R.id.tv_card2048);
        View.OnClickListener ibListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.ib_return:
                        //Intent intent = new Intent();
                        //intent.setClass(CreditCard.this, Payment.class);
                        //startActivity(intent);
                        finish();
                        break;
                    case R.id.ib_plus_method:
                        Intent intent = new Intent();
                        intent.setClass(CreditCard.this, AddPaymentActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.btn_card0501:
                        Payment.tvCardNum.setText(card0501.getText().toString());
                        Payment.imaCard.setImageDrawable(getResources().getDrawable(R.drawable.jcb));
                        imaCheckCard0501.setVisibility(View.VISIBLE);
                        imaCheckCard9437.setVisibility(View.INVISIBLE);
                        imaCheckCard2048.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.btn_card9437:
                        Payment.tvCardNum.setText(card9437.getText().toString());
                        Payment.imaCard.setImageDrawable(getResources().getDrawable(R.drawable.visa));
                        imaCheckCard0501.setVisibility(View.INVISIBLE);
                        imaCheckCard9437.setVisibility(View.VISIBLE);
                        imaCheckCard2048.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.btn_card2048:
                        Payment.tvCardNum.setText(card2048.getText().toString());
                        Payment.imaCard.setImageDrawable(getResources().getDrawable(R.drawable.paypal));
                        imaCheckCard0501.setVisibility(View.INVISIBLE);
                        imaCheckCard9437.setVisibility(View.INVISIBLE);
                        imaCheckCard2048.setVisibility(View.VISIBLE);
                        break;
                }
            }
        };

        ibRet.setOnClickListener(ibListener);
        ibPlus.setOnClickListener(ibListener);
        btnCard0501.setOnClickListener(btnListener);
        btnCard9437.setOnClickListener(btnListener);
        btnCard2048.setOnClickListener(btnListener);

    }
}

