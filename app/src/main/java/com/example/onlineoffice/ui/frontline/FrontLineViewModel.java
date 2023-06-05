package com.example.onlineoffice.ui.frontline;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlineoffice.controller.API;
import com.example.onlineoffice.controller.RetrofitConnection;
import com.example.onlineoffice.model.frontline.FrontLineResponse;
import com.example.onlineoffice.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FrontLineViewModel extends ViewModel {
    private final MutableLiveData<FrontLineResponse> frontLineResponse;

    public FrontLineViewModel() {
        frontLineResponse = new MutableLiveData<>();
        API api = RetrofitConnection.getInstance().getRetrofit().create(API.class);
        Call<FrontLineResponse> call = api.getFrontLine("Bearer " + Utils.token, Integer.parseInt(Utils.id), 10, 0);
        call.enqueue(new Callback<FrontLineResponse>() {
            @Override
            public void onResponse(Call<FrontLineResponse> call, Response<FrontLineResponse> response) {
                if (response.isSuccessful()){
                    System.out.println(response.body().payload.list.get(0));
                    frontLineResponse.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<FrontLineResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<FrontLineResponse> getFrontLine(){
        return frontLineResponse;
    }
}