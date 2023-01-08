package main.views;

import java.awt.Font;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import main.MiniProjectManagementSystem;
import main.enums.RoleEnum;

/**
 *
 * @author 
 */
public class AddProjectFrame extends javax.swing.JFrame {

    private final Logger logger = Logger.getLogger(AddProjectFrame.class.getName());

    private List<String> specializations = new ArrayList<>();
    private final String FILE_DELIMITER = MiniProjectManagementSystem.FILE_DELIMITER;
    private JLabel id = new JLabel();
    private final Font inputFont = new Font("monospaced", Font.PLAIN,18);
    private boolean editProject = false;
    private String[] oldProjectRecord;
    
    /**
     * Creates new form AddProjectFrame
     */
    public AddProjectFrame() {
        initComponents();
        
        // set fonts
        txtTitle.setFont(inputFont);
        
        txtDescription.setFont(inputFont);
        txtDescription.setLineWrap(true);
        
        txtContent.setFont(inputFont);
        txtContent.setLineWrap(true);
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        specializations = MiniProjectManagementSystem.getData(MiniProjectManagementSystem.SPECIALIZATION_TXT_FILE);
        specializations.remove(0); // remove the header
        String[] specializationOptions = specializations.stream()
                .map(specialization -> specialization.split(FILE_DELIMITER)[2])
                .toArray(String[]::new); // get only the specializations' descriptions
        
        ComboBoxModel<String> model = new DefaultComboBoxModel<String>(specializationOptions);
        comboSpecialization.setModel(model);
    }
    
    public void editProject(int projectId) {
        editProject = true;
        oldProjectRecord = MiniProjectManagementSystem.getRecordById(String.valueOf(projectId), MiniProjectManagementSystem.PROJECT_TXT_FILE);
        if (oldProjectRecord.length > 0){
            id.setText(oldProjectRecord[0]);
            txtTitle.setText(oldProjectRecord[1]);
            txtDescription.setText(oldProjectRecord[2].replaceAll("\\<nl\\>", "\n"));
            txtContent.setText(oldProjectRecord[3].replaceAll("\\<nl\\>", "\n"));
            comboSpecialization.setSelectedItem(UsersPanel.getSpecializationDescription(oldProjectRecord[8], specializations, FILE_DELIMITER));
            checkIsHidden.setSelected(oldProjectRecord[9].equalsIgnoreCase("true"));
            
            this.setVisible(true);
            
        }
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel labelDescription = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        javax.swing.JLabel titleLable = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        javax.swing.JLabel labelContent = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        checkIsHidden = new javax.swing.JCheckBox();
        javax.swing.JButton btnSaveProject = new javax.swing.JButton();
        javax.swing.JButton btnCancelProject = new javax.swing.JButton();
        javax.swing.JLabel labelSpecialization = new javax.swing.JLabel();
        comboSpecialization = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(612, 817));

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add New Project");

        labelDescription.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        labelDescription.setText("Description:");

        titleLable.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        titleLable.setText("Title:");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        labelContent.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        labelContent.setText("Content:");

        txtContent.setColumns(20);
        txtContent.setRows(5);
        jScrollPane2.setViewportView(txtContent);

        checkIsHidden.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        checkIsHidden.setText("hide project");

        btnSaveProject.setBackground(new java.awt.Color(0, 153, 0));
        btnSaveProject.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnSaveProject.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveProject.setText("Save");
        btnSaveProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProjectActionPerformed(evt);
            }
        });

        btnCancelProject.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        btnCancelProject.setText("Cancel");
        btnCancelProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelProjectActionPerformed(evt);
            }
        });

        labelSpecialization.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        labelSpecialization.setText("Specialization:");

        comboSpecialization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSpecialization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSpecializationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSpecialization, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(txtTitle)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSaveProject, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(btnCancelProject, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelContent, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLable, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkIsHidden))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(titleLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelContent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(checkIsHidden)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveProject)
                    .addComponent(btnCancelProject))
                .addGap(36, 36, 36))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboSpecialization, labelSpecialization});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProjectActionPerformed
        int nextId = MiniProjectManagementSystem.getNextId(MiniProjectManagementSystem.PROJECT_TXT_FILE);
        String title = txtTitle.getText();
        String description = txtDescription.getText();
        String content = txtContent.getText();
        String specializationShortDesc = UsersPanel.getSpecializationShortDescription((String)comboSpecialization.getSelectedItem(), specializations, FILE_DELIMITER);
        String isActive = checkIsHidden.isSelected() ? "false" : "true";
        
        boolean isSaved = false;
        
        if (!editProject) {
            String newProject = "\n" + nextId + FILE_DELIMITER
                    + title + FILE_DELIMITER
                    + description.replaceAll("[\n]", "<nl>") + FILE_DELIMITER
                    + content.replaceAll("[\n]", "<nl>") + FILE_DELIMITER
                    + LocalDateTime.now().toLocalDate() + FILE_DELIMITER
                    + "false" + FILE_DELIMITER
                    + "null" + FILE_DELIMITER
                    + MiniProjectManagementSystem.loggedInUserId + FILE_DELIMITER
                    + specializationShortDesc + FILE_DELIMITER
                    + isActive;
        
            isSaved = MiniProjectManagementSystem.writeLineToFile(MiniProjectManagementSystem.PROJECT_TXT_FILE,newProject);
        } else if (editProject) {
            String newProject = nextId + FILE_DELIMITER
                    + title + FILE_DELIMITER
                    + description.replaceAll("[\n]", "<nl>") + FILE_DELIMITER
                    + content.replaceAll("[\n]", "<nl>") + FILE_DELIMITER
                    + oldProjectRecord[4] + FILE_DELIMITER
                    + oldProjectRecord[5] + FILE_DELIMITER
                    + oldProjectRecord[6] + FILE_DELIMITER
                    + oldProjectRecord[7] + FILE_DELIMITER
                    + specializationShortDesc + FILE_DELIMITER
                    + isActive;
            isSaved = MiniProjectManagementSystem.updateRecord(Integer.parseInt(id.getText()), newProject,MiniProjectManagementSystem.PROJECT_TXT_FILE);
            editProject = false;
        }
        if(isSaved) {
            this.dispose();
            
            JOptionPane.showMessageDialog(null, "Project Successfully saved." , "Projects", JOptionPane.INFORMATION_MESSAGE);
            
            if(MiniProjectManagementSystem.loggedInUserRole.equalsIgnoreCase(""+RoleEnum.ADMIN.name().charAt(0))){
                new AdminMainFrame().setVisible(true);
            } else if (MiniProjectManagementSystem.loggedInUserRole.equalsIgnoreCase(""+RoleEnum.LECTURER.name().charAt(0))) {
                new StudentLecturerMainFrame().setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error While Saving, try again", "Adding new project", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveProjectActionPerformed

    private void btnCancelProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelProjectActionPerformed
        this.dispose();
        
        if(MiniProjectManagementSystem.loggedInUserRole.equalsIgnoreCase(""+RoleEnum.ADMIN.name().charAt(0))){
            new AdminMainFrame().setVisible(true);
        } else if (MiniProjectManagementSystem.loggedInUserRole.equalsIgnoreCase(""+RoleEnum.LECTURER.name().charAt(0))) {
            new StudentLecturerMainFrame().setVisible(true);
        }
    }//GEN-LAST:event_btnCancelProjectActionPerformed

    private void comboSpecializationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSpecializationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSpecializationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkIsHidden;
    private javax.swing.JComboBox<String> comboSpecialization;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtContent;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
