package com.example.demo;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public UserdataTransferObject createUser(UserdataTransferObject user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);

        UserEntity storedUserDetails= userRepository.save(userEntity);
        UserdataTransferObject returnValue = new UserdataTransferObject();
        BeanUtils.copyProperties(storedUserDetails,returnValue);
        return returnValue;

    }
}
