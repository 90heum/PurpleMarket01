package kr.co.heu_um.purplemarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Map_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_);

        getSupportActionBar().setTitle("주소검색");
    }
}