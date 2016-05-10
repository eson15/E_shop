package cn.it.shop.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.it.shop.model.FileImage;

/**
 * @Description: TODO(实现文件上传的业务逻辑)
 * @author Ni Shengwu
 *
 */
@Component("fileUpload")
public class FileUploadUtil implements FileUpload {
	
	private String filePath;
	@Value("#{prop.filePath}") 
	//@Value表示去beans.xml文件中找id="prop"的bean，它是通过注解的方式读取properties配置文件的，然后去相应的配置文件中读取key=filePath的值
	public void setFilePath(String filePath) {
		System.out.println(filePath);
		this.filePath = filePath;
	}

	//1. 通过文件名获取扩展名
	private String getFileExt(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}
	
	//2. 生成UUID随机数，作为新的文件名
	private String newFileName(String fileName) {
		String ext = getFileExt(fileName);
		return UUID.randomUUID().toString() + "." + ext;
	}
	
	//实现文件上传的功能，返回上传后新的文件名称
	/* (non-Javadoc)
	 * @see cn.it.shop.utils.FileUpload#uploadFile(cn.it.shop.model.FileImage)
	 */
	@Override
	public String uploadFile(FileImage fileImage) {
		//获取新唯一文件名
		String pic = newFileName(fileImage.getFilename());
		try {
			FileUtil.copyFile(fileImage.getFile(), new File(filePath, pic));
			return pic;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			fileImage.getFile().delete();
		}
	}
}
