package androiddevs.com.retrofitsample.simplegetrequest.retrofit2utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RetroCache {

    public static void retroCache(String args[]){  }

    public OkHttpClient createCachedClient(final Context mCcontext) {
        File httpCacheDirectory = new File(mCcontext.getCacheDir(), "cache_file");

        Cache cache = new Cache(httpCacheDirectory, 20 * 1024 * 1024);  // create the cache object with 20 MB
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newBuilder().cache(cache);
        okHttpClient.interceptors().add(
                new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();
                        String cacheHeaderValue = isNetworkAvailable(mCcontext)
                                ? "public, max-age=2419200"   //If there is connectivity, we tell the request it can reuse the data for sixty seconds.
                                : "public, only-if-cached, max-stale=2419200" ;  // example:‘stale’ data upto 7 days ago. (60 * 60 * 24 * 7)
                        Request request = originalRequest.newBuilder().build();
                        Response response = chain.proceed(request);
                        return response.newBuilder()
                                .removeHeader("Pragma")
                                .removeHeader("Cache-Control")
                                .header("Cache-Control", cacheHeaderValue)
                                .build();
                    }
                }
        );
        okHttpClient.networkInterceptors().add(
                new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();
                        String cacheHeaderValue = isNetworkAvailable(mCcontext)
                                ? "public, max-age=2419200"
                                : "public, only-if-cached, max-stale=2419200" ;
                        Request request = originalRequest.newBuilder().build();
                        Response response = chain.proceed(request);
                        return response.newBuilder()
                                .removeHeader("Pragma")
                                .removeHeader("Cache-Control")
                                .header("Cache-Control", cacheHeaderValue)
                                .build();
                    }
                }
        );

        return okHttpClient;
    }

    public boolean isNetworkAvailable(Context ctxx) {
        Context ctx = ctxx;
        ConnectivityManager cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}