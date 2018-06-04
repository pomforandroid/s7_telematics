package com.skankhunt.s7_telematics.login;

import com.skankhunt.s7_telematics.base.BasePresenter;
import com.skankhunt.s7_telematics.base.BaseView;

/**
 * 值得注意的点是，google将view和presenter放到了一个契约类中了，所以。。。我们可以少建一个文件了。。是的。。我们就是这种偷懒的程序猿。
 */
public class LoginContract {

    interface View extends BaseView<Present> {
        void loginError(String msg);
        void loginSuccess(); String getAccount();
        String getPassword();
    }
    interface Present extends BasePresenter {
        void login();
    }



}
