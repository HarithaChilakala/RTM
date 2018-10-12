package com.resoursetechmapping.service;

import com.resoursetechmapping.bean.Resource;

public interface ResourceService {
	
	public void addResourece(Resource resource);
	public Resource getResource(String idOrName);
}
