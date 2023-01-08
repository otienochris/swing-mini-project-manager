package main.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import main.MiniProjectManagementSystem;
import main.enums.RoleEnum;

/**
 *
 * @author 
 */
public class UsersFrame{
    JFrame usersFrame = new JFrame();
    private final String USER_TXT_FILE = MiniProjectManagementSystem.USER_TXT_FILE;
    private final String FILE_DELIMITER = MiniProjectManagementSystem.FILE_DELIMITER;
    Font btnFont = new Font("monospaced", Font.BOLD, 18);
    Font inputFont = new Font("monospaced", Font.BOLD, 16);
    Font labelFont = new Font("monospaced", Font.PLAIN, 18);
    private List<String> specializations = new ArrayList<>();

    public UsersFrame() {
        usersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        usersFrame.setLayout(null);
        usersFrame.setResizable(false);
        usersFrame.setTitle("Users");
        usersFrame.setSize(1000,700);
        usersFrame.setLocationRelativeTo(null);
        
        
        // initialize specializations
        specializations = MiniProjectManagementSystem.getData(MiniProjectManagementSystem.SPECIALIZATION_TXT_FILE);
        
        
        // add and edit popup
        JFrame editUserPopup = new JFrame();
        editUserPopup.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        editUserPopup.setLayout(null);
        editUserPopup.setResizable(false);
        editUserPopup.setSize(400,400);
        editUserPopup.setLocationRelativeTo(null);
        
        JLabel idLabel = new JLabel("ID");
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        usernameLabel.setBounds(90,10,100,25);
        editUserPopup.add(usernameLabel);

        JTextField usernameTxt = new JTextField(20);
        usernameTxt.setFont(inputFont);
        usernameTxt.setBounds(90,39,255,30);
        editUserPopup.add(usernameTxt);

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setBounds(90,85,250,25);
        editUserPopup.add(nameLabel);

        JTextField nameTxt = new JTextField(20);
        nameTxt.setFont(inputFont);
        nameTxt.setBounds(90,110,255,30);
        editUserPopup.add(nameTxt);
            
        JLabel specializationLabel = new JLabel("Specialization:");
        specializationLabel.setFont(labelFont);
        specializationLabel.setBounds(90,150,300,25);


        specializations.remove(0); // remove the header
        String[] specializationOptions = specializations.stream()
                .map(specialization -> specialization.split(FILE_DELIMITER)[2])
                .toArray(String[]::new); // get only the specializations' descriptions 
        JComboBox<String> specializationTxt = new JComboBox<>(specializationOptions);
        specializationTxt.setBounds(90,175,255,30);
            
        if (!specializations.isEmpty()){
            editUserPopup.add(specializationLabel);
            editUserPopup.add(specializationTxt);
        }
        
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(labelFont);
        genderLabel.setBounds(90,215,100,25);
        editUserPopup.add(genderLabel);
        
        JComboBox gender = new JComboBox(new String[]{"male", "female","other"});
        gender.setBounds(180,215,165,30);
        editUserPopup.add(gender);
        
        
        
        JLabel roleLabel = new JLabel("Role ");
        roleLabel.setFont(labelFont);
        roleLabel.setBounds(90,250,300,30);
        editUserPopup.add(roleLabel);

        JComboBox<String> roleTxt = new JComboBox<>(new String[]{RoleEnum.ADMIN.name(), RoleEnum.LECTURER.name(),RoleEnum.STUDENT.name()});
        roleTxt.setBounds(180,250,165,30);
        roleTxt.setSelectedIndex(2);
        editUserPopup.add(roleTxt);
        
        JButton confirmBtn = new JButton("Save");
        confirmBtn.setBackground(Color.ORANGE);
        confirmBtn.setForeground(Color.BLACK);
        confirmBtn.setFont(btnFont);
        confirmBtn.setFocusable(false);
        confirmBtn.setBounds(80,305,80,40);
        confirmBtn.addActionListener(event -> {
            
            String windowTitle = editUserPopup.getTitle();
            if(windowTitle.contains("Add")){
                int nextId = MiniProjectManagementSystem.getNextId(USER_TXT_FILE);
                String randomPassword = MiniProjectManagementSystem.randomPassword(8);
                String newUser = "\n" + nextId + FILE_DELIMITER 
                        + usernameTxt.getText() + FILE_DELIMITER 
                        + nameTxt.getText() + FILE_DELIMITER 
                        + randomPassword + FILE_DELIMITER 
                        + ((String)roleTxt.getSelectedItem()).charAt(0) + FILE_DELIMITER 
                        + gender.getSelectedItem() + FILE_DELIMITER 
                        + getSpecializationShortDescription((String)specializationTxt.getSelectedItem());
                boolean success = MiniProjectManagementSystem.writeLineToFile(USER_TXT_FILE, newUser);
                if(success) {
                    JOptionPane.showMessageDialog(null, "Copy and share this password: " + randomPassword, "Password for " + nameTxt.getText(), JOptionPane.INFORMATION_MESSAGE);
                    editUserPopup.dispose();
                    new UsersFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "Error Saving, try again", "Adding new user", JOptionPane.ERROR_MESSAGE);
                }
            
            } else if (windowTitle.contains("Edit")){
                String id = idLabel.getText();
                String oldPassword = MiniProjectManagementSystem.getOldPassword(id);
                
                String updatedUser = id + FILE_DELIMITER 
                        + usernameTxt.getText() + FILE_DELIMITER 
                        + nameTxt.getText() + FILE_DELIMITER 
                        + oldPassword + FILE_DELIMITER 
                        + ((String)roleTxt.getSelectedItem()).charAt(0) + FILE_DELIMITER 
                        + gender.getSelectedItem() + FILE_DELIMITER 
                        + getSpecializationShortDescription((String)specializationTxt.getSelectedItem());
                boolean success = MiniProjectManagementSystem.updateRecord(Integer.parseInt(id), updatedUser, USER_TXT_FILE);
                if(success) {
                    editUserPopup.dispose();
                    new UsersFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "Error Updating, try again", "Editing user", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            
        });
        editUserPopup.add(confirmBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(Color.LIGHT_GRAY);
        cancelBtn.setForeground(Color.BLACK);
        cancelBtn.setFont(btnFont);
        cancelBtn.setFocusable(false);
        cancelBtn.setBounds(240,305,105,40);
        cancelBtn.addActionListener(event -> {
            editUserPopup.dispose();
            new UsersFrame();
        });
        editUserPopup.add(cancelBtn);
        
        JButton deleteBtn = new JButton("Del");
        deleteBtn.setBackground(Color.RED);
        deleteBtn.setFont(btnFont);
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setFocusable(false);
        deleteBtn.setBounds(165,305,70,40);
        deleteBtn.addActionListener(event -> {
            try {
                boolean success = MiniProjectManagementSystem.deleteRecordById(Integer.parseInt(idLabel.getText()), USER_TXT_FILE);
                if(success) {
                    editUserPopup.dispose();
                    new UsersFrame();
                }    
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Deleting a user", JOptionPane.ERROR_MESSAGE);
            }
        });
        editUserPopup.add(deleteBtn);
        
        // end of popup
        
        JButton backBtn = new JButton("<< back");
        backBtn.setFocusable(false);
        backBtn.setBounds(5,5,100,30);
        backBtn.addActionListener(event -> {
            usersFrame.dispose();
            new AdminMainFrame().setVisible(true);
        });
        usersFrame.add(backBtn);
        
        JButton addCarBtn = new JButton("Add New User");
        addCarBtn.setBounds(420,50,200,40);
        addCarBtn.setFocusable(false);
        addCarBtn.addActionListener(event -> {
            usersFrame.dispose();
            
            editUserPopup.setTitle("Add new user");
            idLabel.setText("");
            usernameTxt.setText("");
            nameTxt.setText("");
            roleTxt.setSelectedItem("");
            editUserPopup.remove(deleteBtn);
            

            editUserPopup.setVisible(true);
            
        });
        usersFrame.add(addCarBtn);
        
        JLabel welcome = new JLabel("*Select a user to view more details");
        welcome.setBounds(150,110,250,20);
        usersFrame.add(welcome);
        
        List<String> users = MiniProjectManagementSystem.getData(USER_TXT_FILE);
        
        // generate the header and remove the password column
        String[] header = Stream.of(users.get(0).split(FILE_DELIMITER))
                .filter(item -> !item.equalsIgnoreCase("password"))
                .toArray(String[]::new);
        
        
        if (!users.isEmpty()) {
            users.remove(0); 
        }
        
        int size = users.size();
        int [] count = {0};
        String[][] tableData = new String[size][7];
        users.forEach(item -> {
            String [] i = item.split(FILE_DELIMITER);
            tableData[count[0]][0] = i[0];
            tableData[count[0]][1] = i[1];
            tableData[count[0]][2] = i[2];
            tableData[count[0]][3] = i[4];
            tableData[count[0]][4] = i[5];
            tableData[count[0]][5] = i[6];
            count[0] += 1;
        });
        
        
        JTable table = new JTable(tableData, header);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                usersFrame.dispose();
                int rowId = table.getSelectedRow();
                String[] sample = tableData[rowId];
                
                
                editUserPopup.setTitle("Edit User");
                
                String userId = sample[0];
                String username = sample[1];
                String name = sample[2];
                String role = sample[3];
                String genderTxt = sample[4];
                String specialization = getSpecializationDescription(sample[5]);
                
                idLabel.setText(userId);
                usernameTxt.setText(username);
                nameTxt.setText(name);
                roleTxt.setSelectedItem(role);
                gender.setSelectedItem(genderTxt);
                specializationTxt.setSelectedItem(specialization);
                
                editUserPopup.setVisible(true);
                
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(150, 150,700,300);
        
        usersFrame.add(scrollPane);
        
        usersFrame.setVisible(true);
    }
    
    private String getSpecializationShortDescription(String specializationDescription) {
        return specializations.stream()
                    .filter(specialization -> 
                            specialization.split(FILE_DELIMITER)[2].equalsIgnoreCase(specializationDescription))
                    .collect(Collectors.toList())
                    .get(0) // get the specialization record
                    .split(FILE_DELIMITER)[1]; // get the specialization id
    }
    
    private String getSpecializationDescription(String specializationShortDescription) {
        return specializations.stream()
                    .filter(specialization -> 
                            specialization.split(FILE_DELIMITER)[1].equalsIgnoreCase(specializationShortDescription))
                    .collect(Collectors.toList())
                    .get(0) // get the specialization record
                    .split(FILE_DELIMITER)[2]; // get the specialization id
    }
}
