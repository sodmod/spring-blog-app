package com.badmus.blog.service;

import com.badmus.blog.dto.BlogDto;
import com.badmus.blog.model.Blog;
import com.badmus.blog.repository.BlogRepo2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepo2 blogRepo2;


    public ResponseEntity<?> postBlog(BlogDto blogDto) {

        blogRepo2.save(Blog.builder()
                .uniqueId(UUID.randomUUID().toString())
                .title(blogDto.getTitle())
                .description(blogDto.getDescription())
                .url(blogDto.getUrl())
                .dateCreated(new Date())
                .build()
        );

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> updateBlog(BlogDto blogDto) {
        Blog blog = blogRepo2.findByUniqueId(blogDto.getId());
        blog.setTitle(blogDto.getTitle());
        blog.setDescription(blogDto.getDescription());
        blog.setDateCreated(new Date());
        blog.setUrl(blogDto.getUrl());

        blogRepo2.save(blog);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> delete(String blogId) {
        if (blogRepo2.existsByUniqueId(blogId)) {
            Blog blog = blogRepo2.findByUniqueId(blogId);
            blogRepo2.delete(blog);
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.notFound().build();

    }

    public ResponseEntity<?> allPosts() {
        System.out.println(blogRepo2.findAll());
        return ResponseEntity.ok(blogRepo2.findAll());
    }

    public ResponseEntity<?> get_a_post(String postId) {
        System.out.println(postId);
        if (blogRepo2.existsByUniqueId(postId)) {
            return ResponseEntity.ok(blogRepo2.findByUniqueId(postId));
        } else {
            System.out.println("Na waoooo");
            return ResponseEntity.status(900).build();
        }
    }
}
