package PreparationCommande.com.repository;

import org.springframework.data.repository.CrudRepository;

import PreparationCommande.com.dao.DriveDao;
import PreparationCommande.com.model.Drive;

public interface DriveRepository extends CrudRepository<Drive, Long> {

}
