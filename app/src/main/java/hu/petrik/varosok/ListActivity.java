package hu.petrik.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class ListActivity extends AppCompatActivity {
    private Button backBtn;
    private TextView datainJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        init();
        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(ListActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void init() {
        backBtn = findViewById(R.id.backBtn);
        datainJson = findViewById(R.id.datainJson);
        Response response = null;
        try {
            response = RequestHandler.get(MainActivity.BASE_URL);
            String content = response.getContent();
            datainJson.setText(content);
        } catch (IOException e) {
            Toast.makeText(this, "Nem sikerült adatot lekérni a szerverről", Toast.LENGTH_SHORT).show();
            datainJson.setText("ERROR");
        }

    }
}