package com.hmso.blog.controllers;

import com.hmso.blog.domain.dtos.PostDto;
import com.hmso.blog.domain.entities.Post;
import com.hmso.blog.mappers.PostMapper;
import com.hmso.blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;

    @GetMapping
    public ResponseEntity<List<PostDto>> listPosts(
            @RequestParam(required = false) UUID categoryId,
            @RequestParam(required = false) UUID tagId){

        List<Post> posts = postService.listPosts(categoryId, tagId);
        List<PostDto> postDtos = posts.stream().map(postMapper::toDto).toList();
        return ResponseEntity.ok(postDtos);
    }
}
