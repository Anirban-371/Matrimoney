package com.agile.property;
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.google.appengine.api.datastore.Text;
@XmlRootElement(name = "property")
@Entity
public class AddProperty implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Long id;
	public String house_number;
	public String address_street;
	public String address_city;
	public String address_zip_postal_code;
	public String address_state;
	public String address_country;
	public int area_square_feet;
	public String house_category;
	public String house_type;
	public int property_square_feet;
	public String parameters_square_feet;
	
	public String parameters_lot_size;
	public String contacts_proprietor_name;
	public String contacts_proprietor_role;
	public String map_latitude;
	public String map_longitude;
	public String property_price;
	public String property_currency;
	public String property_listing_type;
	public String property_category;
	public String property_status;
	public String property_type;
	public String property_owner;
	public String property_region;
	public String property_expriry_date;
	
	
	public String getProperty_expriry_date() {
		return property_expriry_date;
	}
	@XmlElement
	public void setProperty_expriry_date(String property_expriry_date) {
		this.property_expriry_date = property_expriry_date;
	}
	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getHouse_number() {
		return house_number;
	}
	@XmlElement
	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}
	public String getAddress_street() {
		return address_street;
	}
	@XmlElement
	public void setAddress_street(String address_street) {
		this.address_street = address_street;
	}
	public String getAddress_city() {
		return address_city;
	}
	@XmlElement
	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}
	public String getAddress_zip_postal_code() {
		return address_zip_postal_code;
	}
	@XmlElement
	public void setAddress_zip_postal_code(String address_zip_postal_code) {
		this.address_zip_postal_code = address_zip_postal_code;
	}
	public String getAddress_country() {
		return address_country;
	}
	@XmlElement
	public void setAddress_country(String address_country) {
		this.address_country = address_country;
	}
	public int getArea_square_feet() {
		return area_square_feet;
	}
	@XmlElement
	public void setArea_square_feet(int area_square_feet) {
		this.area_square_feet = area_square_feet;
	}
	public String getHouse_category() {
		return house_category;
	}
	@XmlElement
	public void setHouse_category(String house_category) {
		this.house_category = house_category;
	}
	public String getHouse_type() {
		return house_type;
	}
	@XmlElement
	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}
	public int getProperty_square_feet() {
		return property_square_feet;
	}
	@XmlElement
	public void setProperty_square_feet(int property_square_feet) {
		this.property_square_feet = property_square_feet;
	}
	public String getParameters_lot_size() {
		return parameters_lot_size;
	}
	@XmlElement
	public void setParameters_lot_size(String parameters_lot_size) {
		this.parameters_lot_size = parameters_lot_size;
	}
	public String getContacts_proprietor_name() {
		return contacts_proprietor_name;
	}
	@XmlElement
	public void setContacts_proprietor_name(String contacts_proprietor_name) {
		this.contacts_proprietor_name = contacts_proprietor_name;
	}
	public String getContacts_proprietor_role() {
		return contacts_proprietor_role;
	}
	@XmlElement
	public void setContacts_proprietor_role(String contacts_proprietor_role) {
		this.contacts_proprietor_role = contacts_proprietor_role;
	}
	public String getMap_latitude() {
		return map_latitude;
	}
	@XmlElement
	public void setMap_latitude(String map_latitude) {
		this.map_latitude = map_latitude;
	}
	public String getMap_longitude() {
		return map_longitude;
	}
	@XmlElement
	public void setMap_longitude(String map_longitude) {
		this.map_longitude = map_longitude;
	}
	public String getProperty_price() {
		return property_price;
	}
	@XmlElement
	public void setProperty_price(String property_price) {
		this.property_price = property_price;
	}
	public String getProperty_currency() {
		return property_currency;
	}
	@XmlElement
	public void setProperty_currency(String property_currency) {
		this.property_currency = property_currency;
	}
	public String getProperty_listing_type() {
		return property_listing_type;
	}
	@XmlElement
	public void setProperty_listing_type(String property_listing_type) {
		this.property_listing_type = property_listing_type;
	}
	public String getProperty_category() {
		return property_category;
	}
	@XmlElement
	public void setProperty_category(String property_category) {
		this.property_category = property_category;
	}
	public String getProperty_status() {
		return property_status;
	}
	@XmlElement
	public void setProperty_status(String property_status) {
		this.property_status = property_status;
	}
	public String getProperty_type() {
		return property_type;
	}
	@XmlElement
	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}
	public String getProperty_owner() {
		return property_owner;
	}
	@XmlElement
	public void setProperty_owner(String property_owner) {
		this.property_owner = property_owner;
	}
	public String getProperty_region() {
		return property_region;
	}
	@XmlElement
	public void setProperty_region(String property_region) {
		this.property_region = property_region;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}		
	public String getParameters_square_feet() {
		return parameters_square_feet;
	}
	@XmlElement
	public void setParameters_square_feet(String parameters_square_feet) {
		this.parameters_square_feet = parameters_square_feet;
	}
	public String getAddress_state() {
		return address_state;
	}
	@XmlElement
	public void setAddress_state(String address_state) {
		this.address_state = address_state;
	}
	public AddProperty() {
		super();
	}
	public AddProperty(Long id, String house_number, String address_street,
			String address_city, String address_zip_postal_code,
			String address_state, String address_country, int area_square_feet,
			String house_category, String house_type, int property_square_feet,
			String parameters_square_feet, String parameters_lot_size,
			String contacts_proprietor_name, String contacts_proprietor_role,
			String map_latitude, String map_longitude, String property_price,
			String property_currency, String property_listing_type,
			String property_category, String property_status,
			String property_type, String property_owner,
			String property_region) {
		super();
		this.id = id;
		this.house_number = house_number;
		this.address_street = address_street;
		this.address_city = address_city;
		this.address_zip_postal_code = address_zip_postal_code;
		this.address_state = address_state;
		this.address_country = address_country;
		this.area_square_feet = area_square_feet;
		this.house_category = house_category;
		this.house_type = house_type;
		this.property_square_feet = property_square_feet;
		this.parameters_square_feet = parameters_square_feet;
		this.parameters_lot_size = parameters_lot_size;
		this.contacts_proprietor_name = contacts_proprietor_name;
		this.contacts_proprietor_role = contacts_proprietor_role;
		this.map_latitude = map_latitude;
		this.map_longitude = map_longitude;
		this.property_price = property_price;
		this.property_currency = property_currency;
		this.property_listing_type = property_listing_type;
		this.property_category = property_category;
		this.property_status = property_status;
		this.property_type = property_type;
		this.property_owner = property_owner;
		this.property_region = property_region;

	}
	
	}
