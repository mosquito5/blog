package pl.mosquito.blog.util;

import org.springframework.data.domain.Page;
import pl.mosquito.blog.model.posts.Post;

public class Pager {
    private Page<Post> posts;

    public Pager(Page<Post> posts) {
        this.posts = posts;
    }

    public int getSize() {
        return posts.getSize();
    }

    public int getPageIndex() {
        return posts.getNumber() + 1;
    }

    public int getTotalPages() {
        return posts.getTotalPages();
    }

    public long getTotalElements() {
        return posts.getTotalElements();
    }

    public Page<Post> getPosts() {
        return posts;
    }

    public boolean IndexOutOfBounds() {
        return getPageIndex() < 0 || getPageIndex() > getTotalPages();
    }
}
