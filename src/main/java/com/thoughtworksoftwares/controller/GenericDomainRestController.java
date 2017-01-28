package com.thoughtworksoftwares.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thoughtworksoftwares.service.impl.GenericDomainServiceImpl;

@Controller
@RequestMapping("/generic")
public class GenericDomainRestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(GenericDomainRestController.class);
	
	private GenericDomainServiceImpl genericDomainServiceImpl;
	
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public @ResponseBody Map<String, ? extends Object> getList(@RequestParam MultiValueMap<String, String> queryParams) {
		
		LOG.info("Requesting getList with query parameters : " + queryParams);
		List<?> list = genericDomainServiceImpl.getList();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("data", list);
		modelMap.put("total", list.size());
		modelMap.put("success", true);
		
		return modelMap;
	}

	@Autowired
	public void setGenericDomainServiceImpl(GenericDomainServiceImpl genericDomainServiceImpl) {
		this.genericDomainServiceImpl = genericDomainServiceImpl;
	}
	
	

}
