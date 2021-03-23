package lobaev.technopark.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (savedInstanceState == null) {
            FragmentNumbersList fragmentNumbersList = new FragmentNumbersList();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main, fragmentNumbersList)
                    .addToBackStack(null)
                    .commit();
        }
    }

}