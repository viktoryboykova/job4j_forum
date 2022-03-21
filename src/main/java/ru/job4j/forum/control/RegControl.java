package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final PostService postService;
    private final UserService userService;

    public RegControl(PasswordEncoder passwordEncoder, PostService postService, UserService userService) {
        this.encoder = passwordEncoder;
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(new Authority("ROLE_USER"));
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}
