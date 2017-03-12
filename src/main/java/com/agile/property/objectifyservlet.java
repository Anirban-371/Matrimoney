package com.agile.property;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Transient;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
/**
 * Servlet implementation class objectifyservlet
 */
public class objectifyservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	static {
        ObjectifyService.register(AddProperty.class);
    }
    public objectifyservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ObjectifyService.register(AddProperty.class);
		/*Objectify objectify=ObjectifyService.begin();
		//AddProperty add=new AddProperty();
		Query<AddProperty> q = objectify.query(AddProperty.class);
	    System.out.println(q);*/
		/*ObjectifyFactory factory = new ObjectifyFactory();
		Objectify objectify=factory.begin();
		List<AddProperty> property = objectify.load().type(AddProperty.class).list();
		System.out.println(property);
	    request.setAttribute("AddPropertylist", property);
	    request.getRequestDispatcher("index.jsp").forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Objectify objectify=ObjectifyService.begin();
		AddProperty add=new AddProperty();
	/*	add.setRoof(request.getParameter("roof"));
		add.setArea(Integer.parseInt(request.getParameter("area")));
		add.setCountry(request.getParameter("country"));
		add.setMlsId(request.getParameter("mlsId"));
		add.setOffice(request.getParameter("office"));
		add.setPostalcode(Integer.parseInt(request.getParameter("postalcode")));
		List<AddProperty> ll=new ArrayList<AddProperty>();
		ll.add(add);
		objectify.put(ll);
		
		System.out.println("helo");

		//List<AddProperty> property = ofy().load().type(AddProperty.class).now();
		List<AddProperty> addprop = objectify.query(AddProperty.class).list();
		for (AddProperty prop: addprop) {
		    System.out.println(prop.getArea()+" "+prop.getCountry()+" "+prop.getMlsId()+" "+prop.getPostalcode());
		}
		System.out.println("out");
		request.setAttribute("AddPropertylist", addprop);
		request.getRequestDispatcher("index.jsp").forward(request, response);
				
		/*Query<AddProperty> q = objectify.query(AddProperty.class);		
	    String userAgentString="";
	    //q.filter("userAgentString", userAgentString);
	    AddProperty  addprop=q.get();
	    System.out.println(addprop.getArea());
	    System.out.println(userAgentString);
	    request.setAttribute("AddPropertylist", addprop);
	    request.getRequestDispatcher("index.jsp").forward(request, response);
		*/
		/*String roof=request.getParameter("roof");
		String area=request.getParameter("area");
		String mlsId=request.getParameter("mlsId");
		String office=request.getParameter("office");
		String country=request.getParameter("country");
		String postalcode=request.getParameter("postalcode");
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
			
			 //le.add(add);
			 datastore.put(emp);*/
	}
	

}
