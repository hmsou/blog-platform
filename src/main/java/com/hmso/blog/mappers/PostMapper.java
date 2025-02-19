package com.hmso.blog.mappers;

import com.hmso.blog.domain.CreatePostRequest;
import com.hmso.blog.domain.dtos.CreatePostRequestDto;
import com.hmso.blog.domain.dtos.PostDto;
import com.hmso.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto createPostRequestDto);
}
