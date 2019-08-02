package pl.mosquito.blog.model.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosquito.blog.model.users.User;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);
//    Page<Post> findAllByOrOrderByLocalDateTimeDesc(User user, Pageable pageable);
    Page<Post> findAllByOrderByLocalDateTimeDesc(Pageable page);
//    Collection<Post> findAllByOrOrderByLocalDateTimeDesc(Pageable page);
}
