package com.example.dipes.internshipchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<PostData> data;
    List<PostData> postDataList;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIClient request = retrofit.create(APIClient.class);
        Call<List<PostData>> call = request.getJSON();
        call.enqueue(new Callback<List<PostData>>() {
            @Override
            public void onResponse(Call<List<PostData>> call, Response<List<PostData>> response) {

                Log.d("test", response.message());
                postDataList = response.body();
//                System.out.println(postDataList.get(0).getTitle());
                //data = new ArrayList<>(Arrays.asList(jsonResponse.getDatas()));
                adapter = new DataAdapter((ArrayList<PostData>) postDataList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PostData>> call, Throwable t) {
                Log.d("Error",t.getMessage());

            }

        });
    }
}
