package edu.cnm.deepdive.tallycounter.controller;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.tallycounter.Subtally;
import edu.cnm.deepdive.tallycounter.adapter.SubtalliesAdapter;
import edu.cnm.deepdive.tallycounter.databinding.ActivityMainBinding;
import edu.cnm.deepdive.tallycounter.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  private ActivityMainBinding binding;
  private MainViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupUI();
    setupViewModel();
  }

  private void setupViewModel() {
    viewModel = new ViewModelProvider(this)
        .get(MainViewModel.class);
    viewModel
        .getCounter()
        .observe(this, this::setTallyDisplay);
    viewModel
        .getSubtallies()
        .observe(this, subtallies ->
            binding.subtallies.setAdapter(new SubtalliesAdapter(this, subtallies)));
    viewModel
        .getTotal()
        .observe(this, (total) -> binding.total.setText(String.valueOf(total)));
  }

  private void setupUI() {
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
  }

  public void handleIncrement(View v) {
    viewModel.incrementCounterValue();
  }

  public void captureSubtally(View v) {
    viewModel.captureSubtally();
  }

  private void setTallyDisplay(int counter) {
    binding.tally.setText(String.valueOf(counter));
  }

}