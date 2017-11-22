package com.suning.manager.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.suning.common.entity.PictureUploadResult;
import com.suning.common.service.PropertyService;
/**
 * 图片上传
 * 
 * 这是在MVC容器里面找属性
 * @Value只能在当前容器里面找值 
 * 虽然子容器MVC可以在Spring中获取值 
 * 但是注意@Value
 */
@Controller
@RequestMapping("/picture")
public class PictureUploadController {
	//类范围使用的常量定义
	// 允许上传的格式
	private static final String[] IMAGE_TYPE = new String[] { ".bmp", ".jpg", ".jpeg", ".gif", ".png" };

	@Autowired
	private PropertyService propertyService;
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = {MediaType.TEXT_HTML_VALUE})
	public @ResponseBody String upload(@RequestParam("uploadFile") MultipartFile uploadFile , HttpServletResponse response) throws Exception {
		boolean legal = false;

		// 校验图片格式
		for (String type : IMAGE_TYPE) {
			if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(), type)) {
				legal = true;
				break;
			}
		}

		// 封装Result对象，并且将文件的byte数组放置到result对象中
		PictureUploadResult fileUploadResult = new PictureUploadResult();

		// 后缀是否符合 
		fileUploadResult.setError(legal ? 0 : 1);
		// 文件新路径
		String filePath = getFilePath(uploadFile.getOriginalFilename());


		// 生成图片的绝对引用地址 
		//"E:/java项目/suning/suning-upload"   后的部分
		String picUrl = StringUtils.replace(StringUtils.substringAfter(filePath, propertyService.REPOSITORY_PATH), File.separator, "/");
		fileUploadResult.setUrl(propertyService.IMAGE_BASE_URL + picUrl);

		File newFile = new File(filePath);
		// 写文件到磁盘
		uploadFile.transferTo(newFile);

		legal = false;
		try {
			//对图片内容进行校验 尝试获取图片的长和宽
			BufferedImage image = ImageIO.read(newFile);
			if (image != null) {
				fileUploadResult.setWidth(String.valueOf(image.getWidth()));
				fileUploadResult.setHeight(String.valueOf(image.getHeight()));
				legal = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 状态
		fileUploadResult.setError(legal ? 0 : 1);

		//如果为false
		if (!legal) {
			newFile.delete();
		}
		
		return JSON.toJSONString(fileUploadResult);
	}

	private String getFilePath(String sourceFileName) {
		String baseFolder = propertyService.REPOSITORY_PATH + File.separator + "images";
		Date nowDate = new Date();
		//创建目录
		String fileFolder = baseFolder + File.separator + new SimpleDateFormat("yyyy-MM-dd").format(nowDate).replace("-", File.separator);
		File file = new File(fileFolder);
		if (!file.isDirectory()) {
			// 如果目录不存在，则创建目录
			file.mkdirs();
		}
		// 生成新的文件名
		String fileName = new SimpleDateFormat("yyyyMMddhhmmssSSSS").format(nowDate) + RandomUtils.nextInt(100, 9999) + "." + StringUtils.substringAfterLast(sourceFileName, ".");
		return fileFolder + File.separator + fileName;
	}

}
