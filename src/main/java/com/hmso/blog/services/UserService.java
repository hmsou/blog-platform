package com.hmso.blog.services;

import com.hmso.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
