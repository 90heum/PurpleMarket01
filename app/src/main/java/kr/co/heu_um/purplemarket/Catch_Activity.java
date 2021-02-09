package kr.co.heu_um.purplemarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Catch_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_);

        getSupportActionBar().setTitle("장바구니");
    }
}