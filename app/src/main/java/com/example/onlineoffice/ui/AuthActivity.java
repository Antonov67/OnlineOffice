package com.example.onlineoffice.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineoffice.controller.API;
import com.example.onlineoffice.R;
import com.example.onlineoffice.controller.RetrofitConnection;
import com.example.onlineoffice.model.profile.TokenRequest;
import com.example.onlineoffice.model.profile.TokenResponse;
import com.example.onlineoffice.utils.Utils;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthActivity extends AppCompatActivity {

    MaterialButton signInButton;
    EditText email, pswrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        signInButton = findViewById(R.id.signin_button);
        email = findViewById(R.id.email_field);
        pswrd = findViewById(R.id.pswrd_field);

        API api = RetrofitConnection.getInstance().getRetrofit().create(API.class);


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isEmailValid(email.getText().toString())){
                    Call<TokenResponse> call = api.getToken(new TokenRequest(email.getText().toString(),pswrd.getText().toString(),true));
                    call.enqueue(new Callback<TokenResponse>() {
                        @Override
                        public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                            Utils.token = response.body().payload.accessToken;
                            Utils.email = email.getText().toString();
                            startActivity(new Intent(AuthActivity.this, MainActivity.class));
                        }

                        @Override
                        public void onFailure(Call<TokenResponse> call, Throwable t) {

                        }
                    });
                }else {
                    Toast.makeText(AuthActivity.this, "Почта введена неправильно!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    boolean isEmailValid(CharSequence email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


}