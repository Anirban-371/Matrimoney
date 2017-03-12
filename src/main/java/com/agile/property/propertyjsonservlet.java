package com.agile.property;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

/**
 * Servlet implementation class propertyjsonservlet
 */
public class propertyjsonservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public propertyjsonservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		System.out.println("I am doGet");
		Query q = new Query("AddProperty");
		List<Entity> l = datastore.prepare(q).asList(
				FetchOptions.Builder.withLimit(10));
		try {
			request.setAttribute("AddPropertylist", l);
			/*
			 * for(Entity e:l) { out.print("the list is:"+e); }
			 */
			request.getRequestDispatcher("index.jsp").forward(request, response);
			// out.print(l.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am inside doPOST");
		response.setContentType("text/html");
		File file = new File("realestate.json");
		if (file!=null){
		byte[] jsonData = FileUtils.readFileToByteArray(file);
		System.out.println("File reading complete");
		System.out.println("helo1");
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<AddProperty> propList =
				objectMapper.readValue(jsonData, new TypeReference<List<AddProperty>>() {});
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		for(AddProperty p : propList) {
		    System.out.println(p.getId());
		   /* System.out.println(p.getRoof());
		    System.out.println(p.getArea());
		    System.out.println(p.getMlsId());
		    System.out.println(p.getOffice());
		    
		    
		    System.out.println("Inside1");
		    System.out.println(p.getCountry());
		    System.out.println("Inside11");
		    String roof=p.getRoof();
		    System.out.println(roof);			
		    int area=p.getArea();
			System.out.println(area);
			String mlsId=p.getMlsId();
			System.out.println(mlsId);
			String office=p.getOffice();
			System.out.println(office);
			String country=p.getCountry();
			System.out.println(country);
			int postalcode=p.getPostalcode();
			System.out.println(postalcode);
			System.out.println();
		    /*for(int i=0;i<(p.getPhoneNumbers()).length;i++)
		    	System.out.println(p.getPhoneNumbers()[i]);*/
			try{
				System.out.println("Inside try");
				Key empKey = KeyFactory.createKey("AddProperty", "abc");
				System.out.println("empkey"+ empKey.getName());
				
				 //Objectify of = ObjectifyService.begin(); 
				// List<AddProperty> le = new ArrayList<>();
				/* System.out.println("roof:::"+roof+" ,area:::"+area+" ,mlsId:::"+mlsId+" ,office:::"+office+" ,country:::"+country+" ,postalcode:::"+postalcode);
				// AddProperty add=new AddProperty(prop_name,prop_add,agent_name);
				 Entity emp = new Entity("AddProperty", empKey);
				 emp.setProperty("roof", roof);
				 emp.setProperty("area", area);
				 emp.setProperty("mlsId", mlsId);
				 emp.setProperty("office", office);
				 emp.setProperty("country", country);
				 emp.setProperty("postalcode", postalcode);
				 
				 //le.add(add);*/
				// datastore.put(emp);
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println(e);
			}
		}
		 Query q = new Query("AddProperty");
		 List<Entity> l =null;
		 l = datastore.prepare(q).asList(
					FetchOptions.Builder.withLimit(10));
			try {
				request.setAttribute("AddPropertylist", l);
				
				for(Entity e:l) { 
					System.out.println("the list is:"+e); 
				}
				 
				
				// out.print(l.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	//ObjectifyService.register(AddProperty.class);	
	//RequestDispatcher dispatcher;
	//boolean flag;
    /*
	String roof=request.getParameter("roof");
	String area=request.getParameter("area");
	String mlsId=request.getParameter("mlsId");
	String office=request.getParameter("office");
	String country=request.getParameter("country");
	String postalcode=request.getParameter("postalcode");
	*/
	
	
	

	}

}
