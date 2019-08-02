package pl.mosquito.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mosquito.blog.model.users.User;
import pl.mosquito.blog.model.users.UserRepository;
import pl.mosquito.blog.model.users.UserRole;
import pl.mosquito.blog.security.PassGen;

public interface UserService {

    void addWithDefaultRole(User user);

    void addWithAdminRole(User user);

    String resetPassword(User user);


     void changePassowrd(User user, String pass);
}
