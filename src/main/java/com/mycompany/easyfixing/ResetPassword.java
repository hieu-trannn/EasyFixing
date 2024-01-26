/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.easyfixing;

import com.mycompany.easyfixing.mainFunctionalities.database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hieut
 */
public class ResetPassword extends javax.swing.JFrame {

    /**
     * Creates new form ForgetPassword
     *
     * @param usermail
     * @param randomkey
     */
    public ResetPassword(String usermail) {
        initComponents();
        UserMail = usermail;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        newPwd = new javax.swing.JLabel();
        UserInputNewPwd = new javax.swing.JTextField();
        authenBtn = new javax.swing.JButton();
        CfnewPassword = new javax.swing.JLabel();
        UserInputNewPassCf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(0, 102, 102));
        Title.setText("Reset Password");

        newPwd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newPwd.setText("New Password");

        UserInputNewPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserInputNewPwdActionPerformed(evt);
            }
        });

        authenBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        authenBtn.setForeground(new java.awt.Color(255, 51, 51));
        authenBtn.setText("Update");
        authenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authenBtnActionPerformed(evt);
            }
        });

        CfnewPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CfnewPassword.setText("Confirm new password");

        UserInputNewPassCf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserInputNewPassCfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(Title)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(newPwd)
                        .addContainerGap(592, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UserInputNewPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(authenBtn)
                                        .addGap(38, 38, 38))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CfnewPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(UserInputNewPassCf, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPwd)
                    .addComponent(UserInputNewPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CfnewPassword)
                    .addComponent(UserInputNewPassCf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(authenBtn)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserInputNewPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInputNewPwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInputNewPwdActionPerformed

    private void authenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authenBtnActionPerformed
        // TODO add your handling code here:
        // check if user authen input is similar to authentication code
        database db = new database();
        if (UserInputNewPwd.getText().equals(UserInputNewPassCf.getText())) {
            try {
                //TODO: update database
                db.updatePassword(UserMail, UserInputNewPassCf.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ResetPassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        } else {
            JOptionPane.showMessageDialog(this, "Inconsistent Password, please refill!");
        }
        //come back to login
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack(); //cause Window be sized to fix layout size
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_authenBtnActionPerformed

    private void UserInputNewPassCfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInputNewPassCfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserInputNewPassCfActionPerformed
    private String UserMail;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CfnewPassword;
    private javax.swing.JLabel Title;
    private javax.swing.JTextField UserInputNewPassCf;
    private javax.swing.JTextField UserInputNewPwd;
    private javax.swing.JButton authenBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel newPwd;
    // End of variables declaration//GEN-END:variables
}
