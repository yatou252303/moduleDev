package com.acmenxd.frame.basis;

import com.acmenxd.retrofit.callback.HttpSubscriber;

/**
 * @author AcmenXD
 * @version v1.0
 * @github https://github.com/AcmenXD
 * @date 2017/1/12 14:06
 * @detail 网络请求返回后, 处理回调
 */
public abstract class RequestSubscriber<T> extends HttpSubscriber<T> {
    private BaseView mBaseView;

    /**
     * 设置LoadingDialog参数
     *
     * @param setting 数组下标 ->
     *                0.是否显示LoadingDialog(默认false)
     *                1.isCancelable(是否可以通过点击Back键取消)(默认true)
     *                2.isCanceledOnTouchOutside(是否在点击Dialog外部时取消Dialog)(默认false)
     */
    public RequestSubscriber(BaseView pBaseView, boolean... setting) {
        mBaseView = pBaseView;
        mBaseView.showLoadingDialogBySetting(setting);
    }

    @Deprecated
    @Override
    public void onNext(T data) {
        if (mBaseView.canReceiveResponse()) {
            super.onNext(data);
        }
    }

    @Deprecated
    @Override
    public void onError(Throwable pE) {
        if (mBaseView.canReceiveResponse()) {
            super.onError(pE);
        }
    }

    @Deprecated
    @Override
    public void onCompleted() {
        if (mBaseView.canReceiveResponse()) {
            super.onCompleted();
        }
        mBaseView.hideLoadingDialog();
    }
}
