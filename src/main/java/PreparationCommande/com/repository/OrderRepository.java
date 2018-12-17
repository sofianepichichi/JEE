package PreparationCommande.com.repository;

import org.springframework.data.repository.CrudRepository;

import PreparationCommande.com.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long>  {

}
