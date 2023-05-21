package fcu.app.iecs_1112_app_food;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreditCard extends AppCompatActivity {
    private ImageButton ibRet;
    private ImageButton ibClose;
    private ImageButton ibPlus;
    private Button btnCard0501;
    private Button btnCard9437;
    private Button btnCard2048;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        ibRet = findViewById(R.id.ib_return);
        ibClose = findViewById(R.id.ib_close);
        ibPlus = findViewById(R.id.ib_plus_method);
        btnCard0501 = findViewById(R.id.btn_card0501);
        btnCard9437 = findViewById(R.id.btn_card9437);
        btnCard2048 = findViewById(R.id.btn_card2048);

        ibRet.setOnClickListener(ibListener);
        ibClose.setOnClickListener(ibListener);
        ibPlus.setOnClickListener(ibListener);
        btnCard0501.setOnClickListener(btnListener);
        btnCard9437.setOnClickListener(btnListener);
        btnCard2048.setOnClickListener(btnListener);
    }

    private View.OnClickListener ibListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.ib_return:
                    break;
                case R.id.ib_close:
                    break;
                case R.id.ib_plus_method:
                    break;
            }
        }
    };

    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btn_card0501:
                    break;
                case R.id.btn_card9437:
                    break;
                case R.id.btn_card2048:
                    break;
            }
        }
    };
}

