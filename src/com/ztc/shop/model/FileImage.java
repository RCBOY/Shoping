package com.ztc.shop.model;

import java.io.File;

/**
 * Description：文件上传功能的基本属性
 * Created by ZTCJoe on 2016/9/23.
 */
public class FileImage {
    private File file;
    private String contentType;
    private String filename;

    public File getFile() {
        return file;
    }

    public String getContentType() {
        return contentType;
    }

    public String getFilename() {
        return filename;
    }

    public void setUpload(File file){
        this.file=file;
    }
    public void setUploadContentType(String contentType){
        this.contentType=contentType;
    }
    public void setUploadFileName(String filename){
        this.filename=filename;
    }
}
