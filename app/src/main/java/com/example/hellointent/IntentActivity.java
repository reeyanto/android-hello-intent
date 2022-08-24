package com.example.hellointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity {

    private static String[] pilihan = {"Lihat Peta", "Kunjungi website", "Lakukan panggilan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        String nama = getIntent().getStringExtra("NAMA");
        if (nama != null) {
            Toast.makeText(this, "Hai "+ nama, Toast.LENGTH_SHORT).show();
        }

        ListView lv_list = findViewById(R.id.lv_list);
        lv_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pilihan));

        lv_list.setOnItemClickListener((aView, view, i, l) -> {
            if (i == 0) lihatPeta();
            else if (i == 1) kunjungiWebsite();
            else lakukanPanggilan();
        });
    }

    private void lihatPeta() {
        Intent peta = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Google+Indonesia"));
        startActivity(peta);
    }

    private void kunjungiWebsite() {
        Intent website = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        startActivity(website);
    }

    private void lakukanPanggilan() {
        Intent panggilan = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+622130422800"));
        startActivity(panggilan);
    }
}