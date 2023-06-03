package hr.algebra.jwpproject.service;

import hr.algebra.jwpproject.model.Category;
import hr.algebra.jwpproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category){return categoryRepository.save(category);}

    public void delete(Category category){categoryRepository.delete(category);}

    public List<Category> getAll(){return categoryRepository.findAll();}

    public Category findById(Long id){return categoryRepository.findCategoryById(id);}

    public Category findByName(String name){return categoryRepository.findCategoryByName(name);}
}
