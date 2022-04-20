package hh.swd20.MovieStore.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Store {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	//getters
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getDate() {
		return date;
	}
	
	//setters
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	//konstruktori parametreillä
	public Store(long id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	
	//konstruktori parametritön
	public Store() {
		super();
	}
	
	//toString()
	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
	
	
}
