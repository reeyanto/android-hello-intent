package com.example.hellointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPindah, btnPindahData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindah       = findViewById(R.id.btn_pindah);
        btnPindahData   = findViewById(R.id.btn_pindah_data);

        btnPindah.setOnClickListener(this);
        btnPindahData.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_pindah) {
            Intent intent = new Intent(this, IntentActivity.class);
            startActivity(intent);
        }

        else {
            Intent intentData = new Intent(this, IntentActivity.class);
            intentData.putExtra("NAMA", "Riyanto");
            startActivity(intentData);
        }
    }
}