package lobaev.technopark.hw2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentNumber extends Fragment {

    private int number;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.number = -1;
        if (getArguments() != null) {
            this.number = getArguments().getInt("number", -1);
        }
        if (this.number == -1 && savedInstanceState != null) {
            this.number = savedInstanceState.getInt("number", -1);
        }

        View view = inflater.inflate(R.layout.number, container, false);

        TextView textView = view.findViewById(R.id.number);
        textView.setText(String.valueOf(this.number));
        textView.setTextColor(getResources().getColor(this.number % 2 == 0 ? R.color.red : R.color.blue));
        
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("number", this.number);
        super.onSaveInstanceState(outState);
    }

}
