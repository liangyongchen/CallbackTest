package com.model.fileUploader;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Arrays;
import java.util.List;

public class FileUploadManager extends ReactContextBaseJavaModule
        implements Application.ActivityLifecycleCallbacks {

    private ReactApplicationContext reactContext;
    private UploadStateModule callBack = null; // 回调js的接口

    public FileUploadManager(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Arrays.<Class<? extends JavaScriptModule>>asList(
                UploadStateModule.class
        );
    }

    @Override
    public String getName() {
        return "FileUpload";
    }

    @ReactMethod
    public void stopListener() {
        callBack = null;
    }

    @ReactMethod
    public void startListener() {
        try {
            callBack = this.reactContext.getJSModule(UploadStateModule.class);
            new Thread() {
                @Override
                public void run() {
                    openCallback();
                }
            }.start();
            Thread.sleep(100);
        } catch (Exception e) {
            String a = "";
            String a1 = "";
        }
    }

    private synchronized String openCallback() {

        try {
            if (callBack != null) {
                for (int i = 0; i < 20; i++) {
                    Thread.sleep(3000);
                    callBack.changeFileUploadState(i + "", "code=" + i, "成功回调 > " + i + " 次");
                }
            }

        } catch (Exception err) {
            Log.d("Callback", err.getMessage());
        }

        return "";
    }


    // region // 生命周期回调

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    // endregion

}
