package Launchcode.project.PointOfSale.models.data;

import Launchcode.project.PointOfSale.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface UserDao extends CrudRepository<Item, Integer>{
}
