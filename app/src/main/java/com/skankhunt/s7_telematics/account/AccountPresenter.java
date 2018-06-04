package com.skankhunt.s7_telematics.account;

import android.util.Log;

import com.google.common.base.Optional;
import com.skankhunt.s7_telematics.data.User;
import com.skankhunt.s7_telematics.data.source.AccountRepository;
import com.skankhunt.s7_telematics.data.source.remote.NewEntity;
import com.skankhunt.s7_telematics.util.schedulers.BaseSchedulerProvider;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by wupengcong on 2018/5/29.
 */

public class AccountPresenter implements AccountContract.Presenter {


    private final AccountRepository mAccountRepository;
    private final BaseSchedulerProvider mSchedulerProvider;
    private final AccountContract.View mAccountView;
    private final CompositeDisposable mCompositeDisposable;

    private static final String TAG = "AccountPresenter";

    public AccountPresenter(AccountRepository accountRepository,
                            AccountContract.View accountView,
                            BaseSchedulerProvider schedulerProvider){
        mAccountRepository = checkNotNull(accountRepository, "tasksRepository cannot be null");
        mAccountView = checkNotNull(accountView, "tasksView cannot be null!");
        mSchedulerProvider = checkNotNull(schedulerProvider, "schedulerProvider cannot be null");

        mCompositeDisposable = new CompositeDisposable();

        //跟view设置presenter，让view可以调用presenter的方法
        mAccountView.setPresenter(this);


    }


    @Override
    public void subscribe() {
        loadLoginState();
        getNews();
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void loadLoginState() {

        mCompositeDisposable.clear();
        mAccountRepository.getUser("skankhunt")
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .toObservable()
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.i(TAG,"dofinnally");
                    }
                })
                .subscribe(new Observer<Optional<User>>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Optional<User> userOptional) {
                        if(userOptional!=null){
                            User user = userOptional.orNull();
                            if(user!=null){
                                Log.i(TAG,"user not null"+user.toString());
                                mAccountView.showLoginedUser();
                            }else{
                                Log.i(TAG,"user null");
                                mAccountView.showUnLoginUser();
                            }
                        }else{
                            Log.i(TAG,"userOptional null");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });




    }

    @Override
    public void login(User user) {
        //登录并保存
        mAccountRepository.saveUser(user);
        Log.i(TAG,"保存user成功");

    }

    @Override
    public void logout() {
        //退出登录，删除user表数据
        mAccountRepository.deleteAllUser();
    }

    @Override
    public void getNews() {
        mAccountRepository.getNews("Android",10,1)
                .toObservable()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<NewEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(NewEntity newEntity) {
                        Log.i(TAG,newEntity.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
