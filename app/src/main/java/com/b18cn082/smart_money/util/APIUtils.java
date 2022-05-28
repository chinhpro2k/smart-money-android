package com.b18cn082.smart_money.util;

import com.b18cn082.smart_money.retrofit.APIServiceInterface;
import com.b18cn082.smart_money.retrofit.RetrofitInstance;

import retrofit2.Retrofit;

public class APIUtils {
    public static APIServiceInterface getApiServiceInterface(){
        Retrofit retrofitInstance = RetrofitInstance.getRetrofitInstance();
        return retrofitInstance.create(APIServiceInterface.class);
    }
}
