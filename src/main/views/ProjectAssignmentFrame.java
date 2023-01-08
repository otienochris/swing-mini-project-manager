package main.views;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import main.MiniProjectManagementSystem;

/**
 *
 * @author
 */
public class ProjectAssignmentFrame extends javax.swing.JFrame {
    private boolean isAssigned = false;
    private String studentId;
    private String[] studentRecord;
    private String [] projectTokens;
    /**
     * Creates new form ProjectAssignmentFrame
     */
    public ProjectAssignmentFrame(String project) {
        initComponents();
        
        List<String> users = MiniProjectManagementSystem.getData(MiniProjectManagementSystem.USER_TXT_FILE);
        users.remove(0); // remove header
        users = users.stream()
                .filter(item -> item.split(MiniProjectManagementSystem.FILE_DELIMITER)[4].equalsIgnoreCase("S"))
                .collect(Collectors.toList());
        
        
        projectTokens = project.split(MiniProjectManagementSystem.FILE_DELIMITER);
        this.setLocationRelativeTo(null);
        txtTitle.setText(projectTokens[1]);
        
        isAssigned = projectTokens[5].equalsIgnoreCase("true");
        
        if (isAssigned) {
            studentId = projectTokens[6];
            studentRecord = MiniProjectManagementSystem.getRecordById(studentId, MiniProjectManagementSystem.USER_TXT_FILE);
            
            txtUsername.setText(studentRecord[1]);
            txtFullname.setText(studentRecord[2]);
            
            List<String> user = users.stream()
                .filter(item -> item.split(MiniProjectManagementSystem.FILE_DELIMITER)[0].equalsIgnoreCase(studentId))
                .collect(Collectors.toList());
            
            if (!users.isEmpty()){
                txtUsername.setText(users.get(0).split(MiniProjectManagementSystem.FILE_DELIMITER)[1]);
                txtFullname.setText(users.get(0).split(MiniProjectManagementSystem.FILE_DELIMITER)[2]);
            }
        }
        
        // set students
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(users.stream()
                .map(item -> item.split(MiniProjectManagementSystem.FILE_DELIMITER)[1]).toArray(String[]::new));
        comboProjects.setModel(model);
        
        panelAssignProject.setVisible(!isAssigned);
        panelAssignmentDetails.setVisible(isAssigned);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelAssignmentDetails = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JLabel();
        txtFullname = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnUnassign = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        panelAssignProject = new javax.swing.JPanel();
        comboProjects = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAssignProject = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 0));
        setMinimumSize(new java.awt.Dimension(1283, 951));
        setPreferredSize(new java.awt.Dimension(1283, 951));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtTitle.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        txtTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitle.setText("Title");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtTitle)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel3.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Assignments");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Courier 10 Pitch", 2, 15)); // NOI18N
        jLabel4.setText("Username :");

        jLabel5.setFont(new java.awt.Font("Courier 10 Pitch", 2, 15)); // NOI18N
        jLabel5.setText("Student name:");

        jLabel6.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        jLabel6.setText("Student Details:");

        txtUsername.setFont(new java.awt.Font("Courier 10 Pitch", 3, 15)); // NOI18N
        txtUsername.setText("Username");

        txtFullname.setFont(new java.awt.Font("Courier 10 Pitch", 3, 15)); // NOI18N
        txtFullname.setText("Fullname");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFullname, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsername))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFullname))
                .addGap(28, 28, 28))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        jLabel7.setText("Actions:");

        btnUnassign.setBackground(new java.awt.Color(204, 51, 0));
        btnUnassign.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        btnUnassign.setForeground(new java.awt.Color(255, 255, 255));
        btnUnassign.setText("Unassign");
        btnUnassign.setFocusable(false);
        btnUnassign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnassignActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<< back");
        btnBack.setFocusable(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnUnassign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addComponent(jLabel7))
                .addGap(141, 141, 141))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBack, btnUnassign});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUnassign)
                    .addComponent(btnBack))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBack, btnUnassign});

        javax.swing.GroupLayout panelAssignmentDetailsLayout = new javax.swing.GroupLayout(panelAssignmentDetails);
        panelAssignmentDetails.setLayout(panelAssignmentDetailsLayout);
        panelAssignmentDetailsLayout.setHorizontalGroup(
            panelAssignmentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAssignmentDetailsLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addGap(236, 236, 236))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAssignmentDetailsLayout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 326, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAssignmentDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAssignmentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(114, 114, 114))
        );
        panelAssignmentDetailsLayout.setVerticalGroup(
            panelAssignmentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAssignmentDetailsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comboProjects.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Assign project to student");

        btnAssignProject.setBackground(new java.awt.Color(255, 204, 0));
        btnAssignProject.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        btnAssignProject.setText("Assign");
        btnAssignProject.setFocusable(false);
        btnAssignProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignProjectActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Courier 10 Pitch", 2, 15)); // NOI18N
        jLabel10.setText("Choose student:");

        btnBack1.setBackground(new java.awt.Color(0, 0, 0));
        btnBack1.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        btnBack1.setForeground(new java.awt.Color(255, 255, 255));
        btnBack1.setText("<< back");
        btnBack1.setFocusable(false);
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAssignProjectLayout = new javax.swing.GroupLayout(panelAssignProject);
        panelAssignProject.setLayout(panelAssignProjectLayout);
        panelAssignProjectLayout.setHorizontalGroup(
            panelAssignProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAssignProjectLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelAssignProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(panelAssignProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboProjects, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAssignProject, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(panelAssignProjectLayout.createSequentialGroup()
                .addGroup(panelAssignProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAssignProjectLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelAssignProjectLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelAssignProjectLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAssignProjectLayout.setVerticalGroup(
            panelAssignProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAssignProjectLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAssignProject)
                .addGap(238, 238, 238)
                .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(panelAssignProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(panelAssignmentDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelAssignmentDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAssignProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(355, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new StudentLecturerMainFrame().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUnassignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnassignActionPerformed
        String updatedRecord = projectTokens[0] + MiniProjectManagementSystem.FILE_DELIMITER
                    + projectTokens[1] + MiniProjectManagementSystem.FILE_DELIMITER
                    + projectTokens[2] + MiniProjectManagementSystem.FILE_DELIMITER
                    + projectTokens[3] + MiniProjectManagementSystem.FILE_DELIMITER
                    + projectTokens[4] + MiniProjectManagementSystem.FILE_DELIMITER
                    + false + MiniProjectManagementSystem.FILE_DELIMITER
                    + "null" + MiniProjectManagementSystem.FILE_DELIMITER
                    + projectTokens[7] + MiniProjectManagementSystem.FILE_DELIMITER
                    + projectTokens[8] + MiniProjectManagementSystem.FILE_DELIMITER
                    + projectTokens[9];
        
        boolean success = MiniProjectManagementSystem.updateRecord(Integer.parseInt(projectTokens[0]), updatedRecord, MiniProjectManagementSystem.PROJECT_TXT_FILE);
        if (success) {
            JOptionPane.showMessageDialog(null, "Successfully unassigned." , "Projects", JOptionPane.INFORMATION_MESSAGE);
            isAssigned = false;
            
            this.dispose();
            new StudentLecturerMainFrame().setVisible(true);
        } else  {
            JOptionPane.showMessageDialog(null, "Error Unassigning, try again", "Project", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUnassignActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        this.dispose();
        new StudentLecturerMainFrame().setVisible(true);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnAssignProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignProjectActionPerformed
        
        List<String> userDetail = MiniProjectManagementSystem.getData(MiniProjectManagementSystem.USER_TXT_FILE).stream()
                .filter(project -> project.split(MiniProjectManagementSystem.FILE_DELIMITER)[1].equalsIgnoreCase((String)comboProjects.getSelectedItem()))
                .collect(Collectors.toList());
        if (!userDetail.isEmpty()){
            String updatedRecord = projectTokens[0] + MiniProjectManagementSystem.FILE_DELIMITER
                        + projectTokens[1] + MiniProjectManagementSystem.FILE_DELIMITER
                        + projectTokens[2] + MiniProjectManagementSystem.FILE_DELIMITER
                        + projectTokens[3] + MiniProjectManagementSystem.FILE_DELIMITER
                        + projectTokens[4] + MiniProjectManagementSystem.FILE_DELIMITER
                        + true + MiniProjectManagementSystem.FILE_DELIMITER
                        + userDetail.get(0).split(MiniProjectManagementSystem.FILE_DELIMITER)[0] + MiniProjectManagementSystem.FILE_DELIMITER
                        + projectTokens[7] + MiniProjectManagementSystem.FILE_DELIMITER
                        + projectTokens[8] + MiniProjectManagementSystem.FILE_DELIMITER
                        + projectTokens[9];

            boolean success = MiniProjectManagementSystem.updateRecord(Integer.parseInt(projectTokens[0]), updatedRecord, MiniProjectManagementSystem.PROJECT_TXT_FILE);
            if (success) {
                JOptionPane.showMessageDialog(null, "Successfully Assigned." , "Projects", JOptionPane.INFORMATION_MESSAGE);
                isAssigned = true;

                this.dispose();
                new StudentLecturerMainFrame().setVisible(true);
            } else  {
                JOptionPane.showMessageDialog(null, "Error Assigning, try again", "Project", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAssignProjectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignProject;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnUnassign;
    private javax.swing.JComboBox<String> comboProjects;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panelAssignProject;
    private javax.swing.JPanel panelAssignmentDetails;
    private javax.swing.JLabel txtFullname;
    private javax.swing.JLabel txtTitle;
    private javax.swing.JLabel txtUsername;
    // End of variables declaration//GEN-END:variables
}
