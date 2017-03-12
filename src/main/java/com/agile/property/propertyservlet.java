package com.agile.property;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

/**
 * Servlet implementation class propertyservlet
 */

public class propertyservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public propertyservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		System.out.println("I am here");
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
		//anirban to write code here
		
		response.setContentType("text/html");
		//ObjectifyService.register(AddProperty.class);	
		//RequestDispatcher dispatcher;
		//boolean flag;
	
		String roof=request.getParameter("roof");
		String area=request.getParameter("area");
		String mlsId=request.getParameter("mlsId");
		String office=request.getParameter("office");
		String country=request.getParameter("country");
		String postalcode=request.getParameter("postalcode");
		String image=request.getParameter("imagebox");
		System.out.println("image is:"+image);
		Text TextValue = new Text(image);
		try{
			Key empKey = KeyFactory.createKey("AddProperty", mlsId);
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			 //Objectify of = ObjectifyService.begin(); 
			// List<AddProperty> le = new ArrayList<>();
			 System.out.println("roof:::"+roof+" ,area:::"+area+" ,mlsId:::"+mlsId+" ,office:::"+office+" ,country:::"+country+" ,postalcode:::"+postalcode);
			// AddProperty add=new AddProperty(prop_name,prop_add,agent_name);
			 Entity emp = new Entity("AddProperty", empKey);
			 emp.setProperty("roof", roof);
			 emp.setProperty("area", area);
			 emp.setProperty("mlsId", mlsId);
			 emp.setProperty("office", office);
			 emp.setProperty("country", country);
			 emp.setProperty("postalcode", postalcode);
			 emp.setProperty("image", TextValue);
			
			 //le.add(add);
			 datastore.put(emp);
			 Query q = new Query("AddProperty");
				List<Entity> l = datastore.prepare(q).asList(
						FetchOptions.Builder.withLimit(10));
				try {
					request.setAttribute("AddPropertylist", l);
					
					  for(Entity e:l) { System.out.println("the list is:"+e); }
					 
					request.getRequestDispatcher("index.jsp").forward(request, response);
					// out.print(l.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}

		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
	}

}
