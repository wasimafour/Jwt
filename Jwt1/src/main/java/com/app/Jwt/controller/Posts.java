package com.app.Jwt.controller;

import com.app.Jwt.repository.PostsRepository;
import com.app.Jwt.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class Posts {

    private final PostsService postsService;

    private final PostsRepository postsRepository;


    int batchSize = 100;
    int totalObjects =1000;
    @GetMapping("/savePost")
    public String  savePosts() {
        com.app.Jwt.model.Posts posts;
        List<com.app.Jwt.model.Posts> postsList = new ArrayList<>();
        for(int i=1; i<=10000;i++){
            posts = new com.app.Jwt.model.Posts();
            posts.setTitle("title"+i);
            postsList.add(posts);
            
            //postsRepository.save(posts);
        }
        postsRepository.saveAll(postsList);
        return "Success";

    }
}
