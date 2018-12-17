package PreparationCommande.com.dao.dao;

import PreparationCommande.com.model.Employee;

import java.util.List;

/*
 * Dao du Drive
 */
public interface DriveDao {

	/**
	 * Retrouver un employé du drive
	 * @param id l'id de l'employé
	 * @return l'employé
	 */
	Employee find(Long id) throws DataException;
	
	/**
	 * Retourne tous les employés du drive
	 * @param id l'id du Drive
	 * @return la liste des employés du drive
	 */
	List<Employee> getAllEmployes(Long id) throws DataException;
}
