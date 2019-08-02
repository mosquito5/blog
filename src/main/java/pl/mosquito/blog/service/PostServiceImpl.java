package pl.mosquito.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.mosquito.blog.model.posts.Post;
import pl.mosquito.blog.model.posts.PostRepository;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    private final int SIZE = 5;

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

//    public Page<Post> findAllByOrOrderByLocalDateTimeDesc(User user, int page) {
//        return postRepository.findAllByOrOrderByLocalDateTimeDesc(user, PageRequest.of(page, SIZE));
//    }

    @Override
    public Page<Post> findAllByOrderByLocalDateTimeDescPageable(int page) {
        return postRepository.findAllByOrderByLocalDateTimeDesc(PageRequest.of(page, SIZE));
    }

//    public Collection<Post> findAllByOrOrderByLocalDateTimeDesc(int page) {
//        return postRepository.findAllByOrOrderByLocalDateTimeDesc(PageRequest.of(page, SIZE));
//    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }
}
