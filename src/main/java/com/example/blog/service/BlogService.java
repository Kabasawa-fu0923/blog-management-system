
package com.example.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.BlogMapper;
import com.example.blog.form.BlogForm;

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

    // ブログIDで取得
    public Blog detail(int id) {
        return blogMapper.findById(id);
    }

    // ブログ新規登録
    public void create(BlogForm form) {

        // Entityを生成
        Blog blog = new Blog();

        // FormからEntityに値を詰め直す
        blog.setTitle(form.getTitle());
        blog.setContent(form.getContent());

        // DBに保存
        blogMapper.save(blog);
    }

    // ブログ保存
    public void save(Blog blog) {
        blogMapper.save(blog);
    }
}
