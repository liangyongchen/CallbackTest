package com.model.fileUploader;


import android.app.Application;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUploadPackage implements ReactPackage {

    private Application applicationInstance;

    public FileUploadPackage(Application applicationInstance) {
        super();
        this.applicationInstance = applicationInstance;
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        FileUploadManager fileUploadManager = new FileUploadManager(reactContext);
        applicationInstance.registerActivityLifecycleCallbacks(fileUploadManager);
        modules.add(fileUploadManager);
        return modules;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList();
    }
}
