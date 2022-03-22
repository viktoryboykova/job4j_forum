package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;
import ru.job4j.forum.store.AuthorityRepository;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final AuthorityRepository authorityRepository;
    private final UserService userService;

    public RegControl(PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository, UserService userService) {
        this.encoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
        this.userService = userService;
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorityRepository.findByAuthority("ROLE_USER"));
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}
