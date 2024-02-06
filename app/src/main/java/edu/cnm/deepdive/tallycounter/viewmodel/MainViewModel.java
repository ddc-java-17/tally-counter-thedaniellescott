package edu.cnm.deepdive.tallycounter.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.tallycounter.Subtally;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.functions.Function1;

public class MainViewModel extends ViewModel {

  private final MutableLiveData<Integer> counter;
  private final MutableLiveData<List<Subtally>> subtallies;
  private final LiveData<Integer> total;

  public MainViewModel() {
    counter = new MutableLiveData<>(0);
    subtallies = new MutableLiveData<>(new LinkedList<>());
    total = Transformations.map(subtallies, subtallies ->
        subtallies
            .stream()
            .mapToInt(Subtally::value)
            .sum());
  }

  public LiveData<Integer> getCounter() {
    return counter;
  }

  public LiveData<List<Subtally>> getSubtallies() {
    return subtallies;
  }

  public LiveData<Integer> getTotal() {
    return total;
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
