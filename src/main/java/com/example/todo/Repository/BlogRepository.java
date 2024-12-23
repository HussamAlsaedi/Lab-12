package com.example.todo.Repository;

import com.example.todo.Model.Blog;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {


    Blog findBlogById(Integer blogId);

    Blog findBlogByTitle(String title);

    List<Blog> findBlogByMyUserId(Integer myUserId);
}
