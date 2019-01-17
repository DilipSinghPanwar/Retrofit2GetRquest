package androiddevs.com.retrofitsample.simplegetrequest.retrofit2utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://www.mocky.io/";
    private static OkHttpClient okHttpClient;

    private RetrofitClient() {
    }

    public static Retrofit getRetrofit(Context mContext, String url) {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
//                .client(getRequestHeader(mContext))
                .build();
    }

    public static RetrofitApiInterface getServiceClass(Context mContext) {
        return RetrofitClient.getRetrofit(mContext,BASE_URL).create(RetrofitApiInterface.class);
    }

    /*public static OkHttpClient getRequestHeader(Context mContext) {
        RetroCache rc = new RetroCache();
        okHttpClient = rc.createCachedClient(mContext);
        if (null == okHttpClient) {
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request.Builder ongoing = chain.request().newBuilder();
//                            ongoing.addHeader(AUTH_KEY, AUTH_VALUE);
//                            ongoing.addHeader(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
                            return chain.proceed(ongoing.build());
                        }
                    })
                    .readTimeout(TIME_OUT_MAX, TimeUnit.SECONDS)
                    .connectTimeout(TIME_OUT_MAX, TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }*/
}