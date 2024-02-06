package edu.cnm.deepdive.tallycounter.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.tallycounter.Subtally;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class MainViewModel extends ViewModel {

  private final MutableLiveData<Integer> counter;
  private final MutableLiveData<List<Subtally>> subtallies;

  public MainViewModel() {
    counter = new MutableLiveData<>(0);
    subtallies = new MutableLiveData<>(new LinkedList<>());
  }

  public LiveData<Integer> getCounter() {
    return counter;
  }

  public LiveData<List<Subtally>> getSubtallies() {
    return subtallies;
  }

  public void resetCounterValue() {
    counter.setValue(0);
  }

  public void incrementCounterValue() {
    counter.setValue(counter.getValue() + 1);
  }

  public void captureSubtally() {
    //noinspection DataFlowIssue
    Subtally subtally = new Subtally(Instant.now(), counter.getValue());
    subtallies.getValue().add(subtally);
    subtallies.setValue(subtallies.getValue());
    resetCounterValue();
  }

}
