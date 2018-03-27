package training.cdlibrary;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Album {
	@Id 
	long id;
	
	String name;
	
	int year;
	
	String type;
	
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Album(long id, String name, int year, String type) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
