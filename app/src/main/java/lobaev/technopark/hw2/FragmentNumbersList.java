package lobaev.technopark.hw2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentNumbersList extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView = null;
    private NumbersListAdapter numbersListAdapter = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.numbers_list, container, false);

        this.recyclerView = view.findViewById(R.id.recycler);
        /*this.recyclerView.setLayoutManager(new GridLayoutManager(inflater.getContext(),
                getResources().getInteger(R.integer.recycler_span_count)));*/

        if (this.numbersListAdapter == null) {
            if (savedInstanceState != null) {
                int numbersCount = savedInstanceState.getInt("numbersCount", -1);
                if (numbersCount != -1) {
                    this.numbersListAdapter = new NumbersListAdapter(this, numbersCount);
                }
            }
            if (this.numbersListAdapter == null) {
                this.numbersListAdapter = new NumbersListAdapter(this);
            }
        }

        this.recyclerView.setAdapter(this.numbersListAdapter);

        Button buttonAdd = view.findViewById(R.id.add);
        buttonAdd.setOnClickListener(this);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        if (this.numbersListAdapter != null) {
            outState.putInt("numbersCount", this.numbersListAdapter.getItemCount());
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add) {
            this.numbersListAdapter.addNumber();
            this.recyclerView.scrollToPosition(this.numbersListAdapter.getItemCount() - 1);
        }
    }

}
