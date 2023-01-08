package main.views;

import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import main.MiniProjectManagementSystem;

/**
 *
 * @author
 */
public class ProjectViewPanel extends javax.swing.JPanel {

    private final List<String> allProjects;
    private final List<String> specializationList;
    private final boolean listsAreForLecturer;
    
    JFrame prevJframe;
    
    private int position = 0;
    private int size = 0;
    
    /**
     * Creates new form ProjectViewPanel
     */
    public ProjectViewPanel(List<String> projects, boolean areForSpecificUser, JFrame prevFrame) {
        initComponents();
        
        this.prevJframe = prevFrame;
        listsAreForLecturer = areForSpecificUser;
        
        if (areForSpecificUser) {
            labelHeading.setText("My Projects");
            
            if(MiniProjectManagementSystem.loggedInUserRole.equalsIgnoreCase("L")) {
                btnEditProject.setVisible(true);
                btnAssignStudent.setVisible(true);
            } else {
                btnEditProject.setVisible(false);
                btnAssignStudent.setVisible(false);    
            }
        } else {
            labelHeading.setText("All Projects");
            btnEditProject.setVisible(false);
            btnAssignStudent.setVisible(false);
            this.setBackground(Color.BLACK);
        }
        
        
        
        allProjects = projects;
        size = allProjects.size();
        
        specializationList = MiniProjectManagementSystem.getData(MiniProjectManagementSystem.SPECIALIZATION_TXT_FILE);
        
        if (projects.isEmpty()) {
            labelTitle.setVisible(false);
            labelDescription.setVisible(false);
            labelPosition.setVisible(false);
            labelStatus.setVisible(false);
            labelSpecialization.setVisible(false);            
            labelContent.setText("Oops! You have no projects to show");
            labelContent.setForeground(Color.ORANGE);
            jScrollPane1.setVisible(false);
            jScrollPane2.setVisible(false);
            jScrollPane3.setVisible(false);
            btnNextProject.setVisible(false);
            btnPreviousProject.setVisible(false);
        } else {
            String [] projectRecord = allProjects.get(0).split(MiniProjectManagementSystem.FILE_DELIMITER);           
            
            txtTitle.setText(projectRecord[1]);
            txtDescription.setText(projectRecord[2].replaceAll("\\<nl\\>", "\n"));
            txtContent.setText(projectRecord[3].replaceAll("\\<nl\\>", "\n"));
            
            System.out.println(projectRecord[8]);
            String specializationDesc = UsersPanel.getSpecializationDescription(projectRecord[8], specializationList , MiniProjectManagementSystem.FILE_DELIMITER);
            System.out.println(specializationDesc);
            
            labelSpecialization.setText(specializationDesc);
            
            labelStatus.setText(projectRecord[9].equalsIgnoreCase("true") ? "activated" : "deactivated");
            
            labelPosition.setText(position + 1 + " of " + size);
        }
        
        if(allProjects.isEmpty() || allProjects.size() == 1) {
            btnNextProject.setEnabled(false);
            btnPreviousProject.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelHeading = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTitle = new javax.swing.JTextArea();
        labelDescription = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        labelContent = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        labelStatus = new javax.swing.JLabel();
        btnNextProject = new javax.swing.JButton();
        btnPreviousProject = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelSpecialization = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        labelPosition = new javax.swing.JLabel();
        btnEditProject = new javax.swing.JButton();
        btnAssignStudent = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 51, 51));
        setMinimumSize(new java.awt.Dimension(964, 895));
        setPreferredSize(new java.awt.Dimension(964, 895));

        labelHeading.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        labelHeading.setForeground(new java.awt.Color(255, 255, 255));
        labelHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHeading.setText("Projects");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        labelTitle.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelTitle.setText("Title:");

        txtTitle.setEditable(false);
        txtTitle.setColumns(20);
        txtTitle.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        txtTitle.setLineWrap(true);
        txtTitle.setRows(5);
        jScrollPane1.setViewportView(txtTitle);

        labelDescription.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        labelDescription.setForeground(new java.awt.Color(255, 255, 255));
        labelDescription.setText("Description:");

        txtDescription.setEditable(false);
        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        labelContent.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        labelContent.setForeground(new java.awt.Color(255, 255, 255));
        labelContent.setText("Content:");

        txtContent.setEditable(false);
        txtContent.setColumns(20);
        txtContent.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        txtContent.setLineWrap(true);
        txtContent.setRows(5);
        jScrollPane3.setViewportView(txtContent);

        labelStatus.setFont(new java.awt.Font("Liberation Sans", 3, 12)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(255, 204, 0));
        labelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStatus.setText("is active");

