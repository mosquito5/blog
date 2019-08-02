package pl.mosquito.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mosquito.blog.model.users.User;
import pl.mosquito.blog.model.users.UserRepository;
import pl.mosquito.blog.model.users.UserRole;
import pl.mosquito.blog.security.PassGen;

@Service
public class UserServiceImpl implements UserService {
    private static final String DEFAULT_ROLE = "ROLE_USER";
    private static final String ADMIN_ROLE = "ROLE_ADMIN";

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void addWithDefaultRole(User user) {
        addWithRole(user, DEFAULT_ROLE);
    }

    @Override
    public void addWithAdminRole(User user) {
        addWithRole(user, ADMIN_ROLE);
    }

    private void addWithRole(User user, String role) {
        UserRole userRole = new UserRole(role);
        user.getUserRoles().add(userRole);
        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        userRepository.save(user);
    }

    @Override
    public String resetPassword(User user) {
        String pass = PassGen.getPass();
        String passwordHash = passwordEncoder.encode(pass);
        user.setPassword(passwordHash);
        userRepository.save(user);

        return pass;
    }

    @Override
    public void changePassowrd(User user, String pass) {
        String passwordHash = passwordEncoder.encode(pass);
        user.setPassword(passwordHash);
        userRepository.save(user);
    }

}
