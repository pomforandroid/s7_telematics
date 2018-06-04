package com.skankhunt.s7_telematics.carInfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skankhunt.s7_telematics.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarInfoFragment extends Fragment implements CarInfoContract.View {


    public CarInfoFragment() {
        // Required empty public constructor
    }

    public static CarInfoFragment newInstance(){
        return new CarInfoFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_info, container, false);
    }

    @Override
    public void setPresenter(CarInfoContract.Presenter presenter) {

    }
}
