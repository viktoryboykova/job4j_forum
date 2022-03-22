package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {
    private final PostService postService;

    public PostControl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping({"/post"})
    public String index(Model model, @RequestParam(name = "id") Integer id) {
        model.addAttribute("post", postService.getById(id));
        return "post";
    }

    @GetMapping(path = "/create")
    public String create(Model model) {
        return "create";
    }

    @GetMapping(path = "/edit")
    public String edit(Model model, @RequestParam(name = "id") Integer id) {
        model.addAttribute("post", postService.getById(id));
        return "edit";
    }

    @PostMapping(path = "/save")
    public String save(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/";
    }
}
