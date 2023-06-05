package com.example.onlineoffice.ui.downline;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlineoffice.controller.API;
import com.example.onlineoffice.controller.RetrofitConnection;
import com.example.onlineoffice.model.downline.DownLineResponse;
import com.example.onlineoffice.utils.Utils;

import java.lang.invoke.MutableCallSite;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownLineViewModel extends ViewModel {
    private final MutableLiveData<DownLineResponse> downLineResponse;

    public DownLineViewModel() {
        downLineResponse = new MutableLiveData<>();
    }

    public LiveData<DownLineResponse> getDownLine(){
        API api = RetrofitConnection.getInstance().getRetrofit().create(API.class);
        Call<DownLineResponse> call = api.getDownLine("Bearer " + Utils.token, Integer.parseInt(Utils.id), 10, 0);
        call.enqueue(new Callback<DownLineResponse>() {
            @Override
            public void onResponse(Call<DownLineResponse> call, Response<DownLineResponse> response) {
                if (response.isSuccessful()){
                    downLineResponse.postValue(response.body());
                }

            }
            @Override
            public void onFailure(Call<DownLineResponse> call, Throwable t) {

            }
        });
        return downLineResponse;
    }
}