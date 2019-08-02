package pl.mosquito.blog.model.DataTransferObjects;

import lombok.Getter;
import lombok.Setter;
import pl.mosquito.blog.model.users.User;

@Getter @Setter
public class PostDTO {
    String content;
    User user;

    public PostDTO(User user) {
        this.user = user;
    }
}
