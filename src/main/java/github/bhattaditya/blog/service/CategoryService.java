package github.bhattaditya.blog.service;

import github.bhattaditya.blog.dto.mapper;
import github.bhattaditya.blog.dto.requestDto.CategoryRequestDto;
import github.bhattaditya.blog.dto.responseDto.CategoryResponseDto;
import github.bhattaditya.blog.exception.ResourceNotFoundException;
import github.bhattaditya.blog.model.Category;
import github.bhattaditya.blog.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        LOGGER.info("In Category Service class... creating category");
        Category category = new Category();
        category.setTitle(categoryRequestDto.getTitle());
        category.setDescription(categoryRequestDto.getDescription());
        categoryRepository.save(category);
        LOGGER.info("Category created");

        return mapper.categoryToCategoryResponse(category);
    }

    @Transactional
    public CategoryResponseDto updateCategory(String categoryId, CategoryRequestDto categoryRequestDto) {
        LOGGER.info("In Category Service class... updating category");
        Category categoryToUpdate = getCategory(categoryId);
        categoryToUpdate.setTitle(categoryRequestDto.getTitle());
        categoryToUpdate.setDescription(categoryRequestDto.getDescription());
        LOGGER.info("Category updated successfully!");

        return mapper.categoryToCategoryResponse(categoryToUpdate);
    }

    public List<CategoryResponseDto> getCategories() {
        LOGGER.info("In Category Service class... fetching categories");
        List<Category> categories = categoryRepository.findAll();

        return mapper.categoryToCategoryResponseDtos(categories);
    }

    public CategoryResponseDto getCategoryById(String categoryId) {
        LOGGER.info("In Category Service class... fetching category");
        Category category = getCategory(categoryId);

        return mapper.categoryToCategoryResponse(category);
    }

    public Category getCategory(String categoryId) {
        return categoryRepository
                .findById(Long.parseLong(categoryId))
                .orElseThrow(() -> new ResourceNotFoundException("Category", "ID", categoryId));
    }

    public void deleteCategory(String categoryId) {
        LOGGER.info("In Category Service class... deleting category");
        Category category = getCategory(categoryId);
        categoryRepository.delete(category);
        LOGGER.info("Deleted category Successfully");
    }
}
