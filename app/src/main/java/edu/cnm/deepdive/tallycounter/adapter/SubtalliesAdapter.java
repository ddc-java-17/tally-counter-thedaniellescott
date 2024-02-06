package edu.cnm.deepdive.tallycounter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import edu.cnm.deepdive.tallycounter.R;
import edu.cnm.deepdive.tallycounter.Subtally;
import edu.cnm.deepdive.tallycounter.databinding.ItemSubtallyBinding;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class SubtalliesAdapter extends ArrayAdapter<Subtally> {

  public static final int MILLISECONDS_PER_SECOND = 1000;
  private final LayoutInflater inflater;
  private final DateFormat formatter;

  public SubtalliesAdapter(@NonNull Context context, @NonNull List<Subtally> objects) {
    super(context, R.layout.item_subtally, objects);
    inflater = LayoutInflater.from(context);
    formatter = android.text.format.DateFormat.getMediumDateFormat(context);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    ItemSubtallyBinding binding = (convertView ==null)
        ? ItemSubtallyBinding.inflate(inflater, parent, false)
        : ItemSubtallyBinding.bind(convertView);
    Subtally subtally = getItem(position);
    binding.value.setText(String.valueOf(subtally.value()));
    binding.timestamp.setText(formatter.format(
        new Date(subtally.timestamp().getEpochSecond() * MILLISECONDS_PER_SECOND)));
    return binding.getRoot();
  }

}
