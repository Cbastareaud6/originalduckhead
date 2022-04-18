package com.cathybastareaud.originalduckhead.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.cathybastareaud.originalduckhead.R;
import com.cathybastareaud.originalduckhead.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  private  ActivityMainBinding binding;
  private NavController navController;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    navController = ((NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_container))
        .getNavController();



  }
}