package com.skankhunt.s7_telematics.account;

import com.skankhunt.s7_telematics.base.BasePresenter;
import com.skankhunt.s7_telematics.base.BaseView;
import com.skankhunt.s7_telematics.data.User;

/**
 * Created by wupengcong on 2018/5/29.
 */

public class AccountContract {

    //view层要实现的功能
    interface View extends BaseView<Presenter>{

        /**
         * 显示已经登录的用户
         */
        void showLoginedUser();

        /**
         * 显示用户未登录的界面
         */
        void showUnLoginUser();

    }

    //view层要实现的功能
    interface Presenter extends BasePresenter{

        /**
         * 获得是否有用户，来判断是否已经登录
         */

        void loadLoginState();

        /**
         * 登录
         * @param user
         */
        void login(User user);

        /**
         * 退出登录
         */
        void logout();

        /**
         *获得新闻列表
         */
        void getNews();

    }
}
