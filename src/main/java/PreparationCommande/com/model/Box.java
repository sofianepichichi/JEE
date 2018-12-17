package PreparationCommande.com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BOX")
public class Box {

	// ATTRIBUTS
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CAPACITY")
	private int capacity;
	
	@OneToMany
	@Column(name="ARTICLES")
	private List<Article> articles;
	
	@Column(name="PRESERVATION")
	private Conservation preservation;

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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Conservation getPreservation() {
		return preservation;
	}

	public void setPreservation(Conservation preservation) {
		this.preservation = preservation;
	}

}
