package kr.co.heu_um.purplemarket;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;

public interface RetrofitService {

    //POST로 데이터를 보낼때는 @Field 사용 - @FormUrlEncoded와 함께 써야함
    //이미지 파일로 보낼때는 @part 사용 - @Multipart와 함께 써야함
    //@FormUrlEncoded 와 @Multipart는 동시에 사용불가
    //@Field처럼 php에서 $_POST로 받으려면 마치 GET방식의 @QueryMap 처럼 @PartMap 사용

    @Multipart
    @POST("/PurpleMarket/insertDB.php")
    Call<String> postDataToServer(@PartMap Map<String, String> dataPart, @Part MultipartBody.Part filePart);

    //서버에서 데이터를 json으로 파싱하여 가조은 추상메소드
    @GET("/PurpleMarket/loadDB.php")
    Call<ArrayList<Home_Recycler01_item>> loadDataFromServer();

    @PUT("/PurpleMarket/{fileName}")
    Call<Home_Recycler01_item> updateData(@Path("fileName") String fileName, @Body Home_Recycler01_item item);


}
