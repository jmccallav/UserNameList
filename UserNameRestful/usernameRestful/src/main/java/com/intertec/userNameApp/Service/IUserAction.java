package com.intertec.userNameApp.Service;

import java.io.IOException;
import java.util.List;

public interface IUserAction {

    boolean createUsersFile(String filePath);
    boolean createUserListFile(String filePath) throws IOException;
    boolean createNewUser(String filePath, String newUser);

}
