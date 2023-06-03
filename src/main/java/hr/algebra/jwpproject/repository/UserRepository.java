package hr.algebra.jwpproject.repository;


import hr.algebra.jwpproject.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     User findByUsername (String username);
}
