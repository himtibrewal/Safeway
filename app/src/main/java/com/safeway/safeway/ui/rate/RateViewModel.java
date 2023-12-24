package com.safeway.safeway.ui.rate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RateViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RateViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Rate fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}