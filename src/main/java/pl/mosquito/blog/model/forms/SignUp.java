package pl.mosquito.blog.model.forms;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignUp {

    private String name;
    private String email;
    private String password;
    private String password2;

    @Override
    public String toString() {
        return "SignUp{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}
