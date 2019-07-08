package com.model.fileUploader;

import com.facebook.react.bridge.JavaScriptModule;

public interface UploadStateModule extends JavaScriptModule {
    void changeFileUploadState(String type, String code, String msg);
}
