package ru.job4j.forum.control;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;
import ru.job4j.forum.store.AuthorityRepository;

import java.util.Calendar;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Test
    @WithMockUser
    public void shouldReturnPost() throws Exception {
        Authority authority = new Authority("USER_ROLE");
        authorityRepository.save(authority);
        User user = new User();
        user.setUsername("vika");
        user.setPassword("vika");
        user.setAuthority(authority);
        Post post = Post.of("Продаю машину");
        post.setCreated(Calendar.getInstance());
        userService.save(user);
        postService.save(post);
        this.mockMvc.perform(get("/post").param("id", String.valueOf(post.getId())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }

    @Test
    @WithMockUser
    public void shouldReturnCreate() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("create"));
    }

    @Test
    @WithMockUser
    public void shouldReturnEdit() throws Exception {
        Authority authority = new Authority("USER_ROLE");
        authorityRepository.save(authority);
        User user = new User();
        user.setUsername("vika");
        user.setPassword("vika");
        user.setAuthority(authority);
        Post post = Post.of("Продаю машину");
        post.setCreated(Calendar.getInstance());
        userService.save(user);
        postService.save(post);
        this.mockMvc.perform(get("/edit").param("id", String.valueOf(post.getId())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }
}