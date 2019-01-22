package com.example.jigar.app_paypal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.jigar.app_paypal.Interfaces.IResult;

import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {
    IResult iResult = null;
    private String TAG = "MainActivity";
    Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String user_nm = "smith.jordan@gmail.com";
        String pass = "Test@123";
        String token_id = "12345689";
        String mobile_key = "1";

        initVolleyCallback();

        login = new Login(iResult, this);
        login.login_code(user_nm, pass, token_id, mobile_key);

    }
    void initVolleyCallback() {
        iResult = new IResult() {
            @Override
            public void notifySuccess(JSONObject response) {
              //  Log.d(TAG, "Volley requester " + requestType);
                Log.d(TAG, "Volley JSON post" + response);
              //  Toast.makeText(Main2Activity.this, "Sucess -> Main Activity Toast", Toast.LENGTH_SHORT).show();
//                if(response.equals("Success")) {
//                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(intent);
//                }
                startService(new Intent(Main2Activity.this, MyService.class));
            }
            @Override
            public void notifyError(VolleyError error) {
                //Log.d(TAG, "Volley requester " + requestType);
                //Log.d(TAG, "Volley JSON post" + "That didn't work!");
            }
        };
    }
}
