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

    public Review review(String userId, String status) {
        final Review review = new Review(userId, status);
        this.reviewers.add(review);
        return review;
    }

    public boolean revised() {
        return this.mandatoryReviewers.stream().allMatch(reviewer -> this.reviewers.stream()
                .anyMatch(review -> reviewer.id.equals(review.userId) && "approved".equals(review.status)));
    }
}