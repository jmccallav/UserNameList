package com.intertec.userNameApp.Service;

import java.io.*;
import java.util.List;

public class UserAction  implements IUserAction {

    public UserAction(String usersListFile) {}

    public boolean createUsersFile(String filePath) {
        try {
            if (createUserListFile(filePath)) {
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean createNewUser(String filePath, String newUser) {
        UserValidation userValidation = new UserValidation();

        try {
            if (userValidation.checkUserLength(newUser)) {
                if (createUserListFile(filePath)) {

                    boolean userExist = userValidation.checkIfUserExist(filePath, newUser);

                    if (!userExist) {
                        FileWriter writer = new FileWriter(filePath, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(writer);

                        bufferedWriter.append(newUser);
                        bufferedWriter.newLine();

                        bufferedWriter.close();
                    }
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean createUserListFile(String filePath) throws IOException {
        //TODO
        //Done this way in case you wish to add an alert or warning
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return true;
            } else {
                file.createNewFile();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
