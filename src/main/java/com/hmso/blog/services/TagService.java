package com.hmso.blog.services;

import com.hmso.blog.domain.entities.Tag;

import java.util.List;

public interface TagService {
    List<Tag> listTags();
}
