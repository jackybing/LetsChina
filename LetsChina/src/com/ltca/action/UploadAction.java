package com.ltca.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ltca.util.FileUploadUtil;

@Controller
public class UploadAction {
	
	private static final Logger log = Logger.getLogger(UploadAction. class);
	@Autowired
	private FileUploadUtil fileUploadUtil;
	
	/**
	 * <b>Summary: </b>
	 *     uploadImage 上传图片
	 * @param image
	 * @return 返回上传成功的图片的本地地址和网络地址信息
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String, String> uploadImage(@RequestParam("file") MultipartFile image) throws IOException {
		boolean status = true;
		String fileName=image.getOriginalFilename();
		StringBuffer buf = new StringBuffer();
		Map<String, String> addressMap = null;
		if (log.isDebugEnabled())
			log.debug("开始上传图片：" + fileName);
		// 判断上传图片的后缀和大小
		if (!fileUploadUtil.isImageSizeValid(image)) {
			status = false;
			buf.append("对不起，您本次上传的图片太大了");
		}

		String ext = fileName.substring(fileName.lastIndexOf("."));//.xxx
		String fname=fileName.substring(0,fileName.lastIndexOf("."));//不包含.xxx
		System.out.println("ext:"+ext);
		// 后缀判断
		if (!fileUploadUtil.isImageExtensionValid(ext)) {
			status = false;
			buf.append("对不起，您本次上传的图片后缀为'").append(ext).append("'，本系统只支持后缀为")
					.append(fileUploadUtil.getAcceptExtensions().keySet())
					.append("的图片");

		}	
		if (status) {// 通过了校验
			/* 将图片上传到服务器指定目录中 */			
			addressMap = fileUploadUtil.copyImageToServer(image.getInputStream());
		}		
		return addressMap;
    }
	
}
