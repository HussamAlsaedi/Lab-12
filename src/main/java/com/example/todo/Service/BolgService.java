package com.example.todo.Service;

import com.example.todo.ApiResponse.ApiException;
import com.example.todo.Model.Blog;
import com.example.todo.Model.MyUser;
import com.example.todo.Repository.AuthRepository;
import com.example.todo.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BolgService {

    private final BlogRepository blogRepository;
    private final AuthRepository authRepository;


    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    public List<Blog> findBlogByMyUserId(Integer userId) {

        MyUser myUser = authRepository.findMyUserById(userId);
        if (myUser == null) {
            throw new ApiException("not authorized.");
        }

        return blogRepository.findBlogByMyUserId(userId);
    }

    public Blog getBlogById(Integer userId, Integer blogId) {

        MyUser myUser = authRepository.findMyUserById(userId);
        if (myUser == null) {
            throw new ApiException("not authorized.");
        }
        Blog blog = blogRepository.findBlogById(blogId);
        if (blog == null) {
            throw new ApiException("Blog not found.");
        }
        return blogRepository.findBlogById(blogId);
    }

    public Blog getBlogByTitle(Integer userId, String title) {
        MyUser myUser = authRepository.findMyUserById(userId);
        if (myUser == null) {
            throw new ApiException("not authorized.");
        }
        Blog blog = blogRepository.findBlogByTitle(title);
        if (blog == null) {
            throw new ApiException("Blog not found.");
        }
        return blogRepository.findBlogByTitle(title);
    }

    public void add(Integer userId,Blog blog) {
        MyUser myUser = authRepository.findMyUserById(userId);
        if (myUser == null) {
            throw new ApiException("not authorized.");
        }
        blog.setMyUser(myUser);
        blogRepository.save(blog);
    }

    public void update(Integer userId,Blog blog) {
        System.out.println(blog);
        MyUser myUser = authRepository.findMyUserById(userId);
        if (myUser == null) {
            throw new ApiException("not authorized.");
        }

        Blog blog1 = blogRepository.findBlogById(blog.getId());
        if (blog1 == null) {
            throw new ApiException("Blog not found.");
        }
        blog1.setTitle(blog.getTitle());
        blog1.setBody(blog.getBody());
        blog.setMyUser(myUser);
        blogRepository.save(blog1);
    }

    public void delete(Integer userId,Integer blogId) {
        MyUser myUser = authRepository.findMyUserById(userId);
        if (myUser == null) {
            throw new ApiException("not authorized.");
        }
        Blog blog = blogRepository.findBlogById(blogId);
        if (blog == null) {
            throw new ApiException("Blog not found.");
        }
        blogRepository.delete(blog);
    }










}