        btnNextProject.setBackground(new java.awt.Color(255, 204, 0));
        btnNextProject.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnNextProject.setText("next >>");
        btnNextProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextProjectActionPerformed(evt);
            }
        });

        btnPreviousProject.setBackground(new java.awt.Color(255, 204, 0));
        btnPreviousProject.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        btnPreviousProject.setText("<< prev");
        btnPreviousProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousProjectActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Status:");

        jLabel6.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Specialization:");

        labelSpecialization.setFont(new java.awt.Font("Liberation Sans", 3, 12)); // NOI18N
        labelSpecialization.setForeground(new java.awt.Color(255, 204, 0));
        labelSpecialization.setText("specialization");

        labelPosition.setForeground(new java.awt.Color(255, 255, 255));
        labelPosition.setText("1 of 2");

        btnEditProject.setBackground(new java.awt.Color(255, 204, 0));
        btnEditProject.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        btnEditProject.setText("Edit");
        btnEditProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProjectActionPerformed(evt);
            }
        });

        btnAssignStudent.setBackground(new java.awt.Color(255, 204, 0));
        btnAssignStudent.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        btnAssignStudent.setText("Assignments");
        btnAssignStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(218, 218, 218))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnPreviousProject)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelPosition)
                                .addGap(224, 224, 224)
                                .addComponent(btnNextProject))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTitle)
                                    .addComponent(labelDescription)
                                    .addComponent(labelContent))
                                .addGap(589, 589, 589)))))
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEditProject)
                .addGap(18, 18, 18)
                .addComponent(btnAssignStudent)
                .addGap(313, 313, 313))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAssignStudent, btnEditProject});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelHeading)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditProject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssignStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelStatus)
                    .addComponent(jLabel6)
                    .addComponent(labelSpecialization))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(labelDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelContent)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextProject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPreviousProject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPosition))
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousProjectActionPerformed
        System.out.println("Position before: " + position);
        position -= 1;
        if (position < 0) {
            position = size - 1;
        }
        
        System.out.println("Position after: " + position);
        
        String [] projectRecord = allProjects.get(position).split(MiniProjectManagementSystem.FILE_DELIMITER);           
            
        txtTitle.setText(projectRecord[1]);
        txtDescription.setText(projectRecord[2].replaceAll("\\<nl\\>", "\n"));
        txtContent.setText(projectRecord[3].replaceAll("\\<nl\\>", "\n"));

        System.out.println(projectRecord[8]);
        String specializationDesc = UsersPanel.getSpecializationDescription(projectRecord[8], specializationList , MiniProjectManagementSystem.FILE_DELIMITER);
        System.out.println(specializationDesc);

        labelSpecialization.setText(specializationDesc);

        labelStatus.setText(projectRecord[9].equalsIgnoreCase("true") ? "activated" : "deactivated");
        labelPosition.setText(position + 1 + " of " + size);
    }//GEN-LAST:event_btnPreviousProjectActionPerformed

    private void btnNextProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextProjectActionPerformed
        position += 1;
        if (position > size - 1) {
            position = 0;
        }
        
        String [] projectRecord = allProjects.get(position).split(MiniProjectManagementSystem.FILE_DELIMITER);           
            
        txtTitle.setText(projectRecord[1]);
        txtDescription.setText(projectRecord[2].replaceAll("\\<nl\\>", "\n"));
        txtContent.setText(projectRecord[3].replaceAll("\\<nl\\>", "\n"));

        System.out.println(projectRecord[8]);
        String specializationDesc = UsersPanel.getSpecializationDescription(projectRecord[8], specializationList , MiniProjectManagementSystem.FILE_DELIMITER);
        System.out.println(specializationDesc);

        labelSpecialization.setText(specializationDesc);

        labelStatus.setText(projectRecord[9].equalsIgnoreCase("true") ? "activated" : "deactivated");
        labelPosition.setText(position + 1 + " of " + size);
        
    }//GEN-LAST:event_btnNextProjectActionPerformed

    private void btnEditProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProjectActionPerformed
        prevJframe.dispose();
        
        new AddProjectFrame().editProject(Integer.parseInt(allProjects.get(position).split(MiniProjectManagementSystem.FILE_DELIMITER)[0]));
    }//GEN-LAST:event_btnEditProjectActionPerformed

    private void btnAssignStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignStudentActionPerformed
        prevJframe.dispose();
        String project = allProjects.get(position);
        new ProjectAssignmentFrame(project).setVisible(true);
    }//GEN-LAST:event_btnAssignStudentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignStudent;
    private javax.swing.JButton btnEditProject;
    private javax.swing.JButton btnNextProject;
    private javax.swing.JButton btnPreviousProject;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelContent;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelHeading;
    private javax.swing.JLabel labelPosition;
    private javax.swing.JLabel labelSpecialization;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTextArea txtContent;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextArea txtTitle;
    // End of variables declaration//GEN-END:variables
}
