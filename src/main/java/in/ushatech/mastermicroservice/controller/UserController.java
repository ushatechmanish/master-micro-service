package in.ushatech.mastermicroservice.controller;

import in.ushatech.mastermicroservice.dao.service.UserDaoService;
import in.ushatech.mastermicroservice.domain.User;
import in.ushatech.mastermicroservice.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController
{
    UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }
@GetMapping(path="/users")
public List<User> retrieveAllUsers()
{
    return userDaoService.findAll();
}

    @RequestMapping(method= RequestMethod.GET, path="/users/{id}")
    public User getUser( @PathVariable int id)
    {
        User user = userDaoService.findOne(id);
        if(user==null)
        {
            throw new UserNotFoundException("id:"+id);
        }
        return user;
    }
    @RequestMapping(method= RequestMethod.DELETE, path="/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userDaoService.deleteUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user)
    {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getUserId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
