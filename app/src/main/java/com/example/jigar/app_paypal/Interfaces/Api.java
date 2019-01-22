package com.example.jigar.app_paypal.Interfaces;

import com.example.jigar.app_paypal.Responses.GetLogin;
import com.example.jigar.app_paypal.Responses.PostLoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Jigar on 1/4/2019.
 */

public interface Api {
    @Headers({"Authorization:Key"})

    @FormUrlEncoded
    @POST("login")
    Call<PostLoginResponse> postLoginDetail(@Field("user_name") String user_nm,
                                            @Field("pass") String pass,
                                            @Field("type") String type);

    @GET("Login/{email_add}/{pass}/{token_id}/{mobile_key}")
    Call<GetLogin>getLoginDetail(@Path("email_add") String email,
                                 @Path("pass") String pass,
                                 @Path("token_id") String token_id,
                                 @Path("mobile_key") String mobile_key);


//    @FormUrlEncoded
//    @POST("login.php")
//    Call<PostLoginResponse>posrLoginDetail(@Field("user_nm") String user_nm,
//                                            @Field("pass") String pass,
//                                           @Field("type") String type);
}
