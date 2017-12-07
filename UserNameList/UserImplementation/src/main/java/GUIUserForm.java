import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;

public class GUIUserForm {
    private JTextField userLogin;
    private JPanel panel1;
    private JButton checkUserButton;
    private JList suggestedUsersList;
    private String usersListFile = "C:\\Temp\\Users.txt";
    private List<String> userList;

    public GUIUserForm() {
        checkUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserValidation userValidation = new UserValidation();
                try {
                    if (userValidation.checkIfUserExist(usersListFile, userLogin.getText())) {
                        userList = userValidation.generateUsersList(userLogin.getText(), 14, usersListFile);
                        suggestedUsersList = new JList(userList.toArray());
                        //suggestedUsersList.setModel();
                        suggestedUsersList.setVisible(true);
                        //suggestedUsersList = new JList(userValidation.generateUsersList(userLogin.getText(), 14, usersListFile).toArray());
                        JOptionPane.showMessageDialog(null,"User " + userLogin.getText() + " already exist.");

                    } else {

                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });

        userLogin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (userLogin.getDocument().getLength() >= 5){
                    checkUserButton.setEnabled(true);
                } else {
                    checkUserButton.setEnabled(false);
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("GUIUserForm");
        jFrame.setContentPane(new GUIUserForm().panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

}
