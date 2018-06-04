package com.skankhunt.s7_telematics.flow;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skankhunt.s7_telematics.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FLowFragment extends Fragment implements FlowContract.View {


    public FLowFragment() {
        // Required empty public constructor
    }

    public static FLowFragment newInstance(){
        return new FLowFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flow, container, false);
    }

    @Override
    public void setPresenter(FlowContract.Presenter presenter) {

    }
}
