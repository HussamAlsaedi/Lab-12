package com.example.todo.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Title is mandatory")
    @Size(min = 2, message = "Title must be more than 2 characters")
    private String title;

   @NotBlank(message = "Body is mandatory")
    @Size(min = 5, message = "Body must be more than 5 characters")
    private String body;

   @ManyToOne
    @JsonIgnore
    private MyUser myUser;

}
