package com.resoursetechmapping.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resoursetechmapping.bean.Resource;
import com.resoursetechmapping.dao.ResourceDao;
import com.resoursetechmapping.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;

	public void addResourece(Resource resource) {
		resourceDao.addResourece(resource);
	}

	public Resource getResource(String idOrName) {
		return resourceDao.getResource(idOrName);

	}
}
