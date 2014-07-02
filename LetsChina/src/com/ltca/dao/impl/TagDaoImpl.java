package com.ltca.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ltca.dao.TagDao;
import com.ltca.entity.Tag;

@Repository("tagDaoImpl")
public class TagDaoImpl extends BaseDaoImpl<Tag, Integer> implements TagDao {
	public List<Tag> getAllTagsForModal(Integer modalID){
		return getSession().createQuery("from Tag t where t.baseModal.id= ?").setInteger(0, modalID).list();
	}
}
