package com.hmso.blog.services;

import com.hmso.blog.domain.CreatePostRequest;
import com.hmso.blog.domain.UpdatePostRequest;
import com.hmso.blog.domain.entities.Post;
import com.hmso.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    Post getPost(UUID id);
    List<Post> listPosts(UUID categoryId, UUID tagId);
    List<Post> listDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
}
