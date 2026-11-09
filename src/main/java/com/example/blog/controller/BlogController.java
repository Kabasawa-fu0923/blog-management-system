package com.example.blog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.blog.entity.Blog;
import com.example.blog.service.BlogService;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    // ブログ一覧
    @GetMapping
    public String list(Model model) {

        List<Blog> blogs = blogService.list();

        model.addAttribute("blogs", blogs);

        return "blog/list";
    }
}
