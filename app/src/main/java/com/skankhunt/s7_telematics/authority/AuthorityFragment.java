package com.skankhunt.s7_telematics.authority;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skankhunt.s7_telematics.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuthorityFragment extends Fragment implements AuthorityContract.View {


    public AuthorityFragment() {
        // Required empty public constructor
    }

    public static AuthorityFragment newInstance(){
        return new AuthorityFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authority, container, false);
    }

    @Override
    public void setPresenter(AuthorityContract.Presenter presenter) {

    }
}
