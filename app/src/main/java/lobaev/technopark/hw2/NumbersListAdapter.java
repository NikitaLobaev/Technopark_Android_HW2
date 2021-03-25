package lobaev.technopark.hw2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class NumbersListAdapter extends RecyclerView.Adapter<NumbersListViewHolder> {

    public static final int defaultNumbersCount = 100;

    private final Fragment fragment;
    private int numbersCount;

    NumbersListAdapter(Fragment fragment) {
        this(fragment, NumbersListAdapter.defaultNumbersCount);
    }

    NumbersListAdapter(Fragment fragment, int numbersCount) {
        super();
        this.fragment = fragment;
        this.numbersCount = numbersCount;
    }

    @NonNull
    @Override
    public NumbersListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.numbers_list_number,
                parent, false);
        return new NumbersListViewHolder(this.fragment, view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumbersListViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return this.numbersCount;
    }

    public void addNumber() {
        this.numbersCount++;
        notifyItemRangeInserted(this.numbersCount, 1); //notifyDataSetChanged();?
    }

}
