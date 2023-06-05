package com.example.onlineoffice.ui.register_member;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlineoffice.controller.API;
import com.example.onlineoffice.controller.RetrofitConnection;
import com.example.onlineoffice.model.register_member.Profile;
import com.example.onlineoffice.model.register_member.RegMemberBody;
import com.example.onlineoffice.model.register_member.RegMemberResponse;
import com.example.onlineoffice.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterMemberViewModel extends ViewModel {

    public final MutableLiveData<RegMemberResponse> regMemberResponse;

    public RegisterMemberViewModel() {
        regMemberResponse = new MutableLiveData<>();

    }

    public LiveData<RegMemberResponse> regMember(String newEmail, String newPswrd, String firstname, String lastname ){
        API api = RetrofitConnection.getInstance().getRetrofit().create(API.class);
        RegMemberBody regMemberBody = new RegMemberBody(newEmail, Integer.parseInt(Utils.id),newPswrd,new Profile(newEmail, firstname, lastname));
        System.out.println(regMemberBody.toString());
        Call<RegMemberResponse> call = api.regMember("Bearer " + Utils.token, regMemberBody);
        call.enqueue(new Callback<RegMemberResponse>() {
            @Override
            public void onResponse(Call<RegMemberResponse> call, Response<RegMemberResponse> response) {
                if (response.isSuccessful()){
                    regMemberResponse.postValue(response.body());
                    System.out.println(response.body().success);
                }else {
                    System.out.println(response.code());
                }
            }

            @Override
            public void onFailure(Call<RegMemberResponse> call, Throwable t) {

            }
        });

        return regMemberResponse;

    }
}