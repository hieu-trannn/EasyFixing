/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package accountManagement;

import java.awt.event.ActionListener;

/**
 *
 * @author hieut
 */
public class ChangePassword extends javax.swing.JPanel {

    /**
     * Creates new form ChangePassword
     */
    public ChangePassword(int userid) {
        initComponents();
        UserID = userid;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPass = new swing.NPLinkTextField();
        btnCfChangePwd = new swing.NPLinkButton();
        jLabel2 = new javax.swing.JLabel();
        txtRePass = new swing.NPLinkTextField();
        labelWrongPass = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 65)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Change Password");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setText("Please input your new password");

        txtPass.setBorderFocus(new java.awt.Color(232, 158, 39));
        txtPass.setBorderOff(new java.awt.Color(204, 204, 204));
        txtPass.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        btnCfChangePwd.setText("Confirm");
        btnCfChangePwd.setBorderColor(new java.awt.Color(247, 205, 139));
        btnCfChangePwd.setColor(new java.awt.Color(250, 229, 199));
        btnCfChangePwd.setColorClick(new java.awt.Color(250, 229, 199));
        btnCfChangePwd.setColorOver(new java.awt.Color(247, 205, 139));
        btnCfChangePwd.setFont(new java.awt.Font("Liberation Sans", 0, 30)); // NOI18N
        btnCfChangePwd.setRadius(37);
        btnCfChangePwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCfChangePwdActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel2.setText("Input your password again");

        txtRePass.setBorderFocus(new java.awt.Color(232, 158, 39));
        txtRePass.setBorderOff(new java.awt.Color(204, 204, 204));
        txtRePass.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtRePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRePassActionPerformed(evt);
            }
        });

        labelWrongPass.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelWrongPass.setForeground(new java.awt.Color(255, 0, 51));
        labelWrongPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(txtRePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCfChangePwd, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelWrongPass, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel3)
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelWrongPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnCfChangePwd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnCfChangePwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCfChangePwdActionPerformed
        // if pressed update info -> update info panel
        // if pressed change password -> change pwd panel
    }//GEN-LAST:event_btnCfChangePwdActionPerformed

    private void txtRePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRePassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRePassActionPerformed

    public void addEventConfirm(ActionListener event) {
        btnCfChangePwd.addActionListener(event);
    }
    public int getUserID()
    {
        return this.UserID;
    }
    public void setUserID(int userid)
    {
        this.UserID = userid;
    }
    public String getNewPassword()
    {
        return txtPass.getText();
    }
    public void setLabelWrongPass(String text, Boolean visible) {
        if (text != null) {
            labelWrongPass.setText(text);
        }
        if (visible != null) {
            labelWrongPass.setVisible(visible);
        }
    }
    public String getRepeatNewPassword()
    {
        return txtRePass.getText();
    }
    private int UserID;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.NPLinkButton btnCfChangePwd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelWrongPass;
    private swing.NPLinkTextField txtPass;
    private swing.NPLinkTextField txtRePass;
    // End of variables declaration//GEN-END:variables
}
