package com.hmso.blog.services.impl;

import com.hmso.blog.domain.entities.Tag;
import com.hmso.blog.repositories.TagRepository;
import com.hmso.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> listTags() {
        return tagRepository.findAllWithPostCount();
    }
}
