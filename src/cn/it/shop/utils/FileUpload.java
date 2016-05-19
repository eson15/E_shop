package cn.it.shop.utils;

import cn.it.shop.model.FileImage;

public interface FileUpload {

	//实现文件上传的功能，返回上传后新的文件名称
	public abstract String uploadFile(FileImage fileImage);
	//获得银行的图标
	public String[] getBankImage();
}