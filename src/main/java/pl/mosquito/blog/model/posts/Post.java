package pl.mosquito.blog.model.posts;

import lombok.Getter;
import lombok.Setter;
import pl.mosquito.blog.model.users.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Getter @Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private long id;

    @NotBlank
    private String content;

    @NotBlank
    private String localDateTime;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Post_Tag",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private Set<Tag> tags;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Post(@NotBlank String content, @NotBlank String localDateTime, Set<Tag> tags, User user) {
        this.content = content;
        this.localDateTime = localDateTime;
        this.tags = tags;
        this.user = user;
    }

    public Post(User user) {
        this.user = user;
    }

    public Post() {

    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + localDateTime +
                ", tags=" + tags +
                ", comments=" + comments +
                ", user=" + user +
                '}';
    }
}
