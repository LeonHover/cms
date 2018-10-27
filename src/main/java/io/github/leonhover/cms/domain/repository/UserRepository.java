package io.github.leonhover.cms.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.leonhover.cms.domain.models.User;

public interface UserRepository extends MongoRepository<User, String> {
}