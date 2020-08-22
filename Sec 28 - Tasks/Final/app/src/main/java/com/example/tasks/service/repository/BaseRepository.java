package com.example.tasks.service.repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import com.example.tasks.R;
import com.google.gson.Gson;

import okhttp3.ResponseBody;

public class BaseRepository {

    Context mContext;

    public BaseRepository(Context context) {
        this.mContext = context;
    }

    /**
     * Faz a lógica de erro na requisição
     */
    public String handleFailure(ResponseBody response) {
        try {
            return new Gson().fromJson(response.string(), String.class);
        } catch (Exception e) {
            return mContext.getString(R.string.ERROR_UNEXPECTED);
        }
    }

    /**
     * Verifica se existe conexão com internet
     */
    Boolean isConnectionAvailable() {
        boolean result = false;

        ConnectivityManager cm = (ConnectivityManager) this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Network networkCapabilities = cm.getActiveNetwork();
                if (networkCapabilities == null) {
                    return false;
                }

                NetworkCapabilities actNw = cm.getNetworkCapabilities(networkCapabilities);
                if (actNw == null) {
                    return false;
                }

                result = (actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                        || actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR));

            } else {
                NetworkInfo networkInfo = cm.getActiveNetworkInfo();
                if (networkInfo != null) {
                    int type = networkInfo.getType();
                    result = ((type == ConnectivityManager.TYPE_WIFI)
                            || (type == ConnectivityManager.TYPE_MOBILE)
                            || (type == ConnectivityManager.TYPE_ETHERNET));
                }
            }
        }

        return result;
    }

}
