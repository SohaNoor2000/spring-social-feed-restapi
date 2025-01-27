package com.springboot.restapi.socialmediaUsers;

import com.springboot.restapi.exceptionhandling.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class UsersRestController {

    private UserDaoRepository userDaoService;
    private PostDaoRepository postDaoRepository;

    public UsersRestController(UserDaoRepository userDaoService,PostDaoRepository postDaoRepository){
        this.userDaoService=userDaoService;
        this.postDaoRepository=postDaoRepository;

    }
    @GetMapping(path = "/users")
    public List<Person> getAllUsers(){
      return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<Person> getOneUser(@PathVariable int id){
        Optional<Person> user = userDaoService.findById(id);

        if(user.isEmpty()){
            throw new UserNotFoundException("User not found for id: "+id);
        }
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        return EntityModel.of(user.get()).add(link.withRel("All-Users"));
    }

    @PostMapping (path = "/users")
    public ResponseEntity<Person> addUser(@Valid @RequestBody Person user){

        userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.
                        fromCurrentRequest().
                        path("/{id}").
                        buildAndExpand(user.getId()).
                        toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping (path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
       userDaoService.deleteById(id);
    }

    @GetMapping(path = "/users/{id}/posts")
    public List<Post> getAllPostsOfUser(@PathVariable int id){
        Optional<Person> person =userDaoService.findById(id);

        if(person.isEmpty()){
            throw new UserNotFoundException("User Not Found For Id: "+ id);
        }
        return person.get().getPost();
    }

    @PostMapping(path = "/users/{id}/posts")
    public ResponseEntity<Object> AddPostsOfUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<Person> person =userDaoService.findById(id);

        if(person.isEmpty()){
            throw new UserNotFoundException("User Not Found For Id: "+ id);
        }

        post.setPerson(person.get());
        Post savedPost=postDaoRepository.save(post);

        URI Location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(savedPost.getId())
                .toUri();

       return ResponseEntity.created(Location).build();
    }

    @GetMapping(path = "/users/{id}/posts/{postId}")
    public EntityModel<Post> getOnePostOfUser(@PathVariable int id, @PathVariable int postId){
        Optional<Person> user = userDaoService.findById(id);
        Optional<Post> post = postDaoRepository.findById(postId);

        if(user.isEmpty() || post.isEmpty()){
            throw new UserNotFoundException("User/Post not found for id: "+id);
        }

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllPostsOfUser(id));
        return EntityModel.of(post.get()).add(link.withRel("All-Posts"));
    }


}
