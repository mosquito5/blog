package pl.mosquito.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.mosquito.blog.details.CustomUserDetails;
import pl.mosquito.blog.model.users.User;
import pl.mosquito.blog.model.users.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username).
                orElseThrow(() -> new UsernameNotFoundException( username + " not found"));

        return new CustomUserDetails(user);
    }
}
