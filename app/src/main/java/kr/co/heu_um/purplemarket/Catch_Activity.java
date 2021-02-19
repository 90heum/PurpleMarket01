package kr.co.heu_um.purplemarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Catch_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_);

    }

    public void clickChuCheon(View view) {
        Intent intent= new Intent(this,Edit01Activity.class);
        startActivity(intent);
    }

    public void clickBanner(View view) {
        Intent intent= new Intent(this,Edit02Activity.class);
        startActivity(intent);


    }
}