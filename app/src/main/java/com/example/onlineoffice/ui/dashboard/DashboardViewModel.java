package com.example.onlineoffice.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlineoffice.controller.API;
import com.example.onlineoffice.model.dashboard.BonusResponse;
import com.example.onlineoffice.controller.RetrofitConnection;
import com.example.onlineoffice.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<BonusResponse> bonusResponse;

    public DashboardViewModel() {
        bonusResponse = new MutableLiveData<>();

        API api = RetrofitConnection.getInstance().getRetrofit().create(API.class);
        Call<BonusResponse> call = api.getBonus("Bearer " + Utils.token, Integer.parseInt(Utils.id));
        call.enqueue(new Callback<BonusResponse>() {
            @Override
            public void onResponse(Call<BonusResponse> call, Response<BonusResponse> response) {
                if (response.body() != null){
                    bonusResponse.postValue(response.body());
//                    System.out.println(response.body().payload.get(0).balance);
//                    System.out.println(response.code() + "");
                }else {
                    System.out.println("bonus get false");
                }

            }

            @Override
            public void onFailure(Call<BonusResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<BonusResponse> getBonus(){
        return bonusResponse;
    }
}