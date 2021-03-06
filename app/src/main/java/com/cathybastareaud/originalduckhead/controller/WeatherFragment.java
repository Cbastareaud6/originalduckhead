package com.cathybastareaud.originalduckhead.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.cathybastareaud.originalduckhead.databinding.FragmentWeatherBinding;

public class WeatherFragment extends Fragment {


  private FragmentWeatherBinding binding;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
      binding = FragmentWeatherBinding.inflate(inflater, container, false);

    return binding.getRoot();
  }
}

