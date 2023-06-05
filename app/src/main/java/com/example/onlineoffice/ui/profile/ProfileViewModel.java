package com.example.onlineoffice.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlineoffice.controller.API;
import com.example.onlineoffice.model.profile.Profile;
import com.example.onlineoffice.model.profile.Pswrd;
import com.example.onlineoffice.model.profile.PswrdResponse;
import com.example.onlineoffice.controller.RetrofitConnection;
import com.example.onlineoffice.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<Profile> profile;
    private final MutableLiveData<PswrdResponse> pswrdResponse;


    public ProfileViewModel() {
        profile = new MutableLiveData<>();
        pswrdResponse = new MutableLiveData<>();
        API api = RetrofitConnection.getInstance().getRetrofit().create(API.class);
        Call<Profile> call = api.getProfile("Bearer " + Utils.token);
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                Utils.id = response.body().payload.id;
                profile.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });


    }

    public LiveData<Profile> getProfile(){
        return profile;
    }

    public LiveData<PswrdResponse> getPswrdResponse(Pswrd pswrd){
        //смена пароля
        API api = RetrofitConnection.getInstance().getRetrofit().create(API.class);
        Call<PswrdResponse> call2 = api.changePassword("Bearer " + Utils.token,Utils.id, pswrd);
        call2.enqueue(new Callback<PswrdResponse>() {
            @Override
            public void onResponse(Call<PswrdResponse> call, Response<PswrdResponse> response) {
                pswrdResponse.postValue(response.body());
            }

            @Override
            public void onFailure(Call<PswrdResponse> call, Throwable t) {

            }
        });
        return pswrdResponse;
    }
}