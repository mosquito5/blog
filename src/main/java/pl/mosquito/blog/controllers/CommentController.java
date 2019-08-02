package pl.mosquito.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.mosquito.blog.model.posts.Comment;
import pl.mosquito.blog.model.posts.CommentRepository;
import pl.mosquito.blog.model.posts.Post;
import pl.mosquito.blog.model.posts.PostRepository;
import pl.mosquito.blog.model.users.User;
import pl.mosquito.blog.model.users.UserRepository;
import pl.mosquito.blog.service.PostService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
public class CommentController {

    @Autowired
    PostService postService;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/addComment")
    public String addComment(@PathVariable Long postId, Model model, Principal principal) {
        Optional<Post> postO = postService.findById(postId);
        Optional<User> userO = userRepository.findByName(principal.getName());


        if(postO.isPresent() && userO.isPresent()) {
            Comment comment = new Comment(userO.get(), postO.get());
            model.addAttribute("model", model);

            return "/commentForm";
        }
        else
            return "/error";
    }

    @PostMapping("/post{postId}/addComment")
    public String addComment(@Valid Comment comment, BindingResult result) {

        if(result.hasErrors()) {
            return "/error";
        }
        else {
            commentRepository.save(comment);
            return "redirect:/showPost/" + comment.getPost().getId();
        }
    }
}
