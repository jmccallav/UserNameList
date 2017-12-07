import java.io.*;
import java.util.List;

public class UserAction  implements IUserAction {

    public UserAction(String usersListFile) {}

//    public UserAction(String userName, String usersList) {
//    }

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

                    boolean userExist = checkIfUserExistOrWasCreated(filePath, newUser);

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

    public boolean checkIfUserExistOrWasCreated(String filePath, String userToBeChecked) throws IOException {

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
