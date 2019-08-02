package pl.mosquito.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.mosquito.blog.model.posts.Post;
import pl.mosquito.blog.model.posts.PostRepository;

import java.util.Optional;

public interface PostService {


    Optional<Post> findById(Long id);

    Page<Post> findAllByOrderByLocalDateTimeDescPageable(int page);

    void delete(Post post);

    void save(Post post);


}
