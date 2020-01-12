package rc.bootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rc.bootsecurity.db.UserRepository;
import rc.bootsecurity.model.User;

import java.util.List;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicRestApiController {

    @Autowired
    UserRepository userRepository;

    public PublicRestApiController(){}

    //Available to all authenticated users
    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }


    //Available to managers
    @GetMapping("management/report")
    public String test2(){
        return "API Test 2";
    }

    //Available to ROLE_ADMIN
    @GetMapping("admin/users")
    public List<User> users(){
        return userRepository.findAll();
    }

}
