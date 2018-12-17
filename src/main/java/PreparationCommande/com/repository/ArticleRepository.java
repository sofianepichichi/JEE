package PreparationCommande.com.repository;

import org.hibernate.sql.Select;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import PreparationCommande.com.model.Article;
import PreparationCommande.com.model.Order;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ArticleRepository  extends CrudRepository<Article, Long>  {

 List <Article> findByLane(char lane);


@Query("Select article from  Article article  where article.lane like CONCAT('%',:x,'%') ")
 List<Article> chercherAllee(@Param("x") String mc);
}
