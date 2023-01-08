package main.views;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import main.MiniProjectManagementSystem;

/**
 *
 * @author chris
 */
public class ReportPanel extends javax.swing.JPanel {

    private final JFrame currentFrame;
    
    private final String PROJECT_TXT_FILE = MiniProjectManagementSystem.PROJECT_TXT_FILE;
    private final String USER_TXT_FILE = MiniProjectManagementSystem.USER_TXT_FILE;
    private List<String> projects ;
    private final List<String> lecturers;
    private final List<String> specialization;
    private final String[] header;
    
    /**
     * Creates new form ReportPanel
     */
    public ReportPanel(JFrame currentFrame) {
        initComponents();
        
        this.currentFrame = currentFrame;
        
        
        projects = MiniProjectManagementSystem.getData(PROJECT_TXT_FILE);
        lecturers = MiniProjectManagementSystem.getData(USER_TXT_FILE).stream()
                .filter(user -> user.split(MiniProjectManagementSystem.FILE_DELIMITER)[4].equalsIgnoreCase("L")).collect(Collectors.toList());
        specialization = MiniProjectManagementSystem.getData(MiniProjectManagementSystem.SPECIALIZATION_TXT_FILE);
        specialization.remove(0); // remove header
        
        // set table header
        header = Stream.of(projects.get(0).split(MiniProjectManagementSystem.FILE_DELIMITER)).filter(item -> !(item.contains("Content") || item.contains("Desc"))).toArray(String[]::new);
        projects.remove(0);
        
        // set the lecturers 
        List<String> lecturerUsername = lecturers.stream()
                .map(lec -> lec.split(MiniProjectManagementSystem.FILE_DELIMITER)[0] + ":" + lec.split(MiniProjectManagementSystem.FILE_DELIMITER)[1])
                .collect(Collectors.toList());
        lecturerUsername.add(""); // add empty
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(lecturerUsername.toArray(String[]::new));
        comboLecturers.setModel(model);
        
        // set the specialization
        List<String> specializationList = specialization.stream()
                .map(spec -> spec.split(MiniProjectManagementSystem.FILE_DELIMITER)[1])
               .collect(Collectors.toList());
        specializationList.add("");
               
        ComboBoxModel<String> specializationModel = new DefaultComboBoxModel<>(specializationList.toArray(String[]::new));
        comboSpecializations.setModel(specializationModel);
        
        resetFilters();
        
        initializeProjectsTableData();
    }

