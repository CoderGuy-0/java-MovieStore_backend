package hh.swd20.MovieStore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String plot, actor, actor2, actor3, actor4, actor5;
	//getters
	public long getId() {
		return id;
	}
	public String getPlot() {
		return plot;
	}
	public String getActor() {
		return actor;
	}
	public String getActor2() {
		return actor2;
	}
	public String getActor3() {
		return actor3;
	}
	public String getActor4() {
		return actor4;
	}
	public String getActor5() {
		return actor5;
	}
	//setters
	public void setId(long id) {
		this.id = id;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}
	public void setActor3(String actor3) {
		this.actor3 = actor3;
	}
	public void setActor4(String actor4) {
		this.actor4 = actor4;
	}
	public void setActor5(String actor5) {
		this.actor5 = actor5;
	}
	//konstruktori parametreillä
	public MovieInfo(String plot, String actor, String actor2, String actor3, String actor4, String actor5) {
		super();
		this.plot = plot;
		this.actor = actor;
		this.actor2 = actor2;
		this.actor3 = actor3;
		this.actor4 = actor4;
		this.actor5 = actor5;
	}
	//konstruktori parametritön
	public MovieInfo() {
		super();
	}
	//toString()
	@Override
	public String toString() {
		return "MovieInfo [id=" + id + ", plot=" + plot + ", actor=" + actor + ", actor2=" + actor2 + ", actor3="
				+ actor3 + ", actor4=" + actor4 + ", actor5=" + actor5 + "]";
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
