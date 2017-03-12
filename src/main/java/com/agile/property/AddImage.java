package com.agile.property;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;

@Entity
public class AddImage {
	@Id
	public Long id;
	String  Image_url;
	Key<AddProperty> property;
	
	public Long getId() {
		return id;
	}
	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}
	public String getImage_url() {
		return Image_url;
	}
	@XmlElement
	public void setImage_url(String image_url) {
		Image_url = image_url;
	}
	public Key<AddProperty> getProperty() {
		return property;
	}
	@XmlElement
	public void setProperty(Key<AddProperty> property) {
		this.property = property;
	}
		

}