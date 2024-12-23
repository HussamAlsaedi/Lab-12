package com.example.todo.Service;

 import com.example.todo.Model.MyUser;
 import com.example.todo.Repository.AuthRepository;
 import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public void adduser(MyUser myuser) {

        myuser.setRole("USER");
        String hash = new BCryptPasswordEncoder().encode(myuser.getPassword());
        myuser.setPassword(hash);
        authRepository.save(myuser);

    }


}
