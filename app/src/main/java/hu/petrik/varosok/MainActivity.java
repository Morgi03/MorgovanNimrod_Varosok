package hu.petrik.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button listBtn;
    private Button newitemBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
            finish();
        });
        newitemBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, InsertActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void init() {
        listBtn = findViewById(R.id.listBtn);
        newitemBtn = findViewById(R.id.newitemBtn);
    }
}