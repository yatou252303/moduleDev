//package com.acmenxd.retrofit.interceptor;
//
//import java.io.IOException;
//
//import cn.ftoutiao.account.android.core.AccountManager;
//import cn.ftoutiao.account.android.core.util.AppUtils;
//import cn.ftoutiao.account.android.core.util.Encrypt;
//import okhttp3.HttpUrl;
//import okhttp3.Interceptor;
//import okhttp3.Request;
//import okhttp3.Response;
//
///**
// *  @author alan
// *
// *  请求拦截器
// *
// */
//public class RequestInterceptor implements Interceptor {
//
//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        Request original = chain.request();
//        HttpUrl originalHttpUrl = original.url();
//        HttpUrl url = null;
//        if ("GET".equals(original.method())) {
//            String imei = Con.getIMEI();
//            long time = System.currentTimeMillis();
//            url = originalHttpUrl.newBuilder()
//                    .addQueryParameter("client", "android")
//                    .addQueryParameter("appname", "dpaccount")
//                    .addQueryParameter("channel", "GooglePlay") //TODO:channel
//                    .addQueryParameter("ver", AppUtils.getClientVersionName())
//                    .addQueryParameter("imei", imei)
//                    .addQueryParameter("ts", time + "")
//                    .addQueryParameter("sign", Encrypt.encrypt(time, imei, null))
//                    .build();
//            if (url.pathSegments().contains("verifySms")) {
//                String mobile = url.queryParameter("mobile");
//                url = url.newBuilder().addQueryParameter("tk", Encrypt.encrypt(time, imei, mobile)).build();
//            }
//        }
//        if (url == null) {
//            url = originalHttpUrl;
//        }
//        Request.Builder builder = original.newBuilder()
//                .url(url);
//        if (AccountManager.getInstance().isLogin()) {
//            builder.header("Cookie", AccountManager.getInstance().generateCookie());
//        }
//        buildHeader(builder);
//
//        return chain.proceed(builder.build());
//    }
//
//    protected void buildHeader(Request.Builder builder) {
//
//    }
//}
