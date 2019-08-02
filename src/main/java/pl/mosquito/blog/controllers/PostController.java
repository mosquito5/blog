package pl.mosquito.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.mosquito.blog.util.TagsFinder;
import pl.mosquito.blog.model.DataTransferObjects.PostDTO;
import pl.mosquito.blog.model.posts.Post;
import pl.mosquito.blog.model.posts.PostRepository;
import pl.mosquito.blog.model.posts.Tag;
import pl.mosquito.blog.model.users.User;
import pl.mosquito.blog.model.users.UserRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    private DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");

    private TagsFinder tagsFinder = new TagsFinder();

    @GetMapping("/addPost")
    public String newPost(Model model, Principal principal) {

        Optional <User> user = userRepository.findByName(principal.getName());

        if(user.isPresent()) {
            PostDTO postDTO = new PostDTO(user.get());
            model.addAttribute("postDTO", postDTO);
            return "/postForm";
        }
        else
            return "/error";
    }

    @PostMapping("/addPost")
    public String addNewPost(@Valid PostDTO postDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "/postForm";
        }
        else {
            String content = postDTO.getContent();
            LocalDateTime localDateTime = LocalDateTime.now();
            tagsFinder.setStr(content);
            Set<Tag> tags = tagsFinder.getTags();
            Post post = new Post(content, europeanDateFormatter.format(localDateTime), tags, postDTO.getUser());
            postRepository.save(post);

            return "redirect:/showPost/" + post.getUser().getId();
        }
    }

    @GetMapping("/showPost/{postId}")
    public String showPost(@PathVariable Long postId, Model model) {
        Optional<Post> postO = postRepository.findById(postId);

        if(postO.isPresent()) {
            Post post = postO.get();
            model.addAttribute("post", post);
            return "/showPost";
        }
        else return "/error";
    }

    @DeleteMapping("/showPost/{postId}")
    public String deletePostById(@PathVariable Long postId, Principal principal) {
        Optional<Post> postO = postRepository.findById(postId);

        if(postO.isPresent()) {
            Post post = postO.get();
            if(isPrincipalOwnerofPost(principal, post)) {
                postRepository.delete(post);
                return "redirect:/home";
            }
            else
                return "/403";

        }
        else
            return "/error";
    }

    @GetMapping("/editPost/{postId}")
    public String editPostId(@PathVariable Long postId, Model model, Principal principal) {
        Optional<Post> postO = postRepository.findById(postId);

        if(postO.isPresent()) {
            Post post = postO.get();
            if (isPrincipalOwnerofPost(principal, post)) {
                model.addAttribute("post", post);
                return "/postForm";
            }
            else
                return "/403";
        }
        else
            return "/error";
    }

    private boolean isPrincipalOwnerofPost(Principal principal, Post post) {
        return principal != null && principal.getName().equals(post.getUser().getName());
    }
}
