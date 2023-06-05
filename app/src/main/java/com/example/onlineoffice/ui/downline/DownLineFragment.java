package com.example.onlineoffice.ui.downline;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlineoffice.R;
import com.example.onlineoffice.controller.DownLineAdapter;
import com.example.onlineoffice.controller.FrontLineAdapter;
import com.example.onlineoffice.databinding.FragmentDownLineBinding;
import com.example.onlineoffice.databinding.FragmentFrontLineBinding;
import com.example.onlineoffice.model.downline.DownLineResponse;

public class DownLineFragment extends Fragment {

    private DownLineViewModel mViewModel;
    private FragmentDownLineBinding binding;
    RecyclerView recycler;
    DownLineAdapter adapter;


    public static DownLineFragment newInstance() {
        return new DownLineFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentDownLineBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recycler = root.findViewById(R.id.down_recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(llm);

        mViewModel = new ViewModelProvider(this).get(DownLineViewModel.class);
        mViewModel.getDownLine().observe(getViewLifecycleOwner(), new Observer<DownLineResponse>() {
            @Override
            public void onChanged(DownLineResponse downLineResponse) {
                adapter = new DownLineAdapter(getContext(), downLineResponse);
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