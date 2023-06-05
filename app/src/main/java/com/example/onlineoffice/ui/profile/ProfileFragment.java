package com.example.onlineoffice.ui.profile;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineoffice.model.profile.Profile;
import com.example.onlineoffice.model.profile.ProfileIn;
import com.example.onlineoffice.model.profile.Pswrd;
import com.example.onlineoffice.model.profile.PswrdResponse;
import com.example.onlineoffice.R;
import com.example.onlineoffice.model.profile.Raw;
import com.example.onlineoffice.databinding.FragmentProfileBinding;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;
    private FragmentProfileBinding binding;

    TextView id;
    EditText name, surname, birthday, country, email, pswrd;
    MaterialButton editBtn, setBtn;
    ImageView image;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        id = root.findViewById(R.id.profile_id);
        name = root.findViewById(R.id.profile_name);
        surname = root.findViewById(R.id.profile_surname);
        birthday = root.findViewById(R.id.profile_birthday);
        country = root.findViewById(R.id.profile_country);
        email = root.findViewById(R.id.profile_email);
        pswrd = root.findViewById(R.id.profile_pswrd);
        image = root.findViewById(R.id.profile_photo);

        editBtn = root.findViewById(R.id.profile_button_change);
        setBtn = root.findViewById(R.id.profile_button_set);


        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        mViewModel.getProfile().observe(getViewLifecycleOwner(), new Observer<Profile>() {
            @Override
            public void onChanged(Profile profile) {
                setValues(profile);
            }
        });

        //обработчик нажатия на кнопку редактирования профиля
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pswrd.setEnabled(true);
            }
        });

        // обработчик нажатия для сохранения пароля
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pswrd.getText().toString().length() != 0){
                    mViewModel.getPswrdResponse(new Pswrd(pswrd.getText().toString())).observe(getViewLifecycleOwner(), new Observer<PswrdResponse>() {
                        @Override
                        public void onChanged(PswrdResponse pswrdResponse) {
                            Toast.makeText(getContext(), "Пароль успешно изменен", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                pswrd.setEnabled(false);
            }
        });


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }



    public void setValues(Profile profile){
        id.setText(profile.payload.id);
        name.setText(profile.payload.users.get(0).firstName);
        surname.setText(profile.payload.users.get(0).lastName);
        email.setText(profile.payload.users.get(0).email);
        for (ProfileIn profileIn : profile.payload.profile) {
            if (profileIn.alias.equals("country_id")){
                country.setText(profileIn.value.presentable);
            }
            if (profileIn.alias.equals("birth_date")){
                birthday.setText(profileIn.value.presentable);
            }
            if (profileIn.alias.equals("avatar_id")){

                Gson gson = new Gson();
                Raw raw = gson.fromJson(profileIn.value.presentable,Raw.class);
                System.out.println(raw.imageUrl);
                Picasso.get().load(raw.imageUrl).into(image);
            }
        }
    }

}