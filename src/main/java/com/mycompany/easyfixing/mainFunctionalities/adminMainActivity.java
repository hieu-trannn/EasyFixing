/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.easyfixing.mainFunctionalities;

import com.mycompany.easyfixing.mainFunctionalities.AdminUpdateDatabase.AdminAddNewWorker;
import com.mycompany.easyfixing.mainFunctionalities.AdminUpdateDatabase.AdminDeleteWorker;
import com.mycompany.easyfixing.mainFunctionalities.AdminUpdateDatabase.AdminUpdateWorkerService;

/**
 *
 * @author hieut
 */
public class adminMainActivity extends javax.swing.JFrame {

    /**
     * Creates new form mainActivity
     */
    public adminMainActivity() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AdminPanel = new javax.swing.JPanel();
        adminNameLabel = new javax.swing.JLabel();
        infoManaBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        notificationBellBtn = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        addInfoBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        AdminPanel.setBackground(new java.awt.Color(255, 255, 255));
        AdminPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 0, 51)));

        adminNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        adminNameLabel.setForeground(new java.awt.Color(255, 0, 0));
        adminNameLabel.setText("Admin");
        adminNameLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        infoManaBtn.setBorder(null);
        infoManaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoManaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdminPanelLayout = new javax.swing.GroupLayout(AdminPanel);
        AdminPanel.setLayout(AdminPanelLayout);
        AdminPanelLayout.setHorizontalGroup(
            AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminPanelLayout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(adminNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(AdminPanelLayout.createSequentialGroup()
                .addComponent(infoManaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AdminPanelLayout.setVerticalGroup(
            AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminPanelLayout.createSequentialGroup()
                .addComponent(infoManaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adminNameLabel)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        notificationBellBtn.setBorder(null);
        notificationBellBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationBellBtnActionPerformed(evt);
            }
        });

        welcomeLabel.setFont(new java.awt.Font("Goudy Old Style", 2, 48)); // NOI18N
        welcomeLabel.setText("Welcome Admin!");

        addInfoBtn.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        addInfoBtn.setText("Add Information");
        addInfoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInfoBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        updateBtn.setText("Update Information");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        deleteBtn.setText("Delete Information");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(deleteBtn)
                    .addComponent(updateBtn)
                    .addComponent(addInfoBtn)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(notificationBellBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(notificationBellBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(addInfoBtn)
                .addGap(52, 52, 52)
                .addComponent(deleteBtn)
                .addGap(47, 47, 47)
                .addComponent(updateBtn)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //
//    private ImageIcon getScaledIcon(ImageIcon originalIcon, int desiredWidth, int desiredHeight) {
//        // Get the original image from the icon
//        Image originalImage = originalIcon.getImage();
//
//        // Create a scaled version of the image
//        Image scaledImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
//
//        // Create a new ImageIcon from the scaled image
//        return new ImageIcon(scaledImage);
//    }
    //
    private void notificationBellBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationBellBtnActionPerformed
        // TODO add your handling code here:
        //        ImageIcon noNotificationIcon = new ImageIcon("C:\\Users\\hieut\\Documents\\NetBeansProjects\\EasyFixing\\src\\main\\java\\com\\mycompany\\easyfixing\\mainFunctionalities\\icon\\bell.png");
        //        // Specify the desired size for the image
        //        int desiredWidth = 50;
        //        int desiredHeight = 50;
        //        ImageIcon scaledIcon = getScaledIcon(noNotificationIcon, desiredWidth, desiredHeight);
        //        notificationBellBtn.setIcon(scaledIcon);
    }//GEN-LAST:event_notificationBellBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        // chnage interface to admin delete worker
        AdminUpdateWorkerService AdminUpdateWorkerFrame = new AdminUpdateWorkerService();
        AdminUpdateWorkerFrame.setVisible(true);
        AdminUpdateWorkerFrame.pack(); //cause Window be sized to fix layout size
        AdminUpdateWorkerFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void infoManaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoManaBtnActionPerformed
        // TODO add your handling code here:
        
        // TODO: get present information
        
        // change interface to admin personal information update interface
        UserPersonalInformation adminInfoFrame = new UserPersonalInformation();
        adminInfoFrame.setVisible(true);
        adminInfoFrame.pack(); //cause Window be sized to fix layout size
        adminInfoFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_infoManaBtnActionPerformed

    private void addInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInfoBtnActionPerformed
        // TODO add your handling code here:
         // change interface to admin add new worker interface
        AdminAddNewWorker adminAddFrame = new AdminAddNewWorker();
        adminAddFrame.setVisible(true);
        adminAddFrame.pack(); //cause Window be sized to fix layout size
        adminAddFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_addInfoBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        // change interface to admin delete worker
        AdminDeleteWorker AdminDeleteWorkerFrame = new AdminDeleteWorker();
        AdminDeleteWorkerFrame.setVisible(true);
        AdminDeleteWorkerFrame.pack(); //cause Window be sized to fix layout size
        AdminDeleteWorkerFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_deleteBtnActionPerformed

    public javax.swing.JButton getNoticeBtn()
    {
        return this.notificationBellBtn;
    }
    /**
     * @return 
     */
    public javax.swing.JPanel getAvaJPanel()
    {
        return this.AdminPanel;
    }
    
    public javax.swing.JButton getAvaBtn()
    {
        return this.infoManaBtn;
    }   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdminPanel;
    private javax.swing.JButton addInfoBtn;
    private javax.swing.JLabel adminNameLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton infoManaBtn;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JButton notificationBellBtn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
