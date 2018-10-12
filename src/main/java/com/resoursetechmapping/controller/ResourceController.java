package com.resoursetechmapping.controller;


import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.resoursetechmapping.bean.Resource;
import com.resoursetechmapping.service.ResourceService;

@RestController
public class ResourceController {
	@Autowired
	private ResourceService resourceService;
	
	
	/**
	 * This method used insert the resource into Database
	 */
	@RequestMapping(value = "/addResource", method = RequestMethod.POST)
	public String addResource(@RequestBody  String input) {
		System.out.println("area reachedd" + input);
		
		try {
			Resource resource = new ObjectMapper().readValue(input,Resource.class);
			System.out.println(resource.toString());
			resourceService.addResourece(resource);
			return new ObjectMapper().writeValueAsString("Success");
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * This method used insert the resource into Database
	 */
	@RequestMapping(value = "/getResource/{idOrName}", method = RequestMethod.GET)
	public  String getResource(@PathVariable String idOrName) {
		Resource resourceResult = resourceService.getResource(idOrName);
		System.out.println("Resource Result Is ->"+resourceResult.toString());
		
		String result=null;
		try {
			result = new ObjectMapper().writeValueAsString(resourceResult);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return result;
	}
}
