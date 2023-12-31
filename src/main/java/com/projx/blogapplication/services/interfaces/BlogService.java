package com.projx.blogapplication.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.projx.blogapplication.models.entities.Blog;
import com.projx.blogapplication.models.payloads.AddBlogRequest;

import javax.transaction.Transactional;

public interface BlogService {
    Page<Blog> getBlogs(PageRequest pageRequest, boolean includeDeleted);

    Page<Blog> getBlogsByUser(PageRequest pageRequest, Long userId);

    @Transactional
    Blog getBlogBySlug(String slugTitle);

    String addBlog(AddBlogRequest blogRequest);

    @Transactional
    void deleteBlogById(Long blogId);

    Page<Blog> getBlogsWithCategory(PageRequest pageRequest, Long category, boolean includeDeleted);
}
