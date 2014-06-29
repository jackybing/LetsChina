package com.ltca.dao.impl;

import org.springframework.stereotype.Repository;

import com.ltca.dao.TagDao;
import com.ltca.entity.Tag;

@Repository("tagDaoImpl")
public class TagDaoImpl extends BaseDaoImpl<Tag, Integer> implements TagDao {
}
