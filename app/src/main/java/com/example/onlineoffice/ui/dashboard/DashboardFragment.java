package com.example.onlineoffice.ui.dashboard;

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

import com.example.onlineoffice.model.dashboard.BonusResponse;
import com.example.onlineoffice.R;
import com.example.onlineoffice.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private DashboardViewModel mViewModel;
    private FragmentDashboardBinding binding;

    private EditText personal, group, rank, bonus;

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        personal = root.findViewById(R.id.text_personal_value);
        group = root.findViewById(R.id.text_group_volume);
        rank = root.findViewById(R.id.text_achieved_rank);
        bonus = root.findViewById(R.id.text_bonus_wallet);

        mViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        mViewModel.getBonus().observe(getViewLifecycleOwner(), new Observer<BonusResponse>() {
            @Override
            public void onChanged(BonusResponse bonusResponse) {
                bonus.setText(bonusResponse.payload.get(0).balance);
            }
        });



        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }

}