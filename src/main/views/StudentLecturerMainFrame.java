package main.views;

import java.awt.CardLayout;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import main.MiniProjectManagementSystem;

/**
 *
 * @author
 */
public class StudentLecturerMainFrame extends javax.swing.JFrame {

    private CardLayout cardLayout = new CardLayout();;
    private final String USERS = "users";
    private final String PROJECTS = "projects";
    private final String MY_PROJECTS = "myProjects";
    private List<String> allProjects;
    private String loggedInUserRole = MiniProjectManagementSystem.loggedInUserRole;
    
    /**
     * Creates new form LecturerMainFrame
     */
    public StudentLecturerMainFrame() {
        
        if (loggedInUserRole.equalsIgnoreCase("S")) {
            String [] user = MiniProjectManagementSystem.getRecordById(MiniProjectManagementSystem.loggedInUserId, MiniProjectManagementSystem.USER_TXT_FILE);
            System.out.println(Arrays.toString(user));
            allProjects = MiniProjectManagementSystem.getData(MiniProjectManagementSystem.PROJECT_TXT_FILE).stream()
                    .filter(project -> project.split(MiniProjectManagementSystem.FILE_DELIMITER)[8].equalsIgnoreCase(user[6]) 
                            && project.split(MiniProjectManagementSystem.FILE_DELIMITER)[9].equalsIgnoreCase("true"))
                    .collect(Collectors.toList());
            
            System.out.println(allProjects.size());
        } else if (loggedInUserRole.equalsIgnoreCase("L")) {
            allProjects = MiniProjectManagementSystem.getData(MiniProjectManagementSystem.PROJECT_TXT_FILE);
        }
        // remove the header
        allProjects.remove(0);
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        mainPanel.setLayout(cardLayout);
        mainPanel.add(new ProjectViewPanel(allProjects, false, this), PROJECTS);
        mainPanel.add(new ProjectViewPanel(allProjects, false, this), MY_PROJECTS);
        
        // set logged in user
        loggedUsername.setText(MiniProjectManagementSystem.loggedInUserName);
        
        
        if(MiniProjectManagementSystem.loggedInUserRole.equalsIgnoreCase("L")) { 
            btnAddProject.setVisible(true);
        } else {
            btnAddProject.setVisible(false);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        javax.swing.JButton btnAllProjects = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JButton btnMyProjects = new javax.swing.JButton();
        javax.swing.JButton btnProfile = new javax.swing.JButton();
        loggedUsername = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnAddProject = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1283, 951));
        setPreferredSize(new java.awt.Dimension(1283, 951));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setText("Logged in as: ");

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        btnAllProjects.setBackground(new java.awt.Color(255, 204, 0));
        btnAllProjects.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnAllProjects.setText("All Projects");
        btnAllProjects.setFocusable(false);
        btnAllProjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllProjectsActionPerformed(evt);
            }
        });

        btnMyProjects.setBackground(new java.awt.Color(255, 204, 0));
        btnMyProjects.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnMyProjects.setText("My Projects");
        btnMyProjects.setFocusable(false);
        btnMyProjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyProjectsActionPerformed(evt);
            }
        });

        btnProfile.setBackground(new java.awt.Color(255, 204, 0));
        btnProfile.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnProfile.setText("My Profile");
        btnProfile.setFocusable(false);

        loggedUsername.setFont(new java.awt.Font("Monospaced", 2, 14)); // NOI18N
        loggedUsername.setText("jLabel3");

        btnLogout.setText("Log Out");
        btnLogout.setFocusable(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnAddProject.setBackground(new java.awt.Color(0, 0, 0));
        btnAddProject.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        btnAddProject.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProject.setText("Add Project");
        btnAddProject.setFocusable(false);
        btnAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnMyProjects, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAllProjects, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProfile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnAddProject)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loggedUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel1))))
                .addGap(14, 14, 14))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddProject, btnProfile});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loggedUsername)
                .addGap(39, 39, 39)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnAllProjects)
                .addGap(33, 33, 33)
                .addComponent(btnMyProjects)
                .addGap(33, 33, 33)
                .addComponent(btnProfile)
                .addGap(37, 37, 37)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnAddProject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(41, 41, 41))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddProject, btnProfile});

        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainPanel.setMinimumSize(new java.awt.Dimension(964, 895));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 893, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAllProjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllProjectsActionPerformed
        cardLayout.show(mainPanel, PROJECTS);
    }//GEN-LAST:event_btnAllProjectsActionPerformed

    private void btnMyProjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProjectsActionPerformed
        
        if(MiniProjectManagementSystem.loggedInUserRole.equalsIgnoreCase("L")) {
        allProjects = allProjects.stream()
                .filter(project -> project.split(MiniProjectManagementSystem.FILE_DELIMITER)[7].equalsIgnoreCase(MiniProjectManagementSystem.loggedInUserId))
                .collect(Collectors.toList());
        } else if (MiniProjectManagementSystem.loggedInUserRole.equalsIgnoreCase("S")) {
        allProjects = allProjects.stream()
                .filter(project -> project.split(MiniProjectManagementSystem.FILE_DELIMITER)[6].equalsIgnoreCase(MiniProjectManagementSystem.loggedInUserId))
                .collect(Collectors.toList());
        }
        mainPanel.remove(1);
        mainPanel.add(new ProjectViewPanel(allProjects, true, this), MY_PROJECTS);
        cardLayout.show(mainPanel, MY_PROJECTS);
    }//GEN-LAST:event_btnMyProjectsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        MiniProjectManagementSystem.loggedInUserId = "";
        MiniProjectManagementSystem.loggedInUserName = "";
        MiniProjectManagementSystem.loggedInUserRole = "";
        
        this.dispose();
        
        new LoginFrame();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProjectActionPerformed
        this.dispose();
        new AddProjectFrame().setVisible(true);
        
    }//GEN-LAST:event_btnAddProjectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentLecturerMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentLecturerMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentLecturerMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentLecturerMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentLecturerMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProject;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel loggedUsername;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
