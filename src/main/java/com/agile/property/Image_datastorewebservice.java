package com.agile.property;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@Path("/imagetoreget")
public class Image_datastorewebservice {
	
	static {
        ObjectifyService.register(AddProperty.class);
        ObjectifyService.register(AddImage.class);
    }
	@GET
	@Produces("application/json")
	public Response getproperty() throws JSONException {
		System.out.println("I am here");
		Objectify objectify=ObjectifyService.begin();
		JSONObject jsonObject = new JSONObject();
		List<AddProperty> addprop = objectify.query(AddProperty.class).list();
		
		List<AddProperty> metaList = new ArrayList<AddProperty> ();
		
		for (AddProperty prop: addprop) {
			AddProperty addproperty=new AddProperty();
			addproperty.setHouse_number(prop.getHouse_number());
			addproperty.setHouse_category(prop.getHouse_category());
			addproperty.setHouse_type(prop.getHouse_type());
			addproperty.setAddress_city(prop.getAddress_city());
			addproperty.setAddress_state(prop.getAddress_state());
			addproperty.setAddress_country(prop.getAddress_country());
			addproperty.setAddress_street(prop.getAddress_street());
			addproperty.setAddress_zip_postal_code(prop.getAddress_zip_postal_code());
			addproperty.setArea_square_feet(prop.getArea_square_feet());
			addproperty.setParameters_lot_size(prop.getParameters_lot_size());
			addproperty.setParameters_square_feet(prop.getParameters_square_feet());
			addproperty.setContacts_proprietor_name(prop.getContacts_proprietor_name());
			addproperty.setContacts_proprietor_role(prop.getContacts_proprietor_role());
			addproperty.setMap_latitude(prop.getMap_latitude());
			addproperty.setMap_longitude(prop.getMap_longitude());
			addproperty.setProperty_category(prop.getProperty_category());
			addproperty.setProperty_currency(prop.getProperty_currency());
			addproperty.setProperty_listing_type(prop.getProperty_listing_type());
			addproperty.setProperty_owner(prop.getProperty_owner());
			addproperty.setProperty_price(prop.getProperty_price());
			addproperty.setProperty_region(prop.getProperty_region());
			addproperty.setProperty_status(prop.getProperty_status());
			addproperty.setProperty_type(prop.getProperty_type());
			addproperty.setProperty_square_feet(prop.getProperty_square_feet());
			addproperty.setId(prop.getId());
			//System.out.println(prop.getArea()+" "+prop.getCountry()+" "+prop.getMlsId()+" "+prop.getPostalcode());
			//jsonObject.put(prop.getId()+"", {prop.getArea(),prop.getMlsId(),prop.getOffice(),prop.getRoof(),prop.getPostalcode()});
			/*jsonObject.put("area", prop.getArea());
			jsonObject.put("mlsid", prop.getMlsId());
			jsonObject.put("office", prop.getOffice());
			jsonObject.put("roof", prop.getRoof());
			jsonObject.put("postalcode", prop.getPostalcode());*/
			metaList.add(addproperty);
			//Key<AddProperty> key = objectify.getFactory().getKey(addproperty);
			//System.out.println("Key:"+key);
		}
		Gson gson = new Gson();
		String json = gson.toJson(metaList);
		System.out.println(json);
		
		
		//jsonObject.put(prop.getId()+"", prop);
		System.out.println("I am out");
		return Response.status(200).entity(json+"").build();
	}
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)	
    public Response add(String incomingData) throws IOException
     {
		String returnString = null;
		System.out.println("incomingData: " + incomingData);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			AddProperty message = mapper.readValue(incomingData, AddProperty.class);
			System.out.println("message::"+message);
			AddProperty addproperty=new AddProperty();
			addproperty.setHouse_number(message.house_number);
			addproperty.setHouse_category(message.house_category);
			addproperty.setHouse_type(message.house_type);
			addproperty.setAddress_city(message.address_city);
			addproperty.setAddress_state(message.address_state);
			addproperty.setAddress_country(message.address_country);
			addproperty.setAddress_street(message.address_street);
			addproperty.setAddress_zip_postal_code(message.address_zip_postal_code);
			addproperty.setArea_square_feet(message.area_square_feet);
			addproperty.setParameters_lot_size(message.parameters_lot_size);
			addproperty.setParameters_square_feet(message.parameters_square_feet);
			addproperty.setContacts_proprietor_name(message.contacts_proprietor_name);
			addproperty.setContacts_proprietor_role(message.contacts_proprietor_role);
			addproperty.setMap_latitude(message.map_latitude);
			addproperty.setMap_longitude(message.map_longitude);
			addproperty.setProperty_category(message.property_category);
			addproperty.setProperty_currency(message.property_currency);
			addproperty.setProperty_listing_type(message.property_listing_type);
			addproperty.setProperty_owner(message.property_owner);
			addproperty.setProperty_price(message.property_price);
			addproperty.setProperty_region(message.property_region);
			addproperty.setProperty_status(message.property_status);
			addproperty.setProperty_type(message.property_type);
			addproperty.setProperty_square_feet(message.property_square_feet);
			addproperty.setId(message.id);
			//Long idd =message.id;
			

			//Key<AddProperty> propertyKey = new Key<AddProperty>(AddProperty.class, addproperty.getId());
			//Car car = new Car(ownerKey);
			System.out.println(message.getHouse_number()+" "+message.getHouse_category()+" "+message.getHouse_type()+" "+message.getAddress_city());
	    	Objectify objectify=ObjectifyService.begin();
	    	List<AddProperty> ll=new ArrayList<AddProperty>();	    	
	    	System.out.println("Id:"+addproperty.id);	    	
			ll.add(addproperty);
			objectify.put(ll);
			
			AddImage image_det = mapper.readValue(incomingData, AddImage.class);
			AddImage image_details=new AddImage();
			image_details.setId(image_det.id);
			image_details.setImage_url(image_det.Image_url);
			image_details.setProperty(new Key<AddProperty>(AddProperty.class, addproperty.getId()));
			List<AddImage> ll1=new ArrayList<AddImage>();	
			ll1.add(image_details);
			objectify.put(ll1);
			return Response.status(200).entity("Row Inserted").build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();	
		}
		
     }
}

