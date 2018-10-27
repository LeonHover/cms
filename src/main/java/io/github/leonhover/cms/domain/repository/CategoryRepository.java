package io.github.leonhover.cms.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.leonhover.cms.domain.models.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
}