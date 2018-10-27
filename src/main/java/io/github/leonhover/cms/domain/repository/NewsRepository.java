package io.github.leonhover.cms.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.leonhover.cms.domain.models.News;

/**
 * NewsRepository
 */
public interface NewsRepository extends MongoRepository<News, String> {

}