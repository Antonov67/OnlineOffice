package com.example.onlineoffice.controller;

import com.example.onlineoffice.model.dashboard.BonusResponse;
import com.example.onlineoffice.model.downline.DownLineResponse;
import com.example.onlineoffice.model.frontline.FrontLineResponse;
import com.example.onlineoffice.model.profile.Profile;
import com.example.onlineoffice.model.profile.Pswrd;
import com.example.onlineoffice.model.profile.PswrdResponse;
import com.example.onlineoffice.model.profile.TokenRequest;
import com.example.onlineoffice.model.profile.TokenResponse;
import com.example.onlineoffice.model.register_member.RegMemberBody;
import com.example.onlineoffice.model.register_member.RegMemberResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

     @POST("/api3/auth/login")
     Call<TokenResponse> getToken(@Body TokenRequest tokenRequest);

     @GET ("/api3/account/current")
     Call<Profile> getProfile(@Header("Authorization") String token);

     @POST("/api3/account/{id}/set-password")
     Call<PswrdResponse> changePassword(@Header("Authorization") String token, @Path("id") String id, @Body Pswrd pswrd);

     @GET("/api3/account/{id}/wallet")
     Call<BonusResponse> getBonus(@Header("Authorization") String token, @Path("id") int id);

     @GET("/api3/account/{id}/frontline")
     Call<FrontLineResponse> getFrontLine(@Header("Authorization") String token, @Path("id") int id, @Query("limit") int limit, @Query("page") int page);

     @POST("/api3/account/create")
     Call<RegMemberResponse> regMember(@Header("Authorization") String token, @Body RegMemberBody body);

     @GET("/api3/v2/account/{id}/downline")
Call<DownLineResponse> getDownLine(@Header("Authorization") String token, @Path("id") int id, @Query("limit") int limit, @Query("page") int page);
}
