package io.github.leonhover.cms.domain.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.leonhover.cms.domain.models.Category;
import io.github.leonhover.cms.domain.service.CategoryService;
import io.github.leonhover.cms.domain.vo.CategoryRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * CategoryResource
 */
@RestController
@RequestMapping("/api/category")
public class CategoryResource {

    private final CategoryService categoryService;
    private List<Category> categories = new ArrayList<>();

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find category", notes = "Find category by ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Category found"),
            @ApiResponse(code = 404, message = "Category not found"), })
    public ResponseEntity<Category> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new Category());
    }

    @GetMapping
    @ApiOperation(value = "List categories", notes = "List all categories")
    @ApiResponses({ @ApiResponse(code = 200, message = "Categories found"),
            @ApiResponse(code = 404, message = "Categories not found") })
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(this.categories);
    }

    @PostMapping
    @ApiOperation(value = "Create category", notes = "It permits to create a new category")
    @ApiResponses({ @ApiResponse(code = 201, message = "Category created successfully"),
            @ApiResponse(code = 400, message = "Invalide request") })
    public ResponseEntity<Category> newCategory(@RequestBody CategoryRequest category) {

        Category cg = new Category();
        cg.setId(String.valueOf(new Random().nextInt()));
        cg.setName(category.getName());
        
        this.categories.add(cg);

        return new ResponseEntity<>(cg, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove category", notes = "It permits to remove a category")
    @ApiResponses({ @ApiResponse(code = 200, message = "Category removed successfully"),
            @ApiResponse(code = 404, message = "Category not found") })
    public void removeCategory(@PathVariable("id") String id) {

    }

    @PostMapping("/{id}")
    @ApiOperation(value = "Update category", notes = "It permits to update a category")
    @ApiResponses({ @ApiResponse(code = 200, message = "Category update successfully"),
            @ApiResponse(code = 404, message = "Category not found"),
            @ApiResponse(code = 400, message = "Invalid request") })
    public ResponseEntity<Category> updateCategory(@PathVariable("id") String id, CategoryRequest category) {
        return new ResponseEntity<>(new Category(), HttpStatus.OK);
    }

}