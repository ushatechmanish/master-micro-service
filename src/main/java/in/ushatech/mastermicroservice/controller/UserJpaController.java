package in.ushatech.mastermicroservice.controller;

import in.ushatech.mastermicroservice.dao.service.UserDaoService;
import in.ushatech.mastermicroservice.domain.User;
import in.ushatech.mastermicroservice.exception.UserNotFoundException;
import in.ushatech.mastermicroservice.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaController
{
    UserRepository userRepository;

    public UserJpaController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path="/jpa/users")
public List<User> retrieveAllUsers()
{
    return userRepository.findAll();
}


    @RequestMapping(method= RequestMethod.GET, path="/jpa/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id)
    {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
        {
            throw new UserNotFoundException("id:"+id);
        }
        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    @RequestMapping(method= RequestMethod.DELETE, path="/jpa/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userRepository.deleteById(id);
    }

    @PostMapping("jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user)
    {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getUserId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
