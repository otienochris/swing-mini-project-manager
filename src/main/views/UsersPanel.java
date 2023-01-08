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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import main.MiniProjectManagementSystem;
import main.enums.RoleEnum;

/**
 *
 * @author
 */
public class UsersPanel extends javax.swing.JPanel {
    
    private final String USER_TXT_FILE = MiniProjectManagementSystem.USER_TXT_FILE;
    private final String FILE_DELIMITER = MiniProjectManagementSystem.FILE_DELIMITER;
    List<String> specializations = new ArrayList<>();
    JFrame editUserPopup = new JFrame();
    
    List<String> users = new ArrayList<>();
    
    // for popup
    JComboBox<String> genderForPopup = new JComboBox(new String[]{"male", "female","other"});
    JComboBox<String> roleTxtForPopup = new JComboBox<>(new String[]{RoleEnum.ADMIN.name(), RoleEnum.LECTURER.name(),RoleEnum.STUDENT.name()});
    JComboBox<String> specializationTxtForPopup = new JComboBox<>();
    JTextField nameTxtForPopup = new JTextField(20);
    JTextField usernameTxtForPopup = new JTextField(20);
    JLabel idLabel = new JLabel("ID");

    /**
     * Creates new form UsersPanel
     */
    public UsersPanel() {
        initComponents();
        
        initializeTableData();
        
        addNewUser();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        javax.swing.JButton btnAddNewUser = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(970, 867));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Full Name", "Role", "Gender", "Specialization"
            }
        ));
        jScrollPane1.setViewportView(usersTable);
        if (usersTable.getColumnModel().getColumnCount() > 0) {
            usersTable.getColumnModel().getColumn(0).setResizable(false);
            usersTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel1.setText("Users");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAddNewUser.setBackground(new java.awt.Color(255, 204, 0));
        btnAddNewUser.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnAddNewUser.setText("Add");
        btnAddNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnAddNewUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnAddNewUser)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewUserActionPerformed
        clearPopupFields();
        addNewUser();
        editUserPopup.setTitle("Add User");
        editUserPopup.setVisible(true);

    }//GEN-LAST:event_btnAddNewUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables

    
    private void initializeTableData() {
        users = MiniProjectManagementSystem.getData(USER_TXT_FILE);
        
        // generate the header and remove the password column
        String[] header = Stream.of(users.get(0).split(FILE_DELIMITER))
                .filter(item -> !item.equalsIgnoreCase("Password"))
                .toArray(String[]::new);
        
        
        if (!users.isEmpty()) {
            users.remove(0); 
        }
        
        int [] count = {0};
        String[][] usersTableData = new String[users.size()][header.length];
        
        users.forEach(item -> {
            String [] i = item.split(FILE_DELIMITER);
            System.out.print("count: " + usersTable.getModel().getColumnCount());
            usersTableData[count[0]][0] = i[0];
            usersTableData[count[0]][1] = i[1];
            usersTableData[count[0]][2] = i[2];
            usersTableData[count[0]][3] = getRole(i[4]);
            usersTableData[count[0]][4] = i[5];
            usersTableData[count[0]][5] = i[6];
            count[0] += 1;
        });
        
        DefaultTableModel model = new DefaultTableModel(usersTableData, header);
       
        usersTable.setModel(model);
        usersTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
//                usersFrame.dispose();
                int rowId = usersTable.getSelectedRow();
                String[] sample = usersTableData[rowId];
                
                
                editUserPopup.setTitle("Edit User");
                
                String userId = sample[0];
                String username = sample[1];
                String name = sample[2];
                String role = sample[3];
                String genderTxt = sample[4];
                String specialization = getSpecializationDescription(sample[5], specializations, FILE_DELIMITER);
                
                idLabel.setText(userId);
                usernameTxtForPopup.setText(username);
                nameTxtForPopup.setText(name);
                roleTxtForPopup.setSelectedItem(role);
                genderForPopup.setSelectedItem(genderTxt);
                specializationTxtForPopup.setSelectedItem(specialization);
                
                editUserPopup.setVisible(true);
                
            }
        });
    }
    
    private void clearPopupFields() {
        idLabel.setText("");
        usernameTxtForPopup.setText("");
        nameTxtForPopup.setText("");
        roleTxtForPopup.setSelectedItem("");
        genderForPopup.setSelectedItem("");
        specializationTxtForPopup.setSelectedItem("");
    }

    private void addNewUser(){
        Font btnFont = new Font("monospaced", Font.BOLD, 18);
        Font inputFont = new Font("monospaced", Font.BOLD, 16);
        Font labelFont = new Font("monospaced", Font.PLAIN, 18);
        specializations = MiniProjectManagementSystem.getData(MiniProjectManagementSystem.SPECIALIZATION_TXT_FILE);
        
        // add and edit popup
        editUserPopup.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        editUserPopup.setLayout(null);
        editUserPopup.setResizable(false);
        editUserPopup.setSize(400,400);
        editUserPopup.setLocationRelativeTo(null);        
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        usernameLabel.setBounds(90,10,100,25);
        editUserPopup.add(usernameLabel);

        
        usernameTxtForPopup.setFont(inputFont);
        usernameTxtForPopup.setBounds(90,39,255,30);
        editUserPopup.add(usernameTxtForPopup);

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setBounds(90,85,250,25);
        editUserPopup.add(nameLabel);

        
        nameTxtForPopup.setFont(inputFont);
        nameTxtForPopup.setBounds(90,110,255,30);
        editUserPopup.add(nameTxtForPopup);
            
        JLabel specializationLabel = new JLabel("Specialization:");
        specializationLabel.setFont(labelFont);
        specializationLabel.setBounds(90,150,300,25);


        specializations.remove(0); // remove the header
        String[] specializationOptions = specializations.stream()
                .map(specialization -> specialization.split(FILE_DELIMITER)[2])
                .toArray(String[]::new); // get only the specializations' descriptions 
        
        specializationTxtForPopup = new JComboBox<>(specializationOptions);
        specializationTxtForPopup.setBounds(90,175,255,30);
            
        if (!specializations.isEmpty()){
            editUserPopup.add(specializationLabel);
            editUserPopup.add(specializationTxtForPopup);
        }
        
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(labelFont);
        genderLabel.setBounds(90,215,100,25);
        editUserPopup.add(genderLabel);
        
        
        genderForPopup.setBounds(180,215,165,30);
        editUserPopup.add(genderForPopup);
        
        JLabel roleLabel = new JLabel("Role ");
        roleLabel.setFont(labelFont);
        roleLabel.setBounds(90,250,300,30);
        editUserPopup.add(roleLabel);
        
        roleTxtForPopup.setBounds(180,250,165,30);
        roleTxtForPopup.setSelectedIndex(2);
        editUserPopup.add(roleTxtForPopup);
        
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
                        + usernameTxtForPopup.getText() + FILE_DELIMITER 
                        + nameTxtForPopup.getText() + FILE_DELIMITER 
                        + randomPassword + FILE_DELIMITER 
                        + ((String)roleTxtForPopup.getSelectedItem()).charAt(0) + FILE_DELIMITER 
                        + genderForPopup.getSelectedItem() + FILE_DELIMITER 
                        + getSpecializationShortDescription((String)specializationTxtForPopup.getSelectedItem(),specializations, FILE_DELIMITER);
                boolean success = MiniProjectManagementSystem.writeLineToFile(USER_TXT_FILE, newUser);
                if(success) {
                    initializeTableData();
                    editUserPopup.dispose();
                    JOptionPane.showMessageDialog(null, "Copy and share this password: " + randomPassword, "Password for " + nameTxtForPopup.getText(), JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error Saving, try again", "Adding new user", JOptionPane.ERROR_MESSAGE);
                }
            
            } else if (windowTitle.contains("Edit")){
                String id = idLabel.getText();
                String oldPassword = MiniProjectManagementSystem.getOldPassword(id);
                
                String updatedUser = id + FILE_DELIMITER 
                        + usernameTxtForPopup.getText() + FILE_DELIMITER 
                        + nameTxtForPopup.getText() + FILE_DELIMITER 
                        + oldPassword + FILE_DELIMITER 
                        + ((String)roleTxtForPopup.getSelectedItem()).charAt(0) + FILE_DELIMITER 
                        + genderForPopup.getSelectedItem() + FILE_DELIMITER 
                        + getSpecializationShortDescription((String)specializationTxtForPopup.getSelectedItem(), specializations, FILE_DELIMITER);
                boolean success = MiniProjectManagementSystem.updateRecord(Integer.parseInt(id), updatedUser, USER_TXT_FILE);
                if(success) {
                    initializeTableData();
                    editUserPopup.dispose();
                    
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
//            new UsersFrame();
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
                    initializeTableData();
                }    
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Deleting a user", JOptionPane.ERROR_MESSAGE);
            }
        });
        editUserPopup.add(deleteBtn);
    }
    
    
    private String getRole(String role) {
        switch(role) {
            case "A":
                return RoleEnum.ADMIN.name();
            case "L":
                return RoleEnum.LECTURER.name();
            case "S":
                return RoleEnum.STUDENT.name();
            default:
                throw new RuntimeException("No such role.");
                
        }
    }
    
    public static String getSpecializationShortDescription(String specializationDescription, List<String> specializationList, String delimiter) {
        return specializationList.stream()
                    .filter(specialization -> 
                            specialization.split(delimiter)[2].equalsIgnoreCase(specializationDescription))
                    .collect(Collectors.toList())
                    .get(0) // get the specialization record
                    .split(delimiter)[1]; // get the specialization id
    }
    
    public static String getSpecializationDescription(String specializationShortDescription, List<String> specializationList, String delimiter) {
        return specializationList.stream()
                    .filter(specialization -> 
                            specialization.split(delimiter)[1].equalsIgnoreCase(specializationShortDescription))
                    .collect(Collectors.toList())
                    .get(0) // get the specialization record
                    .split(delimiter)[2]; // get the specialization id
    }
}
