package io.github.leonhover.cms.domain.vo;

import io.github.leonhover.cms.domain.models.Role;
import lombok.Data;

/**
 * UserRequest
 */
@Data
public class UserRequest {
    String identity;
    String name;
    Role role;
}