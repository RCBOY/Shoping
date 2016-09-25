package com.ztc.shop.unit;

import com.ztc.shop.model.FileImage;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.UUID;

/**
 * Description：用来实现文件上传的业务逻辑
 * Created by ZTCJoe on 2016/9/24.
 */
@Component("fileUpload")
public class FileUploadUtil implements com.ztc.shop.unit.FileUpload {
    String filePath="C:/ShopWeb/";
    @Value("#{prop.filePath}")
    //    通过文件名获取扩展
    public void setFilePath(String filePath) {
        System.out.println(filePath);
        this.filePath = filePath;
    }

    public String getFileExt(String filename){
        return FilenameUtils.getExtension(filename);
    }
//    根据生成uuid随机数作为新文件名
    public String newFileName(String filename){
       String ext= getFileExt(filename);
        return UUID.randomUUID().toString()+"."+ext;
    }
//    实现文件上传功能
    public String uploadFile(FileImage fileImage){
       String pic= newFileName(fileImage.getFilename());
        try{
            FileUtil.copyFile(fileImage.getFile(),new File(filePath,pic));
            return pic;
    }catch (Exception e){
            throw  new  RuntimeException(e);
        }
        finally {
            fileImage.getFile().delete();
        }
    }
}
