package com.example.todo.Service;
 import com.example.todo.ApiResponse.ApiException;
 import com.example.todo.Model.MyUser;
 import com.example.todo.Repository.AuthRepository;
 import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDeletesService implements UserDetailsService {

    private final AuthRepository authRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myuser = authRepository.findByUsername(username);
        if(myuser == null){
            throw new ApiException("Wrong username or password");
        }
        return myuser;
    }
}
