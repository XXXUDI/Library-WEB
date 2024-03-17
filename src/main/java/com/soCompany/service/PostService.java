package com.soCompany.service;

import com.soCompany.dto.BookManagementDto;
import com.soCompany.dto.PostReadDto;
import com.soCompany.mapper.PostManagementMapper;
import com.soCompany.mapper.PostReadMapper;
import com.soCompany.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostReadMapper postReadMapper;
    private final PostManagementMapper postManagementMapper;

    public List<PostReadDto> findAll() {
        return postRepository.findAll().stream().map(postReadMapper::map).toList();
    }

    public Optional<PostReadDto> findById(Long id) {
        return postRepository.findById(id).map(postReadMapper::map);
    }

    public PostReadDto create(BookManagementDto dto) {
        return Optional.of(dto)
                .map(bookDto -> {
                    return postManagementMapper.map(bookDto);
                })
                .map(postRepository::save)
                .map(postReadMapper::map)
                .orElseThrow();
    }

    public Optional<PostReadDto> update(Long id, BookManagementDto dto) {
        return postRepository.findById(id)
                .map(book -> {
                    return postManagementMapper.map(dto, book);
                })
                .map(postRepository::saveAndFlush)
                .map(postReadMapper::map);
    }

    public boolean delete(Long id) {
        return postRepository.findById(id)
                .map(book -> {
                    postRepository.delete(book);
                    postRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
