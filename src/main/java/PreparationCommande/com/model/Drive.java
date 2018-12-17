package PreparationCommande.com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Class d'init de l'objet Drive
 */
@Entity
@Table(name="DRIVE")
public class Drive implements Serializable  {

	
	// ATTRIBUTS
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@OneToMany
	@Column(name="EMPLOYES")
	private List<Employee> employes;
	
	@OneToMany
	@Column(name="COMMANDES")
	private List<Order> commandes;
	
	
	// METHODES
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Employee> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employee> employes) {
		this.employes = employes;
	}

	public List<Order> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Order> commandes) {
		this.commandes = commandes;
	}
}
