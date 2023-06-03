package hr.algebra.jwpproject.controller.user;

import hr.algebra.jwpproject.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewCategory {
    private final CategoryService categoryService;

    public ViewCategory(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/viewCategory")
    public String viewCategoryIndex(Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "viewCategory";
    }
}
