package com.ltca.service;

import java.util.List;

import com.ltca.entity.Graphic;
import com.ltca.entity.Path;

public interface PathService extends BaseService<Path, Integer> {
	public void createPath(Path path,List<Graphic> graphics);
}
