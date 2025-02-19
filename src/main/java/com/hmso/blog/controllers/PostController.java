package com.hmso.blog.controllers;

import com.hmso.blog.domain.CreatePostRequest;
import com.hmso.blog.domain.dtos.CreatePostRequestDto;
import com.hmso.blog.domain.dtos.PostDto;
import com.hmso.blog.domain.entities.Post;
import com.hmso.blog.domain.entities.User;
import com.hmso.blog.mappers.PostMapper;
import com.hmso.blog.services.PostService;
import com.hmso.blog.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<PostDto>> listPosts(
            @RequestParam(required = false) UUID categoryId,
            @RequestParam(required = false) UUID tagId){

        List<Post> posts = postService.listPosts(categoryId, tagId);
        List<PostDto> postDtos = posts.stream().map(postMapper::toDto).toList();
        return ResponseEntity.ok(postDtos);
    }

    @GetMapping(path = "/drafts")
    public ResponseEntity<List<PostDto>> ListDrafts(@RequestAttribute UUID userId){
        User user = userService.getUserById(userId);
        List<Post> draftPosts = postService.listDraftPosts(user);
        List<PostDto> draftDtos = draftPosts.stream().map(postMapper::toDto).toList();

        return ResponseEntity.ok(draftDtos);
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @Valid @RequestBody CreatePostRequestDto createPostRequestDto,
            @RequestAttribute UUID userId){
        User user = userService.getUserById(userId);
        CreatePostRequest createPostRequest = postMapper.toCreatePostRequest(createPostRequestDto);
        Post createPost = postService.createPost(user, createPostRequest);
        PostDto createdPostDto = postMapper.toDto(createPost);

        return new ResponseEntity<>(createdPostDto, HttpStatus.CREATED);

    }
}
