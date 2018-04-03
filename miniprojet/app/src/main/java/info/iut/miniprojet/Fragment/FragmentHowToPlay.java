package info.iut.miniprojet.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.iut.miniprojet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHowToPlay extends Fragment {


    public FragmentHowToPlay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_how_to_play, container, false);
    }

}
