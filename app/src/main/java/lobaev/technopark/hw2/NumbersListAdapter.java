package lobaev.technopark.hw2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumbersListAdapter extends RecyclerView.Adapter<NumbersListViewHolder> {

    public static final int defaultNumbersCount = 100;

    private final View.OnClickListener onClickListener;
    private int numbersCount;

    NumbersListAdapter(View.OnClickListener onClickListener) {
        this(onClickListener, NumbersListAdapter.defaultNumbersCount);
    }

    NumbersListAdapter(View.OnClickListener onClickListener, int numbersCount) {
        super();
        this.onClickListener = onClickListener;
        this.numbersCount = numbersCount;
    }

    @NonNull
    @Override
    public NumbersListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.numbers_list_number,
                parent, false);
        return new NumbersListViewHolder(this.onClickListener, view);
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
        notifyItemRangeInserted(this.numbersCount, 1);
    }

}
