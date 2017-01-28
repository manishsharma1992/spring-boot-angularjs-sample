package com.thoughtworksoftwares.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtworksoftwares.dao.impl.GenericDomainDaoImpl;
import com.thoughtworksoftwares.service.IGenericDomainService;

@Service
public class GenericDomainServiceImpl implements IGenericDomainService {

	private GenericDomainDaoImpl genericDomainDaoImpl;
	
	@Override
	public List<?> getList() {
		return genericDomainDaoImpl.getList();
	}

	@Autowired
	public void setGenericDomainDaoImpl(GenericDomainDaoImpl genericDomainDaoImpl) {
		this.genericDomainDaoImpl = genericDomainDaoImpl;
	}
	
	

}
