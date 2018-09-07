package com.example.dipes.internshipchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<PostData> arr;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=(ListView) findViewById(R.id.list_view);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIClient apiClient=retrofit.create(APIClient.class);
//        Call call =apiClient.getPosts();
       Call<List<PostData>> call= apiClient.getPosts();
       call.enqueue(new Callback<List<PostData>>() {
           @Override
           public void onResponse(Call<List<PostData>> call, Response<List<PostData>> response) {
               List<PostData> postData = response.body();

               String [] data = new String[postData.size()];
               for(int i=0; i<postData.size(); i++) {
//                   System.out.println(postData.get(i).toString());
                   data[i] = postData.get(i).getBody();
//                   data[i] = postData.get(i).getTitle().toUpperCase();
//                   data[i] = postData.get(i).getId();
               }
               listView.setAdapter(
                       new ArrayAdapter<>(
                               getApplicationContext(),
                               android.R.layout.simple_list_item_1,
                               data
                       ));
           }

           @Override
           public void onFailure(Call<List<PostData>> call, Throwable t) {
               Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
           }
       });



    }
}
