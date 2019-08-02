package pl.mosquito.blog.model.users;

import lombok.Getter;
import lombok.Setter;
import pl.mosquito.blog.model.posts.Comment;
import pl.mosquito.blog.model.posts.Post;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "Users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private long id;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 4, max = 32)
    private String password;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String email;

    private boolean banned;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    public User(){}

    public User(@NotBlank String name, @NotBlank @Size(min = 4, max = 32) String password, @NotBlank String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
