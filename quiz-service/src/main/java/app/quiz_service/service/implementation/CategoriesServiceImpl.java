package app.quiz_service.service.implementation;

import app.quiz_service.service.CategoriesService;
//import app.quiz_service.entity.Categories;
//import app.quiz_service.repository.CategoriesRepository;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService {

//    private final CategoriesRepository categoriesRepository;
//
//    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
//        this.categoriesRepository = categoriesRepository;
//    }
//
//    @Override
//    @Transactional
//    public Categories createCategory(String name) {
//        Categories category = new Categories();
//        category.setName(name);
//        return categoriesRepository.save(category);
//    }
//
//    @Override
//    @Cacheable(value="categories", key="'all'")
//    public List<Categories> getAllCategories() {
//        return categoriesRepository.findAll();
//    }
//
//    @Override
//    @Cacheable(value="categories", key="'sorted'")
//    public List<Categories> getAllCategoriesSorted() {
//        return categoriesRepository.findAllByOrderByNameAsc();
//    }
//
//    @Override
//    @Cacheable(value = "searchResults", key = "'categories:' + #searchTerm")
//    public List<Categories> searchCategories(String searchTerm) {
//        return categoriesRepository.findByNameContainingIgnoreCase(searchTerm);
//    }
//
//
//    @Override
//    @Cacheable(value = "categories", key = "'withQuestions'")
//    public List<Categories> getCategoriesWithQuestions() {
//        return categoriesRepository.findCategoriesWithQuestions();
//    }
//
//    @Override
//    @Cacheable(value = "categories", key = "#id")
//    public Optional<Categories> getCategoryById(Long id) {
//        return categoriesRepository.findById(id);
//    }
//
//    @Override
//    @Cacheable(value = "categories", key = "#name")
//    public Optional<Categories> getCategoryByName(String name) {
//        return categoriesRepository.findByNameIgnoreCase(name);
//    }
//
//    @Override
//    @Cacheable(value = "categories", key = "#name")
//    public boolean categoryExists(String name) {
//        return categoriesRepository.existsByNameIgnoreCase(name);
//    }
//
//    @Override
//    @Transactional
//    public Categories updateCategory(Long id, String name) {
//        Optional<Categories> optionalCategory = categoriesRepository.findById(id);
//        if (optionalCategory.isPresent()) {
//            Categories category = optionalCategory.get();
//            category.setName(name);
//            return categoriesRepository.save(category);
//        }
//        return null;
//    }
//
//    @Override
//    @Transactional
//    public void deleteCategory(Long id) {
//        categoriesRepository.deleteById(id);
//    }
//
}
