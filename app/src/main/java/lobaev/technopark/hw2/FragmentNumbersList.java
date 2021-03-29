package lobaev.technopark.hw2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class FragmentNumbersList extends Fragment implements View.OnClickListener {

    private static final String bundleKeyNumbersCount = "numbersCount";
    private static final String bundleKeyNumber = "number";

    private RecyclerView recyclerView = null;
    private NumbersListAdapter numbersListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.numbers_list, container, false);

        this.recyclerView = view.findViewById(R.id.recycler);

        this.numbersListAdapter = null;
        if (savedInstanceState != null) {
            int numbersCount = savedInstanceState.getInt(FragmentNumbersList.bundleKeyNumbersCount, -1);
            if (numbersCount != -1) {
                this.numbersListAdapter = new NumbersListAdapter(this, numbersCount);
            }
        }
        if (this.numbersListAdapter == null) {
            this.numbersListAdapter = new NumbersListAdapter(this);
        }

        this.recyclerView.setAdapter(this.numbersListAdapter);

        Button buttonAdd = view.findViewById(R.id.add);
        buttonAdd.setOnClickListener(this);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        if (this.numbersListAdapter != null) {
            outState.putInt(FragmentNumbersList.bundleKeyNumbersCount, this.numbersListAdapter.getItemCount());
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add) {
            this.numbersListAdapter.addNumber();
            this.recyclerView.scrollToPosition(this.numbersListAdapter.getItemCount() - 1);
        } else {
            TextView textView = (TextView) v;
            int number = Integer.parseInt(textView.getText().toString());

            FragmentNumber fragmentNumber = new FragmentNumber();
            Bundle fragmentNumberBundle = new Bundle();
            fragmentNumberBundle.putInt(FragmentNumbersList.bundleKeyNumber, number);
            fragmentNumber.setArguments(fragmentNumberBundle);

            Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main, fragmentNumber)
                    .addToBackStack(null)
                    .commit();
        }
    }

}
