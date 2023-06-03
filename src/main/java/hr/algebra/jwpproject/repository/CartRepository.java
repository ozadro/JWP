package hr.algebra.jwpproject.repository;

import hr.algebra.jwpproject.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    Cart findCartByUserId(Long id);
    Cart findCartById(Long id);
    List<Cart> findCartsByUserId(Long id);

}
