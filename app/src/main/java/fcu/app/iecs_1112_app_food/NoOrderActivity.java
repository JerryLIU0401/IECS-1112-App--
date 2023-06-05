package fcu.app.iecs_1112_app_food;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class NoOrderActivity extends AppCompatActivity {
    private ImageButton ibRet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_no_order);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        ibRet = findViewById(R.id.ib_return);

        View.OnClickListener ibListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(NoOrderActivity.this, MyOrderActivity.class);
                startActivity(intent);
            }
        };

        ibRet.setOnClickListener(ibListener);
    }
}
