package io.github.leonhover.cms.domain.vo;

import java.util.Set;

import io.github.leonhover.cms.domain.models.Category;
import io.github.leonhover.cms.domain.models.Tag;

/**
 * NewsRequest
 */
public class NewsRequest {

    String title;
    String content;
    Set<Category> categories;
    Set<Tag> tags;

}