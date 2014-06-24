package com.ltca.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.ltca.dao.GraphicDao;
import com.ltca.dao.PathDao;
import com.ltca.entity.Graphic;
import com.ltca.entity.Path;
import com.ltca.service.PathService;

@Service("pathServiceImpl")
public class PathServiceImpl extends BaseServiceImpl<Path, Integer> implements
		PathService {
	@Resource(name="pathDaoImpl")
	private PathDao pathDao;
	@Resource(name="graphicDaoImpl")
	private GraphicDao graphicDao;
	
	
	public JSONArray getPagingList(int pagenum, int pagesize,
			String pagingHql) {
		// TODO Auto-generated method stub
		List<Path> paths=getListForPaging(pagenum, pagesize, pagingHql);
		
		
		for (Path path : paths) {
			jsonObject=new JSONObject();
			jsonObject.put("id", path.getId());
			jsonObject.put("title", path.getTitle());
			jsonObject.put("content", path.getContent());
			jsonObject.put("price", path.getPrice());
			jsonObject.put("date", path.getDate().toString());
			
			jsonArray2=new JSONArray();
			for (Graphic graphic : path.getGraphics()) {
				jsonObject2=new JSONObject();
				jsonObject2.put("gID", graphic.getId());
				jsonObject2.put("url", graphic.getUrl());
				jsonObject2.put("disk", graphic.getDisk());
				jsonArray2.add(jsonObject2);
			}
			
			jsonObject.put("graphics", jsonArray2);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	public void addGraphic(Integer pathId,List<Graphic> graphics){
		Path path=get(pathId);
		for (Graphic graphic : graphics) {
			path.getGraphics().add(graphic);
			graphicDao.save(graphic);
		}	
		update(path);
		
	}
	public void deletePath(Integer pathID){
		Path path=get(pathID);
		for (Graphic graphic : path.getGraphics()) {
			fileUploadUtil.deleteFileOnUpload(graphic.getDisk());
			graphicDao.delete(graphic);
		}
		delete(path);
	}
	
	public void updatePath(Integer pathID,Path newPath,List<Graphic> graphics){
		Path path=get(pathID);
		path.setTitle(newPath.getTitle());
		path.setContent(newPath.getContent());
		path.setDate(new Date());
		path.setPrice(newPath.getPrice());
		
		//重新添加新的图片集
		for (Graphic graphic : graphics) {
			path.getGraphics().add(graphic);
			graphicDao.save(graphic);
		}		
		update(path);
	}
	
	public void updatePath(Integer pathID,Path newPath){
		Path path=get(pathID);
		path.setTitle(newPath.getTitle());
		path.setContent(newPath.getContent());
		path.setDate(new Date());
		path.setPrice(newPath.getPrice());
		update(path);
	}
	
	
}
