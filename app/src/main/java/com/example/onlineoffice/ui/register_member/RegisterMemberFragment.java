package com.example.onlineoffice.ui.register_member;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineoffice.R;
import com.example.onlineoffice.databinding.FragmentFrontLineBinding;
import com.example.onlineoffice.databinding.FragmentRegisterMemberBinding;
import com.example.onlineoffice.model.register_member.RegMemberResponse;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

public class RegisterMemberFragment extends Fragment {

    private RegisterMemberViewModel mViewModel;

    private FragmentRegisterMemberBinding binding;

    private EditText name, surname, email, pswrd;
    MaterialButton regButton;

    public static RegisterMemberFragment newInstance() {
        return new RegisterMemberFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentRegisterMemberBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        name = root.findViewById(R.id.reg_name);
        surname = root.findViewById(R.id.reg_surname);
        email = root.findViewById(R.id.reg_email);
        pswrd = root.findViewById(R.id.reg_pswrd);
        regButton = root.findViewById(R.id.reg_member_button);

        mViewModel = new ViewModelProvider(this).get(RegisterMemberViewModel.class);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmailValid(email.getText().toString()) && !pswrd.getText().toString().equals("")){
                    mViewModel.regMember(email.getText().toString(), pswrd.getText().toString(), name.getText().toString(), surname.getText().toString()).observe(getViewLifecycleOwner(), new Observer<RegMemberResponse>() {
                        @Override
                        public void onChanged(RegMemberResponse regMemberResponse) {
                          // Snackbar.make(getContext(),"User add", Snackbar.LENGTH_LONG).show();
                            Toast.makeText(getActivity(), "User add", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }

    boolean isEmailValid(CharSequence email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}