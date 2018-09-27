package io.github.leonhover.cms.domain.models;

import java.util.Set;

import lombok.Data;

@Data
public class News {
    String id;
    String title;
    String content;
    User author;
    Set<User> mandatoryReviewers;
    Set<Category> categories;
    Set<Tag> tags;
    Set<Review> reviewers;
}