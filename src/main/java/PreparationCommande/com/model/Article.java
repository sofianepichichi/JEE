package PreparationCommande.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ARTICLE")
public class Article {
	
	// ATTRIBUTS
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name="LANE")
	private char lane;
	
	@Column(name="PLACE")
	private int place;
	
	@Column(name="REF")
	private String ref;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PRICE")
	private String price;
	
	@Column(name="PRESERVATION")
	private Conservation preservation;


	
	// METHODES
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public char getLane() {
		return lane;
	}

	public void setLane(char lane) {
		this.lane = lane;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Conservation getPreservation() {
		return preservation;
	}

	public void setPreservation(Conservation preservation) {
		this.preservation = preservation;
	}
	

}
