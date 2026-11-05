
package com.example.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.BlogMapper;

@Service
public class BlogService {

    private final BlogMapper blogMapper;

    // コンストラクタインジェクション
    public BlogService(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    // ブログ一覧取得
    public List<Blog> list() {
        return blogMapper.findAll();
    }
}
