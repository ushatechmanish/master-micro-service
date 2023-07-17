package in.ushatech.mastermicroservice.controller;

import in.ushatech.mastermicroservice.dao.service.PostDaoService;
import in.ushatech.mastermicroservice.domain.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostJPAController
{
    PostDaoService postDaoService;

    public PostJPAController(PostDaoService postDaoService) {
        this.postDaoService=postDaoService;
    }
@GetMapping(path="/posts")
public List<Post> retrieveAllPosts()
{
    return postDaoService.findAll();
}
//    CREATE a user - POST /users
    @RequestMapping(method= RequestMethod.GET, path="/posts/{id}")
    public Post getUser(@PathVariable int id)
    {
        Optional<Post> post = postDaoService.findOne(id);
        if(post.isPresent())
        {
            return  post.get();
        }
        return null;
    }
    @RequestMapping(method= RequestMethod.DELETE, path="/posts/{id}")
    public void deletePost(@PathVariable int id)
    {
        postDaoService.deletePost(id);
    }


}
