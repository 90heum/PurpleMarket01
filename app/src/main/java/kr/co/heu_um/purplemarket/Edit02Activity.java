package kr.co.heu_um.purplemarket;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Edit02Activity extends AppCompatActivity {

    ImageView p_iv02;
    String imgPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit02);

        p_iv02=findViewById(R.id.p_iv02);
    }

    public void clickSelectImage(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,9);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==9 && resultCode==RESULT_OK){
            Uri uri=data.getData();
            if(uri != null){
                Glide.with(this).load(uri).into(p_iv02);
                //이미지 uri를 절대주소로 변경해야 파일 업로드가 가능함
                //uri -->절대경로
                imgPath=getRealPathFromUri(uri);
                //경로잘되어있는지 확인!
                new AlertDialog.Builder(this).setMessage(imgPath).show();
            }
        }
    }
    String getRealPathFromUri(Uri uri){
        String[] proj={MediaStore.Images.Media.DATA};
        CursorLoader loader= new CursorLoader(this,uri,proj,null,null,null);
        Cursor cursor= loader.loadInBackground();
        int column_index= cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result= cursor.getString(column_index);
        cursor.close();
        return result;
    }

    public void clickComplete(View view) {


        //레트로핏작업  5단계
        Retrofit retrofit= RetrofitHelper.getRetrofitInstanceScalars();
        RetrofitService02 retrofitService=retrofit.create(RetrofitService02.class);

        //이미지파일 MultipartBody.part로 포장
        MultipartBody.Part filePart=null;
        if(imgPath!=null){
            File file= new File(imgPath);
            RequestBody requestBody=RequestBody.create(MediaType.parse("image/*"),file);
            filePart= MultipartBody.Part.createFormData("img", file.getName(),requestBody);
        }


        Call<String> call= retrofitService.postDataToServer(filePart);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                String s= response.body();
                Toast.makeText(Edit02Activity.this, ""+s, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(Edit02Activity.this, "error"+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        finish();


    }
}