import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class UserActionTest {
    //private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String ALPHA_NUMERIC_STRING = "0123456789";

    @Test
    public void must_check_that_file_exist() throws IOException {

        //arrange
        String usersListFile = "C:\\Temp\\Users.txt";
        UserAction userAction = new UserAction(usersListFile);

        //acc


        //assert
        assertTrue("Check that the file exist",userAction.createUserListFile(usersListFile));
    }

    @Test
    public void must_create_a_new_user() throws IOException {

        //arrange
        String usersListFile = "C:\\Temp\\Users.txt";
        String userName = "Javier3";
        UserAction userAction = new UserAction(usersListFile);
        boolean created;

        //act
        created = userAction.createNewUser(usersListFile, userName);

        //assert
        if (created) {
            System.out.println("User Created successfully 1");
        }
        assertTrue("Failed to create User",created);

    }

    @Test
    public void must_return_a_valid_user() throws IOException {

        //arrange
        String usersListFile = "C:\\Temp\\Users.txt";
        String userName = "Javier1";
        UserAction userAction = new UserAction(usersListFile);
        boolean test;

        //act
        test = userAction.checkIfUserExistOrWasCreated(usersListFile, userName);

        //assert
        if (test) {
            System.out.println("User Created or Exist in list");
        }

        assertTrue("Check that the file exist",test);
    }

    @Test
    public void must_return_a_list_of_valid_users() throws IOException {
        //arrange
        String usersListFile = "C:\\Temp\\Users.txt";
        List<String> list;
        UserValidation userValidation = new UserValidation();

        //act
         list = userValidation.generateUsersList("Javier", 14, usersListFile);

        //assert
        assertEquals("Must Generate a list of users",14, list.size());
    }
}
