package com.ltca.service.impl;

import javax.annotation.Resource;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltca.dao.GraphicDao;
import com.ltca.entity.Graphic;
import com.ltca.service.GraphicService;
import com.ltca.util.FileUploadUtil;

@Service("graphicServiceImpl")
public class GraphicServiceImpl extends BaseServiceImpl<Graphic, Integer> implements
		GraphicService {
	
	public void deleteGraphic(Integer gID){
		Graphic graphic=get(gID);
		fileUploadUtil.deleteFileOnUpload(graphic.getDisk());
		
		delete(graphic);
	}

}
