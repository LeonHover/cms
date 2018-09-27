package io.github.leonhover.cms.domain.models;

import lombok.Data;

@Data
public class User {
    String id;
    String name;
    String identify;
    Role role;
}