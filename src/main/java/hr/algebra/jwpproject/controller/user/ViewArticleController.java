package hr.algebra.jwpproject.controller.user;

import hr.algebra.jwpproject.model.Article;
import hr.algebra.jwpproject.model.Cart;
import hr.algebra.jwpproject.service.ArticleService;
import hr.algebra.jwpproject.service.CartService;
import hr.algebra.jwpproject.service.UserService;
import hr.algebra.jwpproject.user.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class ViewArticleController {
    private final ArticleService articleService;
    private final CartService cartService;
    private final UserService userService;

    public ViewArticleController(ArticleService articleService, CartService cartService, UserService userService) {
        this.articleService = articleService;
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping("/viewArticle")
    public String viewArticleIndex(Model model) {
        model.addAttribute("articles", articleService.getAll());
        return "viewArticle";
    }

    @PostMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute("quantity") Integer quantity, ModelMap modelMap) {
        if (modelMap.get("username") != null) {
            Article article = articleService.findById(id);
            Cart cart = new Cart();
            cart.setArticle(article);
            cart.setQuantity(quantity);
            User user = userService.findByUsername(modelMap.get("username").toString());
            cart.setUser(user);
            cartService.save(cart);
            return "redirect:/viewArticle";
        } else {
            return "redirect:/login";
        }
    }
}
