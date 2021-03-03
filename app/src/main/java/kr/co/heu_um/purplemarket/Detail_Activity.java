package kr.co.heu_um.purplemarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail_Activity extends AppCompatActivity {

    TextView detail_title;
    TextView detail_title02;
    TextView detail_price;
    ImageView detail_img;




    //toolbar 메뉴 넣기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topmenu_detail,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //toolbar 메뉴 동작
   @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.detail_cart){

            Intent intent= new Intent(this,Cart_Activity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);

        Toolbar toolbar=findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        detail_title=findViewById(R.id.detail_title);
        detail_title02=findViewById(R.id.detail_title02);
        detail_price=findViewById(R.id.detail_price);
        detail_img=findViewById(R.id.detail_img);

        Intent intent= getIntent();

        String title= intent.getStringExtra("title");
        String price= intent.getStringExtra("price");
        String img= intent.getStringExtra("img");

        detail_title.setText(title);
        detail_title02.setText(title);
        detail_price.setText(price);

        Glide.with(this).load(img).into(detail_img);


    }
}