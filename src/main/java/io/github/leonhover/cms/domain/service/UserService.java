package io.github.leonhover.cms.domain.service;

import java.util.UUID;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.leonhover.cms.domain.repository.UserRepository;
import io.github.leonhover.cms.domain.vo.UserRequest;
import io.github.leonhover.cms.domain.models.User;

/**
 * UserService
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User update(String id, UserRequest userRequest) {
        final User user = this.userRepository.findOne(id);
        user.setIdentify(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        return this.userRepository.save(user);
    }

    public User create(UserRequest userRequest) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setIdentify(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        return this.userRepository.save(user);
    }

    public void delete(String id) {
        final User user = this.userRepository.findOne(id);
        this.userRepository.delete(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findOne(String id) {
        return this.userRepository.findOne(id);
    }
}