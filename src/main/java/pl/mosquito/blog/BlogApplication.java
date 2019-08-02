package pl.mosquito.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.mosquito.blog.model.users.User;
import pl.mosquito.blog.model.users.UserRepository;
import pl.mosquito.blog.security.PassGen;
import pl.mosquito.blog.service.UserService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BlogApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


//    @PostConstruct
//    private void init() {
//        if(userRepository.findByName("Admin").isEmpty()) {
//            System.out.println("ADMIN NOT FOUND, CREATING...");
//            String pass = PassGen.getPass();
//            System.out.println("Admin password: " + pass);
//            User admin = new User("Admin", pass,"admin1@admin.com");
//            userService.addWithAdminRole(admin);
//            System.out.println("DONE");
//        }
//    }
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
