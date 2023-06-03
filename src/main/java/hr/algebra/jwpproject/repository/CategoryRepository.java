package hr.algebra.jwpproject.repository;

import hr.algebra.jwpproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findCategoryById(Long id);

    Category findCategoryByName(String name);

}
