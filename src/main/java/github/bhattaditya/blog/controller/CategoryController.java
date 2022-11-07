package github.bhattaditya.blog.controller;

import github.bhattaditya.blog.constants.BlogApiConstants;
import github.bhattaditya.blog.constants.BlogConstants;
import github.bhattaditya.blog.dto.requestDto.CategoryRequestDto;
import github.bhattaditya.blog.dto.responseDto.ApiResponse;
import github.bhattaditya.blog.dto.responseDto.CategoryResponseDto;
import github.bhattaditya.blog.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = BlogConstants.BLOG_CATEGORY)
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = BlogApiConstants.CREATE_CATEGORY)
    public ResponseEntity<CategoryResponseDto> addCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        LOGGER.info("Category controller calling Category Service class...");
        CategoryResponseDto categoryResponseDto = categoryService.createCategory(categoryRequestDto);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.CREATED);
    }

    @GetMapping(value = BlogApiConstants.CATEGORY)
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable String categoryId) {
        LOGGER.info("Category controller calling Category Service class...");
        CategoryResponseDto categoryResponseDto = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
    }

    @GetMapping(value = BlogApiConstants.CATEGORIES)
    public ResponseEntity<List<CategoryResponseDto>> getCategories() {
        LOGGER.info("Category controller calling Category Service class...");
        List<CategoryResponseDto> categoryResponseDtos = categoryService.getCategories();
        return new ResponseEntity<>(categoryResponseDtos, HttpStatus.OK);
    }

    @PutMapping(value = BlogApiConstants.UPDATE_CATEGORY)
    public ResponseEntity<CategoryResponseDto> updateCategories(@PathVariable String categoryId, @RequestBody CategoryRequestDto categoryRequestDto) {
        LOGGER.info("Category controller calling Category Service class...");
        CategoryResponseDto categoryResponseDto = categoryService.updateCategory(categoryId, categoryRequestDto);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = BlogApiConstants.REMOVE_CATEGORY)
    public ApiResponse deleteCategories(@PathVariable String categoryId) {
        LOGGER.info("Category controller calling Category Service class...");
        categoryService.deleteCategory(categoryId);
        return new ApiResponse("Category deleted Successfully", true);
    }


}
