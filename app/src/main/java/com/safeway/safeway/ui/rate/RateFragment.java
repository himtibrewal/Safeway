package com.safeway.safeway.ui.rate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.safeway.safeway.databinding.FragmentRateBinding;

public class RateFragment extends Fragment {

    private FragmentRateBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RateViewModel rateViewModel =
                new ViewModelProvider(this).get(RateViewModel.class);

        binding = FragmentRateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textRate;
        rateViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}