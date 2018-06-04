package com.skankhunt.s7_telematics.packageManage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skankhunt.s7_telematics.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PackageManageFragment extends Fragment implements PackageManageContract.View{


    public PackageManageFragment() {
        // Required empty public constructor
    }

    public static PackageManageFragment newInstance(){
        return new PackageManageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_package_manage, container, false);
    }

    @Override
    public void setPresenter(PackageManageContract.Presenter presenter) {

    }
}
