package com.hashandk90.restCruds.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="todo")
//@JsonIgnoreProperties(value= {"createdAt"}, allowGetters=true)
public class Todo {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotBlank
	@Size(max=100)
	private String title;
	
	private Boolean completed=false;
	
	private Date createdAt = new Date();
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}	

	public Todo(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
    public String toString() {
        return String.format(
                "Todo[id=%s, title='%s', completed='%s']",
                id, title, completed);
    }
}
