package pl.mosquito.blog.model.forms;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignIn {

    private String name;
    private String password;

    @Override
    public String toString() {
        return "SignIn{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
