package hr.algebra.jwpproject.repository;

import hr.algebra.jwpproject.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    Article findArticleById(Long id);
    Article findArticleByName(String name);
}
