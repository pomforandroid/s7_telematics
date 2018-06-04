package com.skankhunt.s7_telematics.account;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;

import com.skankhunt.s7_telematics.R;
import com.skankhunt.s7_telematics.data.User;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements AccountContract.View, View.OnClickListener {


    private ViewStub view_login;
    private ViewStub view_info;
    private View inflate_login;
    private View inflate_info_;
    private boolean isViewInfoInflated;
    private AccountContract.Presenter mPresenter;
    private boolean isViewLoginInflated;

    public AccountFragment() {
        // Required empty public constructor
    }

    public static AccountFragment newInstance(){
        return  new AccountFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        view_login = (ViewStub) view.findViewById(R.id.view_login);
        view_info = (ViewStub) view.findViewById(R.id.view_info);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(AccountContract.Presenter presenter) {

        mPresenter = checkNotNull(presenter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_login:
                User skankhunt = new User("skankhunt", "333", "333", "18998533005");
                mPresenter.login(skankhunt);

                //判断是否已经infalte了，不能重复infalte，因为infalte一次后view_info就会清空
                if(!isViewInfoInflated){
                    inflate_info_ = view_info.inflate();
                    isViewInfoInflated = true;
                }else{
                    inflate_info_.setVisibility(View.VISIBLE);
                }

                inflate_login.setVisibility(View.GONE);
                inflate_info_.findViewById(R.id.bt_logout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        inflate_info_.setVisibility(View.GONE);
                        inflate_login.setVisibility(View.VISIBLE);
                    }
                });
                break;

            case R.id.bt_logout:

                mPresenter.logout();
                break;
        }
    }


    @Override
    public void showLoginedUser() {
        //在数据库中找到user的数据，已登录，显示已登录的界面
        if(!isViewInfoInflated){
            inflate_info_ = view_info.inflate();
            isViewInfoInflated = true;
        }else{
            inflate_info_.setVisibility(View.VISIBLE);
        }

        if(inflate_login!=null&&inflate_login.getVisibility()==View.VISIBLE){
            inflate_login.setVisibility(View.GONE);
        }
        inflate_info_.findViewById(R.id.bt_logout).setOnClickListener(this);

    }

    @Override
    public void showUnLoginUser() {
        //在数据库找不到user的数据，未登录，显示未登录的界面
        if(!isViewLoginInflated){
            inflate_login = view_login.inflate();
            isViewLoginInflated = true;
        }else{
            inflate_login.setVisibility(View.VISIBLE);
        }

        if(inflate_info_ !=null && inflate_info_.getVisibility()==View.VISIBLE){
            inflate_info_.setVisibility(View.GONE);
        }

        Button btLogin = (Button) inflate_login.findViewById(R.id.bt_login);
        //登录和退出登录的交互
        btLogin.setOnClickListener(this);
    }
}
