package hr.algebra.jwpproject.service;

import hr.algebra.jwpproject.model.Cart;
import hr.algebra.jwpproject.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart save(Cart cart){return cartRepository.save(cart);}
    public List<Cart> getAll(){return cartRepository.findAll();}
    public void delete(Cart cart){cartRepository.delete(cart);}
    public Cart findById(Long id){return cartRepository.findCartById(id);}
    public List<Cart> getAllByUserId(Long id){return cartRepository.findCartsByUserId(id);}

    public void deleteAll(){cartRepository.deleteAll();}
}
