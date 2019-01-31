package com.rest.springboot.cruddemo.RestController;

import com.rest.springboot.cruddemo.DAO.UserDao;
import com.rest.springboot.cruddemo.Entity.Technology;
import com.rest.springboot.cruddemo.Entity.User;
import com.rest.springboot.cruddemo.Service.TechnologyService;
import com.rest.springboot.cruddemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserService userService;

    @Autowired
    private TechnologyService technologyService;

    @Autowired
    public UserRestController(UserService theUserService) {
        userService=theUserService;
    }

    //List Users
    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    //List user by id
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId){
        User theUser=userService.findById(userId);

        if(theUser == null) {
            throw new RuntimeException("User Id not found "+userId);
        }

        return theUser;

    }

    //Add User
    @PostMapping("/adduser")
    public User addUser(@RequestBody User theUser){
        theUser.setId(0);

        userService.save(theUser);

        return theUser;
    }

    /*private String name;
    private String email;
    private int phone;
    private String city*/

/*    //Modify User
    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable int userId,
                           @Param("name") String name,
                           @Param("email") String email,
                           @Param("phone") int phone,
                           @Param("city") String city){

        User user = userService.findById(userId);

        if (user != null) {

            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
            user.setCity(city);
            //User theUser=userService.findById(userId);

       *//* if(theUser == null) {
            throw new RuntimeException("User Id not found "+userId);
        }*//*

            userService.save(user);
        }

        return user;
    }*/

    //Modify User
    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable int userId,
                           @RequestBody User inputUser){

        User user = userService.findById(userId);

        if (user != null) {

            user.setName(inputUser.getName());
            user.setEmail(inputUser.getEmail());
            user.setPhone(inputUser.getPhone());
            user.setCity(inputUser.getCity());
            //user.setTechnologies(inputUser.getTechnologies());
            //User theUser=userService.findById(userId);

            for (Technology tech : inputUser.getTechnologies()) {
                for (Technology t : user.getTechnologies()) {
                    if (tech.getId() == t.getId()) {
                        t.setName(tech.getName());
                        t.setIsActive(tech.getIsActive());
                    }
                }
            }

       /* if(theUser == null) {
            throw new RuntimeException("User Id not found "+userId);
        }*/

            userService.save(user);
        }

        return user;
    }

    //Delete User
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId){
        User theUser=userService.findById(userId);

        if(theUser == null){
            throw new RuntimeException("User Id not found - "+ userId);
        }

        userService.deleteById(userId);
        return "Deleted user Id - "+userId;
    }

    //Fetch users based on technology
    @GetMapping("/user/fetchusers/{technologyId}")
    public List<User> getUsersByTechnology(@PathVariable int technologyId) {

        Technology technology = technologyService.findById(technologyId);
        return technology.getUsers();
       /*
        List<User> users=userService.findByTechId(technologyId);

        if(users.size() == 0)
            return null;
        else
            return users;*/
    }

    @GetMapping("/getusers")
    public List<User> getusersByPage(){

        return userService.findAllByPage();
    }
}
