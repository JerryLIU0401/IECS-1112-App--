package fcu.app.iecs_1112_app_food;

import android.annotation.SuppressLint;
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
    private Button btnAddCurrent;
    private Button btnAddRecent1;
    private Button btnAddRecent2;
    private TextView tvAddCurr;
    private TextView tvAddRec1;
    private TextView tvAddRec2;
    private EditText etInput;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        ibRet = findViewById(R.id.ib_return);
        btnAddCurrent = findViewById(R.id.btn_add1);
        btnAddRecent1 = findViewById(R.id.btn_add2);
        btnAddRecent2 = findViewById(R.id.btn_card2048);
        tvAddCurr = findViewById(R.id.tv_add1);
        tvAddRec1 = findViewById(R.id.tv_add2);
        tvAddRec2 = findViewById(R.id.tv_add3);
        etInput = findViewById(R.id.et_addr_input);

        ibRet.setOnClickListener(ibListener);
        btnAddCurrent.setOnClickListener(btnListener);
        btnAddRecent1.setOnClickListener(btnListener);
        btnAddRecent2.setOnClickListener(btnListener);
    }

    private View.OnClickListener ibListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    };

    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btn_add1:
                    break;
                case R.id.btn_add2:
                    break;
                case R.id.btn_card2048:
                    break;
            }
        }
    };

}
