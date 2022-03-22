package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        postRepository.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post getById(int id) {
        return postRepository.findById(id).orElse(null);
    }
}
