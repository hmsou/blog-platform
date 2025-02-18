package com.hmso.blog.services;

import com.hmso.blog.domain.entities.Tag;

import java.util.List;
import java.util.Set;

public interface TagService {
    List<Tag> listTags();
    List<Tag> createTag(Set<String> tagNames);
}
