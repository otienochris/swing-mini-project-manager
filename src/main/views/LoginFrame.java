package main.views;

//package com.example.carrental.frames;

//import com.example.carrental.MiniProjectManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import main.MiniProjectManagementSystem;
import main.WelcomeFrame;

/**
 *
 * @author 
 */
public class LoginFrame extends JFrame implements ActionListener {
    
    private static final Logger logger = Logger.getLogger(LoginFrame.class.getName());
    
    JLabel usernameLabel, passwordLabel;
    JTextField usernameTxt;
    JPasswordField passwordTxt;
    JButton submitButton;
    
    public LoginFrame() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("");
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        
        JButton backBtn = new JButton("<<");
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(new Font("monospaced", Font.BOLD, 20));
        backBtn.setFocusable(false);
        backBtn.setBounds(5,5,60,40);
        backBtn.addActionListener(event -> {
            this.dispose();
            new WelcomeFrame();
            
        });
        this.add(backBtn);
        
        JLabel error = new JLabel();
        error.setBounds(170,60,500,20);
        error.setForeground(Color.red);
        this.add(error);
        
        JLabel welcome = new JLabel("Login");
        welcome.setBounds(210,5,250,40);
        welcome.setFont(new Font("monospaced", Font.BOLD, 26));
        this.add(welcome);
        
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(170,100,100,25);
        this.add(usernameLabel);
        
        usernameTxt = new JTextField(20);
        usernameTxt.setFont(new Font("monospaced", Font.BOLD, 17));
        usernameTxt.setBounds(170,130,200,30);
        this.add(usernameTxt);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(170,180,100,25);
        this.add(passwordLabel);
        
        passwordTxt = new JPasswordField(20);
        passwordTxt.setFont(new Font("monospaced", Font.BOLD, 17));
        passwordTxt.setBounds(170,210,200,30);
        this.add(passwordTxt);
        
        submitButton = new JButton();
        submitButton.setBackground(Color.ORANGE);
        submitButton.setForeground(Color.BLACK);
        submitButton.setFocusable(false);
        submitButton.setText("Submit");
        submitButton.setFont(new Font("monospaced", Font.BOLD, 20));
        submitButton.setBounds(170,270,200,40);
        this.add(submitButton);
        
        submitButton.addActionListener(event -> {
            error.setText("");
            error.setForeground(Color.red);
            String username = usernameTxt.getText();
            String password = passwordTxt.getText();
            if(username.isEmpty() && password.isEmpty() ) {
                error.setText("Username and password are required to login");
            } else if(username.isEmpty()){
                error.setText("Username is required to login");
            } else if(password.isEmpty()){
                error.setText("Password is required to login");
            }
            
            Boolean isValidUser = areCredentialsValid(username, password);
            if (isValidUser) {
                error.setText("Logged in successfully");
                error.setForeground(Color.blue);
                this.dispose();
                
                switch(MiniProjectManagementSystem.loggedInUserRole) {
                    case "A":
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                new AdminMainFrame().setVisible(true);
                            }
                        });
                        break;
                    case "L":
                        new StudentLecturerMainFrame().setVisible(true);
                        break;
                    case "S":
                        new StudentLecturerMainFrame().setVisible(true);
                        break;
                    default:
                        // TODO
                        break;
                        
                }
            } else {
                error.setText("Invalid credentials");
                logger.severe("Invalid Credentials. User provided wrong username and password");
            }
            
        });
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
    }
    
    
    /**
     * This method validates user credentials
     * 
     * @author
     * 
     * @param username - a user's account username
     * @param password - a user's account password
     * 
     * @return true if the credentials are valid
     * 
     */
    public static boolean areCredentialsValid(String username, String password) {
        boolean[] response = {false};
        String [] userDetails =  new String[3];
        List<String> dataFromDb = MiniProjectManagementSystem.getData(MiniProjectManagementSystem.USER_TXT_FILE);
                
        dataFromDb.forEach(user -> {
            String delimiter = MiniProjectManagementSystem.FILE_DELIMITER;
            String[] data = user.split(delimiter);
            System.out.println("Delimiter : " + delimiter);
            System.out.println(Arrays.toString(data));
            if (data[1].equalsIgnoreCase(username) && data[3].equals(password)){
                userDetails[0] = data[0];
                userDetails[1] = data[2];
                userDetails[2] = data[4];
                response[0] = true;
            }

        });

        MiniProjectManagementSystem.loggedInUserId =  userDetails[0];
        MiniProjectManagementSystem.loggedInUserName =  userDetails[1];
        MiniProjectManagementSystem.loggedInUserRole = userDetails[2];
        return response[0];
    }
    
}
