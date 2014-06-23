package com.ltca.dao.impl;

import org.springframework.stereotype.Repository;

import com.ltca.dao.PathDao;
import com.ltca.entity.Path;

@Repository(value="pathDaoImpl")
public class PathDaoImpl extends BaseDaoImpl<Path, Integer> implements PathDao {

}
