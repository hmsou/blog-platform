package com.hmso.blog.controllers;

import com.hmso.blog.domain.dtos.CreateTagRequest;
import com.hmso.blog.domain.dtos.TagDto;
import com.hmso.blog.domain.entities.Tag;
import com.hmso.blog.mappers.TagMapper;
import com.hmso.blog.services.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagDto>> listTags(){
        List<TagDto> tags = tagService.listTags()
                .stream().map(tagMapper::toDto)
                .toList();

        return ResponseEntity.ok(tags);
    }

    @PostMapping
    public ResponseEntity<List<TagDto>> createTag(
            @Valid @RequestBody CreateTagRequest createTagRequest){

        List<Tag> savedTags = tagService.createTag(createTagRequest.getNames());
        List<TagDto> createdTagDtos = savedTags.stream().map(tagMapper::toDto).toList();

        return new ResponseEntity<>(
                createdTagDtos,
                HttpStatus.CREATED
        );
    }

}
