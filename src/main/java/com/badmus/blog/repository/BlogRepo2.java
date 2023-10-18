package com.badmus.blog.repository;

import com.badmus.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo2 extends JpaRepository<Blog, Long> {
    boolean existsByUniqueId(String blogId);

    Blog findByUniqueId(String blogId);
}