    private void initializeProjectsTableData() {
        
        int size = projects.size();
        int [] count = {0};
        String[][] tableData = new String[size][8];
        projects.forEach(item -> {
            String [] i = item.split(MiniProjectManagementSystem.FILE_DELIMITER);
            tableData[count[0]][0] = i[0];
            tableData[count[0]][1] = i[1];
            tableData[count[0]][2] = i[4];
            tableData[count[0]][3] = i[5];
            tableData[count[0]][4] = i[6];
            tableData[count[0]][5] = i[7];
            tableData[count[0]][6] = i[8];
            tableData[count[0]][7] = i[9];
            count[0] += 1;
        });
        
        
        DefaultTableModel model = new DefaultTableModel(tableData, header);
        projectsTable.setModel(model);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboLecturers = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboSpecializations = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        checkUnassigned = new javax.swing.JCheckBox();
        checkAssigned = new javax.swing.JCheckBox();
        checkActive = new javax.swing.JCheckBox();
        checkInactive = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnReset = new javax.swing.JButton();
        btnGenerate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectsTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 102, 102));
        setMinimumSize(new java.awt.Dimension(970, 890));
        setPreferredSize(new java.awt.Dimension(970, 890));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        jLabel1.setText("Filters:");

        comboLecturers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboLecturers.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel2.setText("Choose Lecturer:");

        comboSpecializations.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSpecializations.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Courier 10 Pitch", 2, 14)); // NOI18N
        jLabel3.setText("Choose Specialization:");

        checkUnassigned.setText("un assigned");
        checkUnassigned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkUnassignedActionPerformed(evt);
            }
        });

        checkAssigned.setText("assigned");
        checkAssigned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAssignedActionPerformed(evt);
            }
        });

        checkActive.setText("active");
        checkActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActiveActionPerformed(evt);
            }
        });

        checkInactive.setText("in-active");
        checkInactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInactiveActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnReset.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        btnReset.setText("reset");
        btnReset.setFocusable(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnGenerate.setBackground(new java.awt.Color(255, 204, 0));
        btnGenerate.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        btnGenerate.setText("Generate");
        btnGenerate.setFocusable(false);
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(comboLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(comboSpecializations, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(checkAssigned)
                    .addComponent(checkUnassigned)
                    .addComponent(checkActive)
                    .addComponent(checkInactive))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(654, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(165, 165, 165)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {checkActive, checkAssigned, checkInactive, checkUnassigned});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGenerate, btnReset});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(checkUnassigned))
                            .addComponent(checkAssigned)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnReset)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(comboSpecializations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(checkInactive))
                        .addComponent(checkActive))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGenerate)
                        .addGap(37, 37, 37)))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jSeparator1))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(58, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {checkActive, checkAssigned, checkInactive, checkUnassigned});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGenerate, btnReset});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        projectsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(projectsTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkAssignedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAssignedActionPerformed
        checkUnassigned.setSelected(false);
    }//GEN-LAST:event_checkAssignedActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetFilters();
        projects = MiniProjectManagementSystem.getData(PROJECT_TXT_FILE);
        projects.remove(0);
        initializeProjectsTableData();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        
        projects = MiniProjectManagementSystem.getData(PROJECT_TXT_FILE);
        projects.remove(0);
        
        String lecturer = (String) comboLecturers.getSelectedItem();
        String specialization = (String) comboSpecializations.getSelectedItem();
        boolean isAssigned = checkAssigned.isSelected();
        boolean isUnAssigned = checkUnassigned.isSelected();
        boolean isActive = checkActive.isSelected();
        boolean isInActive = checkInactive.isSelected();
        
        if (!lecturer.isEmpty() && !lecturer.isBlank()){
            projects = projects.stream()
                    .filter(project -> project.split(MiniProjectManagementSystem.FILE_DELIMITER)[7].equalsIgnoreCase(lecturer.split(":")[0]))
                    .collect(Collectors.toList());
        }
        
        if (!specialization.isEmpty() && !specialization.isBlank()){
            projects = projects.stream()
                    .filter(project -> project.split(MiniProjectManagementSystem.FILE_DELIMITER)[8].equalsIgnoreCase(specialization))
                    .collect(Collectors.toList());
        }
        
        if (isAssigned) {
            projects = projects.stream()
                    .filter(project -> project.split(MiniProjectManagementSystem.FILE_DELIMITER)[5].equalsIgnoreCase(String.valueOf(isAssigned)))
                    .collect(Collectors.toList());
        }
        
        if (isUnAssigned) {
            projects = projects.stream()
                    .filter(project -> project.split(MiniProjectManagementSystem.FILE_DELIMITER)[5].equalsIgnoreCase(String.valueOf(!isUnAssigned)))
                    .collect(Collectors.toList());
        }
        
        if (isActive) {
            projects = projects.stream()
                    .filter(project -> project.split(MiniProjectManagementSystem.FILE_DELIMITER)[9].equalsIgnoreCase(String.valueOf(isActive)))
                    .collect(Collectors.toList());
        }
        
        if (isInActive) {
            projects = projects.stream()
                    .filter(project -> project.split(MiniProjectManagementSystem.FILE_DELIMITER)[9].equalsIgnoreCase(String.valueOf(!isInActive)))
                    .collect(Collectors.toList());
        }
        
        initializeProjectsTableData(); // refresh
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void checkUnassignedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkUnassignedActionPerformed
        checkAssigned.setSelected(false);
    }//GEN-LAST:event_checkUnassignedActionPerformed

    private void checkActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActiveActionPerformed
        checkInactive.setSelected(false);
    }//GEN-LAST:event_checkActiveActionPerformed

    private void checkInactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInactiveActionPerformed
        checkActive.setSelected(false);
    }//GEN-LAST:event_checkInactiveActionPerformed

    private void resetFilters() {
        comboSpecializations.setSelectedItem("");
        comboLecturers.setSelectedItem("");
        checkActive.setSelected(false);
        checkUnassigned.setSelected(false);
        checkAssigned.setSelected(false);
        checkInactive.setSelected(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnReset;
    private javax.swing.JCheckBox checkActive;
    private javax.swing.JCheckBox checkAssigned;
    private javax.swing.JCheckBox checkInactive;
    private javax.swing.JCheckBox checkUnassigned;
    private javax.swing.JComboBox<String> comboLecturers;
    private javax.swing.JComboBox<String> comboSpecializations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable projectsTable;
    // End of variables declaration//GEN-END:variables
}
