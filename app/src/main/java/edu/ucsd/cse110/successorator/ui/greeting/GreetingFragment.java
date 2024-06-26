package edu.ucsd.cse110.successorator.ui.greeting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.ucsd.cse110.successorator.MainViewModel;
import edu.ucsd.cse110.successorator.databinding.FragmentGreetingBinding;

public class GreetingFragment extends Fragment {
    private MainViewModel activityModel; // NEW FIELD
    private FragmentGreetingBinding view;

    public GreetingFragment() {
        // Required empty public constructor
    }

    public static GreetingFragment newInstance() {
        GreetingFragment fragment = new GreetingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the Model
        var modelOwner = requireActivity();
        var modelFactory = ViewModelProvider.Factory.from(MainViewModel.initializer);
        var modelProvider = new ViewModelProvider(modelOwner, modelFactory);
        this.activityModel = modelProvider.get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Initialize the View
        view = FragmentGreetingBinding.inflate(inflater, container, false);

        return view.getRoot();
    }
}
