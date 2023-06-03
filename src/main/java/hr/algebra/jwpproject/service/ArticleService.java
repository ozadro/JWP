package hr.algebra.jwpproject.service;

import hr.algebra.jwpproject.model.Article;
import hr.algebra.jwpproject.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article save(Article article){return articleRepository.save(article);}

    public void delete(Article article){articleRepository.delete(article);}

    public List<Article> getAll(){return articleRepository.findAll();}

    public Article findById(Long id){return articleRepository.findArticleById(id);}
    public Article findByName(String name){return articleRepository.findArticleByName(name);}
}
