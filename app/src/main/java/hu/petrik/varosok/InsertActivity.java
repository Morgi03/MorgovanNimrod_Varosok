package hu.petrik.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    private Button backBtn2;
    private Button addBtn;
    private EditText nev;
    private EditText orszag;
    private EditText lakossag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();
        backBtn2.setOnClickListener(view -> {
            Intent intent = new Intent(InsertActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void init() {
        backBtn2 = findViewById(R.id.backBtn2);
        addBtn = findViewById(R.id.addBtn);
        nev = findViewById(R.id.nev);
        orszag = findViewById(R.id.orszag);
        lakossag = findViewById(R.id.lakossag);
    }
}