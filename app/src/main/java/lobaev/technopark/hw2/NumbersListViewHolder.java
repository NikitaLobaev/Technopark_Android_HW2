package lobaev.technopark.hw2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumbersListViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;
    private int number;

    public NumbersListViewHolder(FragmentNumbersList fragmentNumbersList, @NonNull View itemView) {
        super(itemView);
        this.textView = itemView.findViewById(R.id.numbers_list_number);
        this.textView.setOnClickListener(v -> fragmentNumbersList.showFragmentNumber(this.number));
    }

    public void bind(int position) {
        this.number = position + 1;
        this.textView.setText(String.valueOf(this.number));
        this.textView.setTextColor(this.textView.getContext().getResources().getColor(this.number % 2 == 0 ? R.color.red : R.color.blue));
    }

}
