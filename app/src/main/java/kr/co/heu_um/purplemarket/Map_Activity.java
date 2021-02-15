package kr.co.heu_um.purplemarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map_Activity extends AppCompatActivity implements GoogleMap.OnMarkerClickListener {

    GoogleMap gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
       // getSupportActionBar().setTitle("주소검색");


        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                //파라미터로 전달된 GoogleMap이 지도 객체임!
                gMap = googleMap; //멤버변수에 대입하면 이 객체를 다른 메소드에서도 사용가능

                //지도의 특정좌표 이동 및 줌인
                LatLng seoul = new LatLng(37.5628087, 127.035192);
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul, 15)); //줌 : 1~25

                //마커추가하기
                MarkerOptions marker = new MarkerOptions();
                marker.title("왕십리");
                marker.snippet("왕십리역에 있는 미래능력개발교육원");
                marker.position(seoul);

                marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.location)); //아이콘이미지는 벡터이미지는 안됨!,반드시 .jpg or .png같은 픽셀이미지여야만함
                marker.anchor(0.5f, 1.0f);                                       //아이콘사이즈는 첨부터작게만들어야됨 원본사이즈그대로나오니깐!

              


                //지도의 대표적인 설정들
                UiSettings settings = gMap.getUiSettings();

                //줌땡기는거 + -
                settings.setZoomControlsEnabled(true);

                //내위치 탐색을 지도라이브러리에서 제공해줌
                settings.setMyLocationButtonEnabled(true);

                //내위치를 요구해야 버튼 보여짐(명시적 퍼미션 체크코드 필요)
                if (ActivityCompat.checkSelfPermission(Map_Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Map_Activity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }

                gMap.setMyLocationEnabled(true);



                //나머지 관련 내용을 개발자사이트의 가이드를 참고해서 시도해보세요
            }


        });


        //동적퍼미션작업!
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_DENIED){
                String[] permissions= new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions,0);
            }
    }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 0:
//                if(grantResults[0] ==PackageManager.PERMISSION_GRANTED || grantResults[1] ==PackageManager.PERMISSION_DENIED){
//                    Toast.makeText(this, "이 앱의 내 위치 사용불가", Toast.LENGTH_SHORT).show();
//                }

                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                        Toast.makeText(this, "내 위치 사용불가", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                break;


        }

    }

    @Override
    public boolean onMarkerClick(Marker marker) {



        Toast.makeText(this, "표시되었습니다", Toast.LENGTH_SHORT).show();
        return true;
    }
}