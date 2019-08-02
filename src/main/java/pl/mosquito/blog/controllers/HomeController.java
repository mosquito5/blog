package pl.mosquito.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mosquito.blog.model.posts.Comment;
import pl.mosquito.blog.model.posts.Post;
import pl.mosquito.blog.model.posts.PostRepository;
import pl.mosquito.blog.model.users.User;
import pl.mosquito.blog.service.PostService;
import pl.mosquito.blog.util.Pager;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index(@RequestParam(defaultValue = "0") int page, Model model) {

        Page<Post> posts = postService.findAllByOrderByLocalDateTimeDescPageable(page);
        Pager pager = new Pager(posts);

        model.addAttribute("Pager", pager);
        return "index";
    }

//    @GetMapping("/signin")
//    public String signIn(Model model) {
//        model.addAttribute("SignInForm", new User());
//        return "signin";
//    }
//
//    @GetMapping("/singup")
//    public String signUp(Model model) {
//        model.addAttribute("SignUpForm", new User());
//        return "singup";
//    }
//
//    @GetMapping("/addPost")
//    public String addPost(Model model) {
//        model.addAttribute("AddPost", new Post());
//        return "addPostController";
//    }
//
//    @GetMapping("/addComment")
//    public String addComment(Model model) {
//        model.addAttribute("AddComment", new Comment());
//        return "addComment";
//    }
//
//    @GetMapping("/showPosts")
//    public String showPosts() {
//        return "showPosts";
//    }
//
//
//    @GetMapping("/showComments")
//    public String showComments() {
//        return "showComments";
//    }
}
