package PreparationCommande.com.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Order {

	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name="DELIVERYDATE")
	private String deliveryDate;
	
	@Column(name="AMOUNT")
	private float amount;
	
	@Column(name="STATUS")
	private Conservation status;
	
	@ManyToMany
	@Column(name="ARTICLES")
	private List<Article> articles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Conservation getStatus() {
		return status;
	}

	public void setStatus(Conservation status) {
		this.status = status;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
