package com.ztc.shop.unit;

import com.ztc.shop.model.FileImage;

public interface FileUpload {
    public String uploadFile(FileImage fileImage);
    public String[] getBankIamages();
}
