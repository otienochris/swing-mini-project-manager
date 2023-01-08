package main.views;

import javax.swing.JOptionPane;
import main.MiniProjectManagementSystem;
import main.enums.RoleEnum;

/**
 *
 * @author
 */
public class ProfilePanel extends javax.swing.JPanel {
    private final String [] user;
    /**
     * Creates new form ProfilePanel
     */
    public ProfilePanel() {
        initComponents();
        
        user = MiniProjectManagementSystem.getRecordById(MiniProjectManagementSystem.loggedInUserId,MiniProjectManagementSystem.USER_TXT_FILE);
        
        labelUsername.setText(user[1]);
        labelFullname.setText(user[2]);
        labelRole.setText(user[4].equalsIgnoreCase("L") ? RoleEnum.LECTURER.name() : RoleEnum.STUDENT.name());
        labelGender.setText(user[5]);
        labelSpecialization.setText(user[6]);
        
        txtFullName.setText(user[2]);
        comboGender.setSelectedItem(user[5]);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelUsername = new javax.swing.JLabel();
        labelSpecialization = new javax.swing.JLabel();
        labelFullname = new javax.swing.JLabel();
        labelGender = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        comboGender = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnSaveChanges = new javax.swing.JButton();
        javax.swing.JLabel jLabel14 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        labelRole = new javax.swing.JLabel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JPasswordField();
        javax.swing.JLabel jLabel15 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel16 = new javax.swing.JLabel();
        txtNewPass = new javax.swing.JPasswordField();
        javax.swing.JLabel jLabel17 = new javax.swing.JLabel();
        txtNewPass2 = new javax.swing.JPasswordField();
        btnChangePassword = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(964, 895));
        setPreferredSize(new java.awt.Dimension(964, 895));

        jPanel1.setBackground(new java.awt.Color(51, 51, 0));

