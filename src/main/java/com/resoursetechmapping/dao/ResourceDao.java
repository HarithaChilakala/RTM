package com.resoursetechmapping.dao;

import com.resoursetechmapping.bean.Resource;

public interface ResourceDao {
	
public void addResourece(Resource resource);
public Resource getResource(String idOrName);
}
