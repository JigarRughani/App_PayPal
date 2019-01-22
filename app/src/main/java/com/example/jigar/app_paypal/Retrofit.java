package com.example.jigar.app_paypal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jigar.app_paypal.Interfaces.Api;
import com.example.jigar.app_paypal.Responses.PostLoginResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

       // textView =(TextView) findViewById(R.id.tv_res);
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
               .baseUrl("http://192.185.129.71/~webservices1/resto/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api  = retrofit.create(Api.class);

        Call<PostLoginResponse> call = api.postLoginDetail("jigar","123","admin");
        call.enqueue(new Callback<PostLoginResponse>() {
            @Override
            public void onResponse(Call<PostLoginResponse> call, Response<PostLoginResponse> response) {
                String aa = response.body().getMessage();
            }

            @Override
            public void onFailure(Call<PostLoginResponse> call, Throwable t) {

            }
        });
    }
}
