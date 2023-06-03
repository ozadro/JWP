package hr.algebra.jwpproject.repository;

import hr.algebra.jwpproject.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory,Long> {

}
