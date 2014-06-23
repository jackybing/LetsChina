package com.ltca.dao.impl;

import org.springframework.stereotype.Repository;

import com.ltca.dao.GraphicDao;
import com.ltca.entity.Graphic;

@Repository("graphicDaoImpl")
public class GraphicDaoImpl extends BaseDaoImpl<Graphic, Integer> implements GraphicDao {

}
