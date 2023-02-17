package com.codingdojo.relationships.models;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 2)
	private String state;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expirationDate;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;
	
	private String expirationDateAsString;
	
	public License() {
		
	}
	
	public License(String state, Date expirationDate) {
		this.state = state;
		this.expirationDate = expirationDate;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getExpirationDateAsString() {
		return expirationDateAsString;
	}

	public void setExpirationDateAsString(String expirationDateAsString) {
		this.expirationDateAsString = expirationDateAsString;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.expirationDate = sdf.parse(expirationDateAsString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	static {
		java.beans.PropertyEditorManager.registerEditor(Date.class, DateEditor.class);
	}
	
	public class DateEditor extends PropertyEditorSupport {
	    public void setAsText(final String text) throws IllegalArgumentException {
	        SimpleDateFormat sdf = new SimpleDateFormat();
	    }
	}
}
