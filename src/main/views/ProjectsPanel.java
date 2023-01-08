package main.views;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.MiniProjectManagementSystem;

/**
 *
 * @author chris
 */
public class ProjectsPanel extends javax.swing.JPanel {
    
    private final String PROJECT_TXT_FILE = MiniProjectManagementSystem.PROJECT_TXT_FILE;
    List<String> projects = new ArrayList<>();
    JFrame projectsFrame = new JFrame();

    /**
     * Creates new form ProjectsPanel
     */
    public ProjectsPanel(JFrame currentFrame) {
        initComponents();
        
        btnAddProject.setFocusable(false);
        btnDeleteProject.setFocusable(false);
        btnEditProject.setFocusable(false);
        
        initializeProjectsTableData();
        
        if (currentFrame != null){
            projectsFrame = currentFrame;
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAddProject = new javax.swing.JButton();
        btnDeleteProject = new javax.swing.JButton();
        btnEditProject = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectsTable = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(970, 867));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel1.setText("Projects");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAddProject.setBackground(new java.awt.Color(255, 204, 0));
        btnAddProject.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnAddProject.setText("Add");
        btnAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjectActionPerformed(evt);
            }
        });

        btnDeleteProject.setBackground(new java.awt.Color(255, 51, 0));
        btnDeleteProject.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnDeleteProject.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteProject.setText("Delete");
        btnDeleteProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProjectActionPerformed(evt);
            }
        });

        btnEditProject.setBackground(new java.awt.Color(0, 0, 0));
        btnEditProject.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnEditProject.setForeground(new java.awt.Color(255, 255, 255));
        btnEditProject.setText("Edit");
        btnEditProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnAddProject)
                .addGap(82, 82, 82)
                .addComponent(btnDeleteProject, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(btnEditProject, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProject)
                    .addComponent(btnDeleteProject)
                    .addComponent(btnEditProject))
                .addContainerGap(17, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProjectActionPerformed
        // close the current frame
        projectsFrame.dispose();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProjectFrame().setVisible(true);
            }});
    }//GEN-LAST:event_btnAddProjectActionPerformed

    private void btnDeleteProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProjectActionPerformed
        int [] selectedRows =  projectsTable.getSelectedRows();
        if(selectedRows == null || selectedRows.length == 0) {
            JOptionPane.showMessageDialog(null, "Please select the projects you wish to delete", "Project Deletion", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        for(int rowId: selectedRows) {
            int recordId = getProjectId(rowId);
            try{
                boolean isDeleted = MiniProjectManagementSystem.deleteRecordById(recordId, PROJECT_TXT_FILE);
                if(isDeleted) {
                    JOptionPane.showMessageDialog(null, "Project Succesfully deleted", "Project Deletion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error Deleting project, try again", "Project Deletion", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Project Deletion", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        initializeProjectsTableData();
    }//GEN-LAST:event_btnDeleteProjectActionPerformed

    private void btnEditProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProjectActionPerformed
        int [] selectedRows =  projectsTable.getSelectedRows();
        if(selectedRows == null || selectedRows.length == 0) {
            JOptionPane.showMessageDialog(null, "Please select the projects you wish to edit", "Edit Deletion", JOptionPane.ERROR_MESSAGE);
        } else if (selectedRows.length > 1) {
            JOptionPane.showMessageDialog(null, "Please select a single projects you wish to edit", "Edit Project", JOptionPane.ERROR_MESSAGE);
        } else {
            int projectId = getProjectId(selectedRows[0]);
            System.out.println(projectId);
            if (projectId > 0){
                // close the current frame first
                projectsFrame.dispose();
                // open new frame
                new AddProjectFrame().editProject(projectId);
            }
        }
    }//GEN-LAST:event_btnEditProjectActionPerformed

    private int getProjectId(int selectedRow) throws NumberFormatException {
        final String selectedProject = projects.get(selectedRow);
        if( selectedProject != null && !selectedProject.isBlank() && !selectedProject.isEmpty()){
            return Integer.parseInt(selectedProject.split(MiniProjectManagementSystem.FILE_DELIMITER)[0]);
        }
        return -1;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProject;
    private javax.swing.JButton btnDeleteProject;
    private javax.swing.JButton btnEditProject;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable projectsTable;
    // End of variables declaration//GEN-END:variables

    private void initializeProjectsTableData() {
        projects = MiniProjectManagementSystem.getData(PROJECT_TXT_FILE);
        String[] header = new String[]{};
        if(!projects.isEmpty()){
            header = Stream.of(projects.get(0).split(MiniProjectManagementSystem.FILE_DELIMITER)).filter(item -> !(item.contains("Content") || item.contains("Desc"))).toArray(String[]::new);
            projects.remove(0);
        }
        
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
        
//        projectsTable.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e){
//                projectsFrame.dispose();
//                int[] rowId = projectsTable.getSelectedRows();
//                System.out.println(Arrays.toString(rowId));
//            }
//        });
    }
}
