package repository;
import org.springframework.data.repository.CrudRepository;

import com.dmurphy.entities.WishList;

public interface WishListRepo extends CrudRepository<WishList, Long> {
	WishList findWishListById(long id);
	WishList findWishListByName(String name);
}
