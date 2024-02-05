package edu.cnm.deepdive.tallycounter.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

  private final MutableLiveData<Integer> counter;

  public MainViewModel() {
    counter = new MutableLiveData<>(0);
  }

  public LiveData<Integer> getCounter() {
    return counter;
  }

  public void setCounterValue(int value) {
    counter.setValue(value);
  }

  public void incrementCounterValue() {
    counter.setValue(counter.getValue() + 1);
  }
}
