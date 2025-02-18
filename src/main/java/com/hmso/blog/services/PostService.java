package com.hmso.blog.services;

import com.hmso.blog.domain.entities.Post;
import com.hmso.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> listPosts(UUID categoryId, UUID tagId);
    List<Post> listDraftPosts(User user);
}
