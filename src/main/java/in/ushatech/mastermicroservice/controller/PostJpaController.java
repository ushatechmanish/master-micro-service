package in.ushatech.mastermicroservice.controller;

import in.ushatech.mastermicroservice.domain.Post;
import in.ushatech.mastermicroservice.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostJpaController {
    PostRepository postRepository;

    public PostJpaController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
