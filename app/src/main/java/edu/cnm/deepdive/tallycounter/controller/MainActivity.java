package edu.cnm.deepdive.tallycounter.controller;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.tallycounter.R;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  private TextView tally;
  private int counter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, "MainActivity::onCreate");
    setContentView(R.layout.activity_main);
    tally = findViewById(R.id.tally);
    tally.setText("0");
    Button increment = findViewById(R.id.increment);
    increment.setOnClickListener(new IncrementListener());
  }

  private class IncrementListener implements OnClickListener {

    @Override
    public void onClick(View v) {
      counter++;
      tally.setText(String.valueOf(counter));

    }
  }

}