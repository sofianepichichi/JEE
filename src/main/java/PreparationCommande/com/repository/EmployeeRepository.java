package PreparationCommande.com.repository;

import org.springframework.data.repository.CrudRepository;

import PreparationCommande.com.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
