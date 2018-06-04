package com.skankhunt.s7_telematics;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.skankhunt.s7_telematics.account.AccountFragment;
import com.skankhunt.s7_telematics.account.AccountPresenter;
import com.skankhunt.s7_telematics.authority.AuthorityFragment;
import com.skankhunt.s7_telematics.base.Injection;
import com.skankhunt.s7_telematics.carInfo.CarInfoFragment;
import com.skankhunt.s7_telematics.flow.FLowFragment;
import com.skankhunt.s7_telematics.packageManage.PackageManageFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> fragments;
    private int prePos = -1;
    private AccountPresenter accountPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            //第一次进来，初始化fragment列表
            buildfragmentList();
        }else{
            //内存回收后，重新进来
            //可根据tag找回
            AccountFragment accountFragment = (AccountFragment) getSupportFragmentManager().findFragmentByTag(AccountFragment.class.getName());
            AuthorityFragment authorityFragment = (AuthorityFragment) getSupportFragmentManager().findFragmentByTag(AuthorityFragment.class.getName());
            CarInfoFragment carInfoFragment = (CarInfoFragment) getSupportFragmentManager().findFragmentByTag(CarInfoFragment.class.getName());
            FLowFragment fLowFragment = (FLowFragment) getSupportFragmentManager().findFragmentByTag(FLowFragment.class.getName());
            PackageManageFragment packageManageFragment = (PackageManageFragment) getSupportFragmentManager().findFragmentByTag(PackageManageFragment.class.getName());
            fragments = new ArrayList<>();
            fragments.add(accountFragment);
            fragments.add(authorityFragment);
            fragments.add(carInfoFragment);
            fragments.add(fLowFragment);
            fragments.add(packageManageFragment);
        }

        accountPresenter = new AccountPresenter(Injection.provideTasksRepository(getApplicationContext()),
                (AccountFragment)fragments.get(0), Injection.provideSchedulerProvider());

        initView();
    }

    private void buildfragmentList() {
        fragments = new ArrayList<>();
        //账户信息
        AccountFragment accountFragment = AccountFragment.newInstance();
        fragments.add(accountFragment);

        AuthorityFragment authorityFragment = AuthorityFragment.newInstance();
        fragments.add(authorityFragment);

        CarInfoFragment carInfoFragment = CarInfoFragment.newInstance();
        fragments.add(carInfoFragment);

        FLowFragment fLowFragment = FLowFragment.newInstance();
        fragments.add(fLowFragment);

        PackageManageFragment packageManageFragment = PackageManageFragment.newInstance();
        fragments.add(packageManageFragment);


    }

    private void initView(){
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio_group_button);
        RadioButton radioButton = (RadioButton) findViewById(R.id.radio_button_account);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_button_account:
                        //账户信息
                        Toast.makeText(MainActivity.this,"账户信息",Toast.LENGTH_LONG).show();
                        switchFragment(0);
                        break;

                    case R.id.radio_button_authority:
                        //个人权限
                        Toast.makeText(MainActivity.this,"个人权限",Toast.LENGTH_LONG).show();
                        switchFragment(1);
                        break;
                    case R.id.radio_button_carimg:
                        //车辆信息
                        Toast.makeText(MainActivity.this,"车辆信息",Toast.LENGTH_LONG).show();
                        switchFragment(2);
                        break;
                    case R.id.radio_button_flow:
                        //流量管理
                        Toast.makeText(MainActivity.this,"流量管理",Toast.LENGTH_LONG).show();
                        switchFragment(3);
                        break;
                    case R.id.radio_button_package:
                        //套餐管理
                        Toast.makeText(MainActivity.this,"套餐管理",Toast.LENGTH_LONG).show();
                        switchFragment(4);
                        break;

                }
            }
        });
        //保证第一次回执行回调
        radioButton.setChecked(true);
    }

    private void switchFragment(int pos) {
        //Toast.makeText(this,prePos+" -> "+pos,Toast.LENGTH_LONG).show();
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        if(prePos==-1){
            Fragment now = fragments.get(pos);
            if (!now.isAdded()) {
                transaction
                        .add(R.id.fl_container, now,now.getClass().getName() )
                        .commit();
            } else {
                transaction
                        .show(now)
                        .commit();
            }
        }else{
            Fragment from = fragments.get(prePos);
            Fragment to = fragments.get(pos);
            if (!to.isAdded()) {
                transaction.hide(from)
                        .add(R.id.fl_container, to, to.getClass().getName())
                        .commit();
            } else {
                transaction.hide(from)
                        .show(to)
                        .commit();
            }
        }


        prePos = pos;

    }



}
