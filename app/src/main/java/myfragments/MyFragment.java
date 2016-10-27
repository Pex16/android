package myfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gcioffi.helloworld.R;

/**
 * Created by gcioffi on 04/10/2016.
 */

public class MyFragment extends Fragment {

    public MyFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_primary, container, false);
        return rootView;
    }

}
