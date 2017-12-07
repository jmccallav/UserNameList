package com.intertec.userNameApp.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserValidation {

    //private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String ALPHA_NUMERIC_STRING = "0123456789";
    private static final int USER_NAME_LENGTH = 15;

    public boolean checkIfUserExist(String filePath, String userToBeChecked) throws IOException {

        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String fileUser = "";
        boolean userFind = false;

        while ((fileUser = bufferedReader.readLine()) != null) {
            if (fileUser.equals(userToBeChecked)) {
                bufferedReader.close();
                return true;
            }
        }
        bufferedReader.close();
        return userFind;
    }

    public static String generateRandomUser(int count, String userName) {
        int userNameSize = count - userName.length();
        count = userNameSize;
        StringBuilder builder = new StringBuilder();
        builder.append(userName);
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }


    public List<String> generateUsersList(String baseUser, int numberOfUsers, String filePath) throws IOException {
        List<String> list = new ArrayList<String>();
        String userGenerated;

        while (numberOfUsers-- != 0) {
            userGenerated = generateRandomUser(USER_NAME_LENGTH, baseUser);
            if(!checkIfUserExist(filePath, userGenerated)){
                list.add(userGenerated);
            } else {
                numberOfUsers++;
            }

        }
        Collections.sort(list);
        return list ;
    }

    public boolean checkUserLength(String userToBeValidated) {
        if(userToBeValidated.length() < 6 || userToBeValidated == null ){
            return false;
        } else {
            return true;
        }

    }
}
