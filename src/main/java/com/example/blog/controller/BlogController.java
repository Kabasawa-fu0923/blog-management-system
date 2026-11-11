
package com.example.blog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    // ブログ作成画面
    @GetMapping("/new")
    public String create(Model model) {

        model.addAttribute("blog", new Blog());

        return "blog/form";
    }

    // ブログ保存
    @PostMapping
    public String create(Blog blog) {

        blogService.save(blog);

        return "redirect:/blogs";
    }

    // ブログ詳細
    @GetMapping("/{id}")
    public String detail(@PathVariable int id, Model model) {

        Blog blog = blogService.findById(id);

        model.addAttribute("blog", blog);

        return "blog/detail";
    }
}
