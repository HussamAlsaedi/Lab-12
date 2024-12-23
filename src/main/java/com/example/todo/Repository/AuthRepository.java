package com.example.todo.Repository;



import com.example.todo.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<MyUser, Integer> {

    MyUser  findMyUserById(Integer id);
    MyUser findMyUserByUsername(String username);
    MyUser findByUsername(String username);
}
