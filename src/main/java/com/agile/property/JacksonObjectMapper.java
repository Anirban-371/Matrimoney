package com.agile.property;
import java.io.File;
import java.io.IOException;

import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JacksonObjectMapper {
	public static void main(String[] args) throws IOException {
		//read json file data to String
		//byte[] jsonData = Files.readAllBytes(Paths.get("/media/anirban/D/workspace/jackson_testing/src/main/webapp/employee.json"));
			File file = new File("/media/anirban/D/workspace/jackson_testing/src/main/webapp/employee.json");
		byte[] jsonData = FileUtils.readFileToByteArray(file);
		 
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		AddProperty prop = null;
		
		List<AddProperty> propList =
				objectMapper.readValue(jsonData, new TypeReference<List<AddProperty>>() {});
	
		for(AddProperty p : propList) {
		    System.out.println(p.getId());
		   /* System.out.println(p.getRoof());
		    System.out.println(p.getArea());
		    System.out.println(p.getMlsId());
		    System.out.println(p.getOffice());
		    System.out.println(p.getCountry());
		    /*for(int i=0;i<(p.getPhoneNumbers()).length;i++)
		    	System.out.println(p.getPhoneNumbers()[i]);*/
			}
	}
}
