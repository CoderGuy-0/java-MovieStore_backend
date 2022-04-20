package hh.swd20.MovieStore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnoreProperties("category")
	private List<Movie> movies;
	
	//getters
	public long getCategoryid() {
		return categoryid;
	}

	public String getName() {
		return name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	//setters
	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	//konstruktorit parametreillä
	public Category(long categoryid, String name) {
		super();
		this.categoryid = categoryid;
		this.name = name;
	}
	
	//konstruktori parametritön
	public Category() {
		super();
	}

	//toString
	@Override
	public String toString() {
		
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}
	
	
	
	
	
}
