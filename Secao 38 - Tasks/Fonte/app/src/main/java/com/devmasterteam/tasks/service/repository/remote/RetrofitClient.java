package com.devmasterteam.tasks.service.repository.remote;

import androidx.annotation.NonNull;

import com.devmasterteam.tasks.service.constants.TaskConstants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static String tokenKey = "";
    private static String personKey = "";

    private RetrofitClient() {
    }

    private static Retrofit getRetrofitInstance() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request req = chain.request()
                        .newBuilder()
                        .addHeader(TaskConstants.SHARED.TOKEN_KEY, tokenKey)
                        .addHeader(TaskConstants.SHARED.PERSON_KEY, personKey)
                        .build();
                return chain.proceed(req);
            }
        });

        synchronized (RetrofitClient.class) {
            if (retrofit == null) {
                retrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl("https://www.devmasterteam.com/CursoAndroidAPI/")
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        }
        return retrofit;
    }

    public static <S> S createService(Class<S> sClass) {
        return getRetrofitInstance().create(sClass);
    }

    public static void saveHeaders(String token, String person) {
        tokenKey = token;
        personKey = person;
    }

}
