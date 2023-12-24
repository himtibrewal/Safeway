package com.safeway.safeway.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.safeway.safeway.activity.AddDocActivity;
import com.safeway.safeway.activity.AddVehicleActivity;
import com.safeway.safeway.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button vehicleBtn = binding.btnHomeVehicle;
        final Button docBtn = binding.btnHomeDoc;

        vehicleBtn.setOnClickListener(v -> sendToActivity(AddVehicleActivity.class));
        docBtn.setOnClickListener(v -> sendToActivity(AddDocActivity.class));



//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void sendToActivity(Class<?> classs) {
        Intent intent = new Intent(getActivity(), classs);
        startActivity(intent);
    }
}