package in.ushatech.mastermicroservice.controller;

import in.ushatech.mastermicroservice.dao.service.UserDaoService;
import in.ushatech.mastermicroservice.domain.User;
import in.ushatech.mastermicroservice.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
    public EntityModel<User> getUser(@PathVariable int id)
    {
        User user = userDaoService.findOne(id);
        if(user==null)
        {
            throw new UserNotFoundException("id:"+id);
        }
        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        entityModel.add(link.withRel("all-users"));
        return entityModel;
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
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
