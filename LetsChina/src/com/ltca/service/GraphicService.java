package com.ltca.service;

import com.ltca.entity.Graphic;

public interface GraphicService extends BaseService<Graphic, Integer> {
	public void deleteGraphic(Integer gID);
}
