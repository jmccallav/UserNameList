package com.intertec.userNameApp.controller;

import com.intertec.userNameApp.Service.IUserAction;
import com.intertec.userNameApp.Service.UserAction;
import com.intertec.userNameApp.Service.UserValidation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController

public class UserNameController {
    private static final String USER_LIST_FILE = "C:\\Temp\\Users.txt";
    private static final int NUMBER_OF_USERS_TO_BE_GENERATED = 14;

    @RequestMapping(value = "/createUsername", method= RequestMethod.POST)
    public boolean createUsername(@RequestBody String username) throws IOException {

       UserAction userAction = new UserAction(username);
       return userAction.createNewUser(USER_LIST_FILE, username);
    }

    @RequestMapping(value = "/checkUsername/{username}", method= RequestMethod.GET)
    public boolean checkIfUserExist(@PathVariable(value="username", required=true) String username) throws IOException {
        UserValidation validation = new UserValidation();
        return validation.checkIfUserExist(USER_LIST_FILE, username);
    }

    @RequestMapping(value = "/getSuggestion/{username}", method= RequestMethod.GET)
    public List<String> getSuggestion(@PathVariable(value="username", required=true) String username) throws IOException {
        UserValidation validation = new UserValidation();
        return validation.generateUsersList(username, NUMBER_OF_USERS_TO_BE_GENERATED, USER_LIST_FILE);
    }
}
