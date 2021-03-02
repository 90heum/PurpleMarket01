package kr.co.heu_um.purplemarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail_Activity extends AppCompatActivity {

    TextView detail_title;
    TextView detail_price;
    ImageView detail_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);

        detail_title=findViewById(R.id.detail_title);
        detail_price=findViewById(R.id.detail_price);
        detail_img=findViewById(R.id.detail_img);

        Intent intent= getIntent();

        String title= intent.getStringExtra("title");
        String price= intent.getStringExtra("price");
        String img= intent.getStringExtra("img");

        detail_title.setText(title);
        detail_price.setText(price);
        Glide.with(this).load(img).into(detail_img);


    }
}