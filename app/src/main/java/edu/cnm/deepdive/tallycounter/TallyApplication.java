package edu.cnm.deepdive.tallycounter;

import android.app.Application;
import android.util.Log;

public class TallyApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    // TODO: 2/5/2024 App=level initialization goes here.
    Log.d(getClass().getSimpleName(), "Tally Application::onCreate");
  }

}
