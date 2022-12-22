package com.example.demo;

import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ToDOController {
    @Autowired
    UserService userService;
    @GetMapping("name")
    public String getName(){
        return "This is my get request";
    }
    @PostMapping("signup")
    public  UserResponse createUser(@RequestBody UserDetailsRequestModel userDetails ){
        System.out.println("================================================post=================================");
        UserResponse userResponse = new UserResponse();
        UserdataTransferObject userdataTransferObject = new UserdataTransferObject();
//        System.out.println(userDetails.getFirstName()+" "+userDetails.getLastName());
        BeanUtils.copyProperties(userDetails,userdataTransferObject);
        System.out.println(userdataTransferObject.getFirstName()+" "+userdataTransferObject.getLastName());
        System.out.println("================================================post=================================");
        UserdataTransferObject createUser=userService.createUser(userdataTransferObject);
        BeanUtils.copyProperties(createUser,userResponse);
        return userResponse;

    }

}
