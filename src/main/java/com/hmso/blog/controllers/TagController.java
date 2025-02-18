package com.hmso.blog.controllers;

import com.hmso.blog.domain.dtos.TagDto;
import com.hmso.blog.domain.entities.Tag;
import com.hmso.blog.mappers.TagMapper;
import com.hmso.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
