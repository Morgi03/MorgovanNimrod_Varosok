package hu.petrik.varosok;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button listBtn;
    private Button newitemBtn;
    protected final static String BASE_URL = "https://retoolapi.dev/cnu7aa/varosok";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
            finish();
        });
        newitemBtn.setOnClickListener(view -> {
            Intent intent = new Intent( MainActivity.this, InsertActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void init() {
        listBtn = findViewById(R.id.listBtn);
        newitemBtn = findViewById(R.id.newitemBtn);
    }
}