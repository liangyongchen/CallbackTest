import FileUploadManager from '../callback/FileUploadManager'

export default class FileUploadUtil {

    static start = (callback) => {

        try {
            console.log('初始化文件上传监听')
            this.fileUpload = new FileUploadManager(callback)
        } catch (err) {
            console.log('初始化文件上传监听错误')
        }

    }

    static stop = () => {
        this.fileUpload.dispose() // 关闭监听
    }

}
