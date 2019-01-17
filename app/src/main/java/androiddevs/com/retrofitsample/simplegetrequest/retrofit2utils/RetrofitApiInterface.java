package androiddevs.com.retrofitsample.simplegetrequest.retrofit2utils;

import java.util.List;

import androiddevs.com.retrofitsample.simplegetrequest.responsebeans.ApiReponseObject;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiInterface {
    @GET("v2/5a96abc232000057005e2ed7")
    Call<List<ApiReponseObject>> getAllPost();
}
