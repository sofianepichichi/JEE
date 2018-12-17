package PreparationCommande.com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Définition de l'objet Employée
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {


	// ATTRIBUTS
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	

	@Column(name="NAME")
	private String name;
	
	@OneToMany
	@Column(name="ORDERS")
	private List<Order> orders;
	
	
	// METHODES
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
