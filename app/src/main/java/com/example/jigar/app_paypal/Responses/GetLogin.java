package com.example.jigar.app_paypal.Responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jigar on 1/4/2019.
 */

public class GetLogin {
    @SerializedName("message")
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
