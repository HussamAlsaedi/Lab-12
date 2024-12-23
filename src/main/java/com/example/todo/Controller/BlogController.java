package com.example.todo.Controller;


import com.example.todo.ApiResponse.ApiResponse;
import com.example.todo.Model.Blog;
import com.example.todo.Model.MyUser;
import com.example.todo.Repository.BlogRepository;
import com.example.todo.Service.BolgService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BolgService bolgService;

    @GetMapping("/getAllBlogs")
    public ResponseEntity<List<Blog>> getAllBlog() {
        return ResponseEntity.ok(bolgService.getAllBlog());
    }

    @GetMapping("/findBlogByMyUserId/{userId}")
    public ResponseEntity<List<Blog>> findBlogByMyUserId(@AuthenticationPrincipal Integer userId) {
        return ResponseEntity.ok(bolgService.findBlogByMyUserId(userId));
    }


    @GetMapping("/getById/{blogId}")
    public ResponseEntity<Blog> getById(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer blogId) {
         Blog blog = bolgService.getBlogById(myUser.getId(),blogId);
        return ResponseEntity.ok(blog);
    }

    @GetMapping("/getBlogByTitle/{title}")
    public ResponseEntity<Blog> getBlogByTitle(@AuthenticationPrincipal MyUser myUser,@PathVariable String title) {
         Blog blog = bolgService.getBlogByTitle(myUser.getId(),title);
        return ResponseEntity.ok(blog);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> add(@AuthenticationPrincipal MyUser myUser,@RequestBody @Valid Blog addBlog) {
        bolgService.add(myUser.getId(),addBlog);
        return  ResponseEntity.status(200).body(new ApiResponse("Successfully added blog"));

    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update(@AuthenticationPrincipal MyUser myUser,@RequestBody @Valid Blog updatedBlog) {
        bolgService.update(myUser.getId(),updatedBlog);
        return  ResponseEntity.status(200).body(new ApiResponse("Successfully updated blog"));
    }

    @DeleteMapping("/delete/{blogId}")
    public ResponseEntity<ApiResponse> delete(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer blogId) {
        bolgService.delete(myUser.getId(),blogId);
        return  ResponseEntity.status(200).body(new ApiResponse("Successfully deleted blog"));
    }





}
