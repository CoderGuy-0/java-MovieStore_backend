package hh.swd20.MovieStore.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String moviename;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@ManyToOne
	@JsonIgnoreProperties("movies")
    @JoinColumn(name = "categoryid")
	private Category category;
	
	//getters
	public long getId() {
		return id;
	}
	public String getMoviename() {
		return moviename;
	}
	public Date getDate() {
		return date;
	}
	public String getdateString() {
		
		String strDate = null;
		
		if (this.date != null) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	        strDate = dateFormat.format(date);
		}
		
        return strDate;
	}
	public Category getCategory() {
		return category;
	}
	
	//setters
	public void setId(long id) {
		this.id = id;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	//konstruktori parametreillä
	public Movie(String moviename, Date date, Category category) {
		super();
		this.moviename = moviename;
		this.date = date;
		this.category = category;
	}
	
	//konstruktori parametritön
	public Movie() {
		super();
	}
	
	//toString()
	@Override
	public String toString() {
		if (this.category != null) 
		return "Movie [id=" + id + ", moviename=" + moviename + ", date=" + date + ", category=" + this.getCategory() + "]";	
		else return "Movie [id=" + id + ", moviename=" + moviename + ", date=" + date + "]";
	}
	
	
	
	
	
}
