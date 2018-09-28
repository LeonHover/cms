package io.github.leonhover.cms.domain.models;

import lombok.Data;

@Data
public class Review {
    String userId;
    String status;

    public Review() {

    }

    public Review(String userId, String status) {
        this.userId = userId;
        this.status = status;
    }
}