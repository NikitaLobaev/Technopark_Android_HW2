package lobaev.technopark.hw2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class NumbersListViewHolder extends RecyclerView.ViewHolder {

    private final Fragment fragment;
    private final AppCompatActivity appCompatActivity;
    private final TextView textView;

    public NumbersListViewHolder(Fragment fragment, @NonNull View itemView) {
        super(itemView);
        this.fragment = fragment;
        this.appCompatActivity = (AppCompatActivity) this.fragment.getActivity();
        this.textView = itemView.findViewById(R.id.numbers_list_number);
        this.textView.setOnClickListener(v -> {
            if (this.appCompatActivity == null) {
                Log.i("LN", "this.appCompatActivity == null :(");
                return;
            }

            TextView textView = (TextView) v;

            FragmentNumber fragmentNumber = new FragmentNumber();
            Bundle fragmentNumberBundle = new Bundle();
            fragmentNumberBundle.putInt("number", Integer.parseInt(textView.getText().toString()));
            fragmentNumber.setArguments(fragmentNumberBundle);

            this.appCompatActivity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main, fragmentNumber)
                    .addToBackStack(null)
                    .commit();
        });
    }

    public void bind(int number) {
        this.textView.setText(String.valueOf(number + 1));
        this.textView.setTextColor(this.fragment.getResources().getColor(!(number % 2 == 0) ? R.color.red : R.color.blue));
    }

}
