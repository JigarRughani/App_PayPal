package com.example.jigar.app_paypal.Interfaces;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by Jigar on 1/9/2019.
 */

public interface IResult {

        public void notifySuccess(JSONObject response);
        public void notifyError(VolleyError error);

}
