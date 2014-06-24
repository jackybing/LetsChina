package com.ltca.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ltca.dao.GraphicDao;
import com.ltca.entity.Graphic;
import com.ltca.service.GraphicService;

@Service("graphicServiceImpl")
public class GraphicServiceImpl extends BaseServiceImpl<Graphic, Integer> implements
		GraphicService {

}