        jLabel1.setFont(new java.awt.Font("Courier 10 Pitch", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bio Data");

        jLabel3.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Full Name:");

        jLabel5.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gender:");

        jLabel6.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Specialization:");

        labelUsername.setFont(new java.awt.Font("Courier 10 Pitch", 3, 18)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(255, 255, 255));

        labelSpecialization.setFont(new java.awt.Font("Courier 10 Pitch", 3, 18)); // NOI18N
        labelSpecialization.setForeground(new java.awt.Color(255, 255, 255));

        labelFullname.setFont(new java.awt.Font("Courier 10 Pitch", 3, 18)); // NOI18N
        labelFullname.setForeground(new java.awt.Color(255, 255, 255));

        labelGender.setFont(new java.awt.Font("Courier 10 Pitch", 3, 18)); // NOI18N
        labelGender.setForeground(new java.awt.Color(255, 255, 255));

        comboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "male", "female", "other", " " }));
        comboGender.setSelectedIndex(3);

        jLabel12.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Full Name:");

        jLabel13.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Gender:");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSaveChanges.setBackground(new java.awt.Color(255, 204, 0));
        btnSaveChanges.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnSaveChanges.setText("Save Changes");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Courier 10 Pitch", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Edit Bio Data");

        labelRole.setFont(new java.awt.Font("Courier 10 Pitch", 3, 18)); // NOI18N
        labelRole.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Role:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelFullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelSpecialization, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(labelRole, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(comboGender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFullName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSaveChanges, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(labelUsername))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelFullname)
                            .addComponent(jLabel12))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(labelGender))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(labelSpecialization))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(labelRole))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnSaveChanges)
                        .addGap(14, 14, 14))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 0));

        jLabel7.setFont(new java.awt.Font("Courier 10 Pitch", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Change password");

        txtOldPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel15.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Old password:");

        jLabel16.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("New password:");

        txtNewPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel17.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Confirm password:");

        txtNewPass2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnChangePassword.setBackground(new java.awt.Color(255, 204, 0));
        btnChangePassword.setFont(new java.awt.Font("Courier 10 Pitch", 3, 18)); // NOI18N
        btnChangePassword.setText("Change Password");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtNewPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(310, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(3, 3, 3)
                .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel16)
                .addGap(9, 9, 9)
                .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(205, 205, 205))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        String fullName = txtFullName.getText();
        String gender = (String) comboGender.getSelectedItem();
        if (fullName.isEmpty() || fullName.isBlank() || gender.isBlank() || gender.isEmpty()){
            JOptionPane.showMessageDialog(null,"Full name and gender cannot be empty", "Editing Profile", JOptionPane.ERROR_MESSAGE);
        } else {
            String updatedUser = user[0] + MiniProjectManagementSystem.FILE_DELIMITER 
                        + user[1] + MiniProjectManagementSystem.FILE_DELIMITER 
                        + fullName + MiniProjectManagementSystem.FILE_DELIMITER 
                        + user[3] + MiniProjectManagementSystem.FILE_DELIMITER 
                        + user[4] + MiniProjectManagementSystem.FILE_DELIMITER 
                        + gender + MiniProjectManagementSystem.FILE_DELIMITER 
                        + user[6];
            
            boolean success = MiniProjectManagementSystem.updateRecord(Integer.parseInt(user[0]), updatedUser, MiniProjectManagementSystem.USER_TXT_FILE);
                if(success) {
                    JOptionPane.showMessageDialog(null, "Changes saved successfully", "Editing Profile", JOptionPane.ERROR_MESSAGE);
                    labelFullname.setText(fullName);
                    labelGender.setText(gender);
                    
                    txtFullName.setText("");
                    comboGender.setSelectedItem("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error Updating, try again", "Editing Profile", JOptionPane.ERROR_MESSAGE);
                }
        }
    }//GEN-LAST:event_btnSaveChangesActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        String oldPass = txtOldPassword.getText();
        String newPass = txtNewPass.getText();
        String newPass2 = txtNewPass2.getText();
        if (oldPass.isEmpty() || oldPass.isBlank() || newPass.isEmpty() || newPass.isBlank()){
            JOptionPane.showMessageDialog(null,"New and old password cannot be empty.", "Change Password", JOptionPane.ERROR_MESSAGE);
        } else if (!newPass.equals(newPass2)) {
            JOptionPane.showMessageDialog(null,"Password Mismatch", "Change Password", JOptionPane.ERROR_MESSAGE);
        } else if (newPass.length() < 8) {
            JOptionPane.showMessageDialog(null,"New password cannot be less than 8 characters.", "Change Password", JOptionPane.ERROR_MESSAGE);
        } else {
            
            // validate password
            boolean isPasswordValid = LoginFrame.areCredentialsValid(user[1], oldPass);
            if (!isPasswordValid){
                JOptionPane.showMessageDialog(null,"You provided a wrong password as the old password.", "Change Password", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            
            String updatedUser = user[0] + MiniProjectManagementSystem.FILE_DELIMITER 
                        + user[1] + MiniProjectManagementSystem.FILE_DELIMITER 
                        + user[2] + MiniProjectManagementSystem.FILE_DELIMITER 
                        + newPass + MiniProjectManagementSystem.FILE_DELIMITER 
                        + user[4] + MiniProjectManagementSystem.FILE_DELIMITER 
                        + user[5] + MiniProjectManagementSystem.FILE_DELIMITER 
                        + user[6];
            
            boolean success = MiniProjectManagementSystem.updateRecord(Integer.parseInt(user[0]), updatedUser, MiniProjectManagementSystem.USER_TXT_FILE);
                if(success) {
                    JOptionPane.showMessageDialog(null, "Password changed successfully", "Change Password", JOptionPane.ERROR_MESSAGE);
                    txtOldPassword.setText("");
                    txtNewPass.setText("");
                    txtNewPass2.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error changing password, try again", "Change Password", JOptionPane.ERROR_MESSAGE);
                }
        }
    }//GEN-LAST:event_btnChangePasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JComboBox<String> comboGender;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelFullname;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel labelRole;
    private javax.swing.JLabel labelSpecialization;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JPasswordField txtNewPass2;
    private javax.swing.JPasswordField txtOldPassword;
    // End of variables declaration//GEN-END:variables
}
