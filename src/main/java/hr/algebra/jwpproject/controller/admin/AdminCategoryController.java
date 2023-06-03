package hr.algebra.jwpproject.controller.admin;

import hr.algebra.jwpproject.model.Category;
import hr.algebra.jwpproject.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminCategoryController {

    private final CategoryService categoryService;

    public AdminCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/adminCategory")
    public String adminCategoryIndex(Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "adminCategory";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id){
        Category category = categoryService.findById(id);
        categoryService.delete(category);
        return "redirect:/adminCategory";
    }

    @GetMapping("/adminCreateCategory")
    public String adminCreateCategoryIndex(Model model){
        Category category = new Category();
        model.addAttribute("category",category);
        return "adminCreateCategory";
    }
    @PostMapping("/adminCreateCategory")
    public String createCategory(@RequestParam("name") String name){
        Category category = new Category();
        category.setName(name);
        categoryService.save(category);
        return "redirect:/adminCategory";
    }
}
