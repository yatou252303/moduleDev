package com.acmenxd.frame.basis;

import android.support.annotation.CallSuper;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import com.acmenxd.frame.basis.impl.IFrameNet;
import com.acmenxd.frame.basis.impl.IFrameSubscription;
import com.acmenxd.frame.utils.net.IMonitorListener;
import com.acmenxd.frame.utils.net.Monitor;
import com.acmenxd.frame.utils.net.NetStatus;
import com.acmenxd.retrofit.HttpManager;
import com.acmenxd.retrofit.callback.HttpCallback;
import com.acmenxd.retrofit.callback.HttpSubscriber;
import com.acmenxd.retrofit.callback.IHttpProgress;

import retrofit2.Call;
import retrofit2.Response;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author AcmenXD
 * @version v1.0
 * @github https://github.com/AcmenXD
 * @date 2016/12/16 16:01
 * @detail Model基类
 */
public abstract class FrameModel implements IFrameSubscription, IFrameNet {

    protected final String TAG = this.getClass().getSimpleName();


    // 统一持有Subscription
    private CompositeSubscription mSubscription;

    /**
     * 构造器,传入FramePresenter实例
     */
    public FrameModel() {
        // 初始化容器
        mSubscription = getCompositeSubscription();
        // 网络监控注册
       // Monitor.registListener(mNetListener);
    }

    /**
     * mView销毁时回调
     */
    @CallSuper
    public void unSubscribe() {
        // 网络监控反注册
        //Monitor.unRegistListener(mNetListener);
        //解绑 Subscriptions
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }
    //------------------------------------子类可重写的函数

    /**
     * 网络状态变换调用
     */
    @CallSuper
    protected void onNetStatusChange(@NonNull NetStatus pNetStatus) {
    }
    //------------------------------------子类可使用的工具函数 -> 私有

    /**
     * 统一处理因异步导致的 Activity|Fragment销毁时发生NullPointerException问题
     * 统一处理LoadingDialog逻辑
     */
    public abstract class BindCallback<E> extends HttpCallback<E> {
        /**
         * 设置LoadingDialog参数
         *
         * @param setting 数组下标 ->
         *                0.是否显示LoadingDialog(默认false)
         *                1.isCancelable(是否可以通过点击Back键取消)(默认true)
         *                2.isCanceledOnTouchOutside(是否在点击Dialog外部时取消Dialog)(默认false)
         */
        public BindCallback(boolean... setting) {

        }

        @Deprecated
        @Override
        public void onResponse(Call<E> call, Response<E> response) {
            if (canReceiveResponse()) {
                super.onResponse(call, response);
            }

        }

        @Deprecated
        @Override
        public void onFailure(Call<E> call, Throwable t) {
            if (canReceiveResponse()) {
                super.onFailure(call, t);
            }

        }
    }

    /**
     * 统一处理因异步导致的 Activity|Fragment销毁时发生NullPointerException问题
     * 统一处理LoadingDialog逻辑
     */
    public abstract class BindSubscriber<E> extends HttpSubscriber<E> {
        /**
         * 设置LoadingDialog参数
         *
         * @param setting 数组下标 ->
         *                0.是否显示LoadingDialog(默认false)
         *                1.isCancelable(是否可以通过点击Back键取消)(默认true)
         *                2.isCanceledOnTouchOutside(是否在点击Dialog外部时取消Dialog)(默认false)
         */
        public BindSubscriber(boolean... setting) {

        }

        @Deprecated
        @Override
        public void onNext(E data) {
            if (canReceiveResponse()) {
                super.onNext(data);
            }
        }

        @Deprecated
        @Override
        public void onError(Throwable pE) {
            if (canReceiveResponse()) {
                super.onError(pE);
            }
        }

        @Deprecated
        @Override
        public void onCompleted() {
            if (canReceiveResponse()) {
                super.onCompleted();
            }

        }
    }
    //------------------------------------子类可使用的工具函数 -> IFrameSubscription

    /**
     * 添加Subscriptions
     */
    @Override
    public final void addSubscriptions(@NonNull Subscription... pSubscriptions) {
        getCompositeSubscription().addAll(pSubscriptions);
    }

    /**
     * 获取CompositeSubscription实例
     */
    @Override
    public final CompositeSubscription getCompositeSubscription() {
        if (mSubscription == null) {
            mSubscription = new CompositeSubscription();
        }
        return mSubscription;
    }

    /**
     * 判断能否接收Response
     */
    @Override
    public final boolean canReceiveResponse() {
        return !mSubscription.isUnsubscribed();
    }
    //------------------------------------子类可使用的工具函数 -> IFrameNet

    /**
     * 根据IRequest类获取Request实例
     */
    @Override
    public final <E> E request(@NonNull Class<E> pIRequest) {
        return HttpManager.INSTANCE.request(pIRequest);
    }

    /**
     * 创建新的Retrofit实例
     * 根据IRequest类获取Request实例
     */
    @Override
    public final <E> E newRequest(@NonNull Class<E> pIRequest) {
        return HttpManager.INSTANCE.newRequest(pIRequest);
    }

    /**
     * 下载Retrofit实例 -> 默认读取超时时间5分钟
     * 根据IRequest类获取Request实例
     */
    @Override
    public final <E> E downloadRequest(@NonNull Class<E> pIRequest, @NonNull IHttpProgress pProgress) {
        return HttpManager.INSTANCE.downloadRequest(pIRequest, pProgress);
    }

    /**
     * 下载Retrofit实例,并设置读取超时时间
     * 根据IRequest类获取Request实例
     */
    @Override
    public final <E> E downloadRequest(@NonNull Class<E> pIRequest, @NonNull IHttpProgress pProgress, @IntRange(from = 0) int read_timeout) {
        return HttpManager.INSTANCE.downloadRequest(pIRequest, pProgress, read_timeout);
    }

    /**
     * 上传Retrofit实例 -> 默认写入超时时间5分钟
     * 根据IRequest类获取Request实例
     */
    @Override
    public final <E> E uploadRequest(@NonNull Class<E> pIRequest, @NonNull IHttpProgress pProgress) {
        return HttpManager.INSTANCE.uploadRequest(pIRequest, pProgress);
    }

    /**
     * 上传Retrofit实例,并设置写入超时时间
     * 根据IRequest类获取Request实例
     */
    @Override
    public final <E> E uploadRequest(@NonNull Class<E> pIRequest, @NonNull IHttpProgress pProgress, @IntRange(from = 0) int writeTimeout) {
        return HttpManager.INSTANCE.uploadRequest(pIRequest, pProgress, writeTimeout);
    }

    /**
     * 创建新的Retrofit实例,并设置超时时间
     * 根据IRequest类获取Request实例
     */
    @Override
    public final <E> E newRequest(@NonNull Class<E> pIRequest, @IntRange(from = 0) int connectTimeout, @IntRange(from = 0) int readTimeout, @IntRange(from = 0) int writeTimeout) {
        return HttpManager.INSTANCE.newRequest(pIRequest, connectTimeout, readTimeout, writeTimeout);
    }

}