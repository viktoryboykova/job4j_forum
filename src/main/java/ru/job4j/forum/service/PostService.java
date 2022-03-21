package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private static final AtomicInteger POST_ID = new AtomicInteger(0);

    public PostService() {
        Post post = new Post();
        post.setId(POST_ID.incrementAndGet());
        post.setName("Продаю машину ладу 01.");
        posts.add(post);
    }

    public void savePost(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
            posts.add(post);
        } else {
            posts.set(post.getId() - 1, post);
        }
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPostById(int id) {
        return posts.get(id - 1);
    }
}
