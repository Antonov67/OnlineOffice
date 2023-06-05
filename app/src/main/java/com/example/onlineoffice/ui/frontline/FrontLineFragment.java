package com.example.onlineoffice.ui.frontline;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.onlineoffice.R;
import com.example.onlineoffice.controller.FrontLineAdapter;
import com.example.onlineoffice.databinding.FragmentDashboardBinding;
import com.example.onlineoffice.databinding.FragmentFrontLineBinding;
import com.example.onlineoffice.model.frontline.FrontLineResponse;

public class FrontLineFragment extends Fragment {

    private FrontLineViewModel mViewModel;
    private FragmentFrontLineBinding binding;
    RecyclerView recycler;
    FrontLineAdapter adapter;

    public static FrontLineFragment newInstance() {
        return new FrontLineFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentFrontLineBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mViewModel = new ViewModelProvider(this).get(FrontLineViewModel.class);

       recycler = root.findViewById(R.id.recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(llm);
        mViewModel.getFrontLine().observe(getViewLifecycleOwner(), new Observer<FrontLineResponse>() {
            @Override
            public void onChanged(FrontLineResponse frontLineResponse) {
                adapter = new FrontLineAdapter(getContext(), frontLineResponse);
                recycler.setAdapter(adapter);
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