var UploadStateModule = {
    changeFileUploadState(type, code, msg) {
        this.callback && this.callback(type, code, msg)
    }
}


module.exports = UploadStateModule
