import {
    NativeModules,
    NativeEventEmitter,
    Platform,
} from 'react-native'

const BatchedBridge = require('react-native/Libraries/BatchedBridge/BatchedBridge')

const FileUploadAndroid = NativeModules.FileUpload

var UploadStateModule = require('./UploadStateModule')
// 与Android的接口绑定
BatchedBridge.registerCallableModule('UploadStateModule', UploadStateModule)


class FileUploadManager {
    callback

    constructor(callback) {
        this.callback = callback
        try {
            FileUploadAndroid.startListener()     // 开始监听接收 Android 中接口的回调
            UploadStateModule.callback = callback // 安卓中的接口与js的接口绑定
        } catch (err) {
            console.log(err)
        }

    }

    dispose() {
        UploadStateModule.callback = undefined
        FileUploadAndroid.stopListener()
    }
}

export default module.exports = FileUploadManager







