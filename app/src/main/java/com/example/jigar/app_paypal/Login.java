package com.example.jigar.app_paypal;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.jigar.app_paypal.Interfaces.IResult;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jigar on 1/9/2019.
 */

public class Login {
    IResult mResultCallback = null;
    Context mContext;
    ProgressDialog progressDialog;

    Login(IResult resultCallback, Context context) {
        mResultCallback = resultCallback;
        mContext = context;
    }

    public void login_code(String user_nm, String pass, String conv_refreshedToken, String mob_key) {
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        //    String user_nm = ed_unm.getText().toString();
        //    String pass = ed_pass.getText().toString();
        String webservice_url = "http://35.162.89.140:82/GotHireServices.svc/GetbyEmailPassword/";
        String url_Login = webservice_url + user_nm + "/" + pass + "/" + conv_refreshedToken + "/" + mob_key;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url_Login, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("Result", response.toString());
                String result = response.toString();

                try {
                    // JSONArray resultJsonArr = response.getJSONArray("GetbyEmailPasswordResult");
                    String result_status = null;
                    result_status = response.getString("GetbyEmailPasswordResult");


                    if (mResultCallback != null) {
                        progressDialog.dismiss();
                        mResultCallback.notifySuccess(response);
                        Toast.makeText(mContext, "Response"+response, Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                //          Toast.makeText(Login.this, "Please check your username and password", Toast.LENGTH_LONG).show();
                //ed_unm.requestFocus();
                if (mResultCallback != null)
                    progressDialog.dismiss();
                    mResultCallback.notifyError(volleyError);
                    Toast.makeText(mContext, "Error"+volleyError, Toast.LENGTH_SHORT).show();
            }
//                }
        });
        RequestQueue rQueue = Volley.newRequestQueue(mContext);
        rQueue.add(jsonObjReq);
    }

    //progressDialog.dismiss();

}
