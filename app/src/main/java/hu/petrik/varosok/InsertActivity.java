package hu.petrik.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

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
        addBtn.setOnClickListener(view->{
            felvetel();
        });
    }

    private void init() {
        backBtn2 = findViewById(R.id.backBtn2);
        addBtn = findViewById(R.id.addBtn);
        nev = findViewById(R.id.nev);
        orszag = findViewById(R.id.orszag);
        lakossag = findViewById(R.id.lakossag);
    }

    private void felvetel() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Response response = null;
        try {
            response = RequestHandler.get(MainActivity.BASE_URL);
            String content = response.getContent();
            String name = nev.getText().toString().trim();
            String country = orszag.getText().toString().trim();
            String lakossag1 = lakossag.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "A név megadása kötelező", Toast.LENGTH_SHORT).show();
                return;
            }
            if (country.isEmpty()) {
                Toast.makeText(this, "Az ország megadása kötelező", Toast.LENGTH_SHORT).show();
                return;
            }
            if (lakossag1.isEmpty()) {
                Toast.makeText(this, "A lakosság számának megadása kötelező", Toast.LENGTH_SHORT).show();
                return;
            }
            int lakossagint = Integer.parseInt(lakossag1);
            City city = new City(0, name, country, lakossagint);
            Gson converter = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            String jsonfile = converter.toJson(city);
            Response response1 = RequestHandler.post(MainActivity.BASE_URL, jsonfile);

        } catch (IOException e) {
            Toast.makeText(this, "Hiba történt a szerverrel való kommunikáció során", Toast.LENGTH_SHORT).show();
        }

    }

}