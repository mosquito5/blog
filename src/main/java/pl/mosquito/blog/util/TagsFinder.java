package pl.mosquito.blog.util;

import pl.mosquito.blog.model.posts.Tag;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagsFinder {
    private final Pattern PATTERN = Pattern.compile("#(\\w+)");

    private Optional <Matcher> matcher;

    public TagsFinder(String str) {
        matcher = Optional.of(PATTERN.matcher(str));
    }

    public TagsFinder(){}

    public Set<Tag> getTags() {
        Set<Tag> tags = new HashSet<>();
        if(matcher.isPresent()) {
            while (matcher.get().find())
                tags.add(new Tag(matcher.get().group(1)));
        }

        return tags;
    }

    public void setStr(String str) {
        matcher = Optional.of(PATTERN.matcher(str));
    }

}
