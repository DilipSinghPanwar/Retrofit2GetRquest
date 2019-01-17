package androiddevs.com.retrofitsample.simplegetrequest.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import androiddevs.com.retrofitsample.R;
import androiddevs.com.retrofitsample.simplegetrequest.adapters.MyAdapter;
import androiddevs.com.retrofitsample.simplegetrequest.responsebeans.ApiReponseObject;
import androiddevs.com.retrofitsample.simplegetrequest.retrofit2utils.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SimpleGetRequestActivity extends AppCompatActivity {

    private final String TAG = SimpleGetRequestActivity.class.getSimpleName();

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getrequestdata);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_id);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        RetrofitClient.getServiceClass(SimpleGetRequestActivity.this).getAllPost().enqueue(new Callback<List<ApiReponseObject>>() {
            @Override
            public void onResponse(@NonNull Call<List<ApiReponseObject>> call, @NonNull Response<List<ApiReponseObject>> response) {
                if (response.isSuccessful()) {
                    Log.e(TAG, "retrofit: >>" + response.toString());
                    Log.e(TAG, "onResponse: >>" + response.body());
                    List<ApiReponseObject> postList = response.body();
                    MyAdapter adapter = new MyAdapter(getApplicationContext(), postList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ApiReponseObject>> call, Throwable throwable) {
                Log.e(TAG, "call: >>" + call);
                Log.e(TAG, "throwable: >>" + throwable.getLocalizedMessage());
            }
        });
    }
}