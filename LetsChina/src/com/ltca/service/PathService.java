package com.ltca.service;

import java.util.List;

import net.sf.json.JSONArray;

import com.ltca.entity.Graphic;
import com.ltca.entity.Path;

public interface PathService extends BaseService<Path, Integer> {
	public void addGraphic(Integer pathId,List<Graphic> graphics);
	public JSONArray getPagingList(int pagenum, int pagesize,
			String pagingHql);
	public void updatePath(Integer pathID,Path newPath);
}
