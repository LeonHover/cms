package io.github.leonhover.cms.domain.models;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "news")
public class News {
    @Id
    String id;
    String title;
    String content;
    User author;
    Set<User> mandatoryReviewers = new HashSet<>();
    Set<Category> categories = new HashSet<>();
    Set<Tag> tags = new HashSet<>();
    Set<Review> reviewers = new HashSet<>();

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