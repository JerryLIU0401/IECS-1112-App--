package fcu.app.iecs_1112_app_food;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnDemoMyOrder;
    private Button btnDropTable;
    private Button btnAddImg;
    private Uri imageUri;
    private static final int PICK_IMAGE_REQUEST = 1;
    private AccountDatabaseHandler accountDatabaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnDemoMyOrder = findViewById(R.id.btn_demo_my_order);
        btnDropTable = findViewById(R.id.drop_table_btn);
        btnAddImg = findViewById(R.id.addmagebtnMain);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener onDropTableClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountDatabaseHandler = new AccountDatabaseHandler(MainActivity.this);
                accountDatabaseHandler.open();
                accountDatabaseHandler.dropTable();
            }
        };


        btnDemoMyOrder.setOnClickListener(onClickListener);
        btnDropTable.setOnClickListener(onDropTableClickListener);

    }
}