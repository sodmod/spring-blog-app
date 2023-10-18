package com.badmus.blog.controller;

import com.badmus.blog.dto.BlogDto;
import com.badmus.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class Controller {

    private final BlogService blogService;

    @PostMapping("post/blog")
    @ResponseStatus(CREATED)
    public ResponseEntity<?> postBlog(@RequestBody BlogDto blogDto){
        System.out.println(blogDto.toString());
        return blogService.postBlog(blogDto);
    }

    @PutMapping("update/blog")
    @ResponseStatus(CREATED)
    public ResponseEntity<?> updateBlog(@RequestBody BlogDto blogDto){
        return blogService.updateBlog(blogDto);
    }

    @DeleteMapping("delete/blog")
    @ResponseStatus(CREATED)
    public ResponseEntity<?> deleteBlog(@RequestParam(name = "post-id") String blogId){
        return blogService.delete(blogId);
    }

    @GetMapping("all-post/blog")
    public ResponseEntity<?> allPosts(){
        return blogService.allPosts();
    }

    @GetMapping("get-a-post/blog")
    public ResponseEntity<?> get_a_post(@RequestParam(name = "post-id") String postId){
        return blogService.get_a_post(postId);
    }
}
