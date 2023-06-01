package fcu.app.iecs_1112_app_food;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Address extends AppCompatActivity {
    private ImageButton ibRet;
    private ImageButton ibsearch;
    private Button btnAddCurrent;
    private Button btnAddRecent1;
    private Button btnAddRecent2;
    private TextView tvAddCurr;
    private TextView tvAddRec1;
    private TextView tvAddRec2;
    private EditText etInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        ibRet = findViewById(R.id.ib_return);
        ibsearch = findViewById(R.id.ib_addr_search);
        btnAddCurrent = findViewById(R.id.btn_add1);
        btnAddRecent1 = findViewById(R.id.btn_add2);
        btnAddRecent2 = findViewById(R.id.btn_add3);
        tvAddCurr = findViewById(R.id.tv_add1);
        tvAddRec1 = findViewById(R.id.tv_add2);
        tvAddRec2 = findViewById(R.id.tv_add3);
        etInput = findViewById(R.id.et_addr_input);

        View.OnClickListener ibListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent();
                //intent.setClass(Address.this, Payment.class);
                //startActivity(intent);
                switch (v.getId()) {
                    case R.id.ib_return:
                        Payment.tvAddr.setText(tvAddCurr.getText().toString());
                        finish();
                        break;
                    case R.id.ib_addr_search:
                        if (etInput.getText().toString() != "") {
                            tvAddRec2.setText(tvAddRec1.getText().toString());
                            tvAddRec1.setText(tvAddCurr.getText().toString());
                            tvAddCurr.setText(etInput.getText().toString());
                            break;
                        }
                }
            }
        };

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addrNew;
                String addrLast;
                switch(v.getId()) {
                    case R.id.btn_add1:
                        break;
                    case R.id.btn_add2:
                        addrNew = tvAddRec1.getText().toString();
                        addrLast = tvAddCurr.getText().toString();
                        tvAddCurr.setText(addrNew);
                        tvAddRec1.setText(addrLast);
                        break;
                    case R.id.btn_add3:
                        addrNew = tvAddRec2.getText().toString();
                        addrLast = tvAddCurr.getText().toString();
                        tvAddCurr.setText(addrNew);
                        tvAddRec2.setText(tvAddRec1.getText().toString());
                        tvAddRec1.setText(addrLast);
                        break;
                }
            }
        };

        ibRet.setOnClickListener(ibListener);
        ibsearch.setOnClickListener(ibListener);
        btnAddCurrent.setOnClickListener(btnListener);
        btnAddRecent1.setOnClickListener(btnListener);
        btnAddRecent2.setOnClickListener(btnListener);

        /*if(etInput.getText().toString() != "") {
            tvAddRec2.setText(tvAddRec1.getText().toString());
            tvAddRec1.setText(tvAddCurr.getText().toString());
            tvAddCurr.setText(etInput.getText().toString());
        }*/
    }
}
