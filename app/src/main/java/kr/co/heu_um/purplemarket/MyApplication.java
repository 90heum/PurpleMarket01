package kr.co.heu_um.purplemarket;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KakaoSdk.init(this,"18a28ea8431f88fa35d7f8fe97be878b");
    }
}
