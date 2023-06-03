package hr.algebra.jwpproject.controller.admin;

import hr.algebra.jwpproject.model.Article;
import hr.algebra.jwpproject.model.Category;
import hr.algebra.jwpproject.service.ArticleService;
import hr.algebra.jwpproject.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminArticleController {

    private final ArticleService articleService;
    private final CategoryService categoryService;

    public AdminArticleController(ArticleService articleService, CategoryService categoryService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
    }

    @GetMapping("/adminArticle")
    public String adminArticleIndex(Model model){
        model.addAttribute("articles", articleService.getAll());
        return "adminArticle";
    }

    @GetMapping("/deleteArticle/{id}")
    public String deleteCategory(@PathVariable Long id){
        Article article = articleService.findById(id);
        articleService.delete(article);
        return "redirect:/adminArticle";
    }

    @GetMapping("/adminCreateArticle")
    public String adminCreateCategoryIndex(Model model){
        Article article = new Article();
        List<Category> categories = categoryService.getAll();
        List<String> categoryString = new ArrayList<>();
        for (Category category :
              categories) {
            categoryString.add(category.getName());
        }
        model.addAttribute("article",article);
        model.addAttribute("categories",categoryString);
        return "adminCreateArticle";
    }
    @PostMapping("/adminCreateArticle")
    public String createCategory(@RequestParam("name") String name,@RequestParam("category") String category,@RequestParam("price")Double price){
        Article article = new Article();
        article.setName(name);
        article.setPrice(price);
        Category newCategory = categoryService.findByName(category);
        article.setCategory(newCategory);
        articleService.save(article);
        return "redirect:/adminArticle";
    }

}
