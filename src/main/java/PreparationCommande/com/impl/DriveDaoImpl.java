package PreparationCommande.com.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import PreparationCommande.com.dao.DataException;
import PreparationCommande.com.dao.DriveDao;
import PreparationCommande.com.model.Drive;
import PreparationCommande.com.model.Employee;

@Component
public class DriveDaoImpl implements DriveDao {

	private EntityManager em;
	private CriteriaBuilder critere;
	
	public DriveDaoImpl(EntityManager em) {
		this.em = em;
		this.critere = em.getCriteriaBuilder();
	}

	
	/**
	 * Retrouver un employé du drive
	 * @param id l'id de l'employé
	 * @return l'employé
	 * @throws DataException 
	 */
	@Override
	public Employee find(Long id) throws DataException {
		Employee exist = em.find(Employee.class, id);
		if(exist != null) {
			CriteriaQuery<Employee> query = this.critere.createQuery(Employee.class);
			Root<Employee> aux = query.from(Employee.class);
			Join<Drive,Employee> employee = aux.join("employes");
			query.select(employee).where(this.critere.equal(employee.get("id"), id));
			Employee res = this.em.createQuery(query).getSingleResult();
			return res;
		} else {
			throw new DataException("Not a valid ID");
		}
	}
	
	/**
	 * Retourne tous les employés du drive
	 * @param id l'id du Drive
	 * @return la liste des employés du drive
	 * @throws DataException 
	 */
	@Override
	public List<Employee> getAllEmployes(Long id) throws DataException {
		Drive exist = em.find(Drive.class, id);
		try {
			if(exist != null) {
				CriteriaQuery<Employee> query = this.critere.createQuery(Employee.class);
				Root<Drive> aux = query.from(Drive.class);
				Join<Drive,Employee> employe = aux.join("employes");
				query.select(employe).where(this.critere.equal(aux.get("id"), id));
				List<Employee> res = this.em.createQuery(query).getResultList();
				return res;
			} else {
				throw new DataException("Not a valid ID");
			}
		} catch (Exception e) {
			throw new DataException("Not a valid ID");
		}
	}
}
