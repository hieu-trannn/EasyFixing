/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package login;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ultis.Ca4JDBCMaven;

/**
 *
 * @author delini
 */
public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();
        labelWrongUser.setVisible(false);
    }

    public void login() {
        txtEmail.grabFocus();
        labelWrongUser.setVisible(false);
    }

    public void addEventRegister(ActionListener event) {
        btnRegister.addActionListener(event);
    }

    public void addEventResetPass(ActionListener event) {
        btnResetPass.addActionListener(event);
    }

    public String getUserEmail() {
        return txtEmail.getText();
    }

    public boolean checkEmail() {
        String email = getUserEmail();
        if (email.isEmpty()) {
            labelWrongUser.setText("Please fill email account to reset password!");
            labelWrongUser.setVisible(true);
            return false;
        } else {
            Ca4JDBCMaven dtb_query = new Ca4JDBCMaven();
            try {
                boolean id = dtb_query.checkEmailExistence(email);
                if (!id) {
                    labelWrongUser.setText("Your email is not existed!");
                    labelWrongUser.setVisible(true);
                    return false;
                } else {
                    labelWrongUser.setVisible(false);
                    return true;
                }
                // Jump to main screen
            } catch (SQLException ex) {
                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new swing.NPLinkTextField();
        txtPass = new swing.PasswordText();
        btnLogin = new swing.NPLinkButton();
        jLabel4 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnResetPass = new javax.swing.JButton();
        labelWrongUser = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setText("Email");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 65)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOGIN");

        txtEmail.setBorderFocus(new java.awt.Color(232, 158, 39));
        txtEmail.setBorderOff(new java.awt.Color(204, 204, 204));
        txtEmail.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtEmail.setPrefixIcon(new javax.swing.ImageIcon("/home/delini/NetBeansProjects/OOAD_maven/src/main/java/icon/mail.png")); // NOI18N

        txtPass.setBorderFocus(new java.awt.Color(232, 158, 39));
        txtPass.setBorderOff(new java.awt.Color(204, 204, 204));
        txtPass.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtPass.setPrefixIcon(new javax.swing.ImageIcon("/home/delini/NetBeansProjects/OOAD_maven/src/main/java/icon/pass.png")); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.setBorderColor(new java.awt.Color(247, 205, 139));
        btnLogin.setColor(new java.awt.Color(250, 229, 199));
        btnLogin.setColorClick(new java.awt.Color(250, 229, 199));
        btnLogin.setColorOver(new java.awt.Color(247, 205, 139));
        btnLogin.setFont(new java.awt.Font("Liberation Sans", 0, 30)); // NOI18N
        btnLogin.setRadius(37);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("(Fill your email first)");

        btnRegister.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(232, 158, 39));
        btnRegister.setText("Register Now");
        btnRegister.setContentAreaFilled(false);
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnResetPass.setFont(new java.awt.Font("Liberation Sans", 2, 20)); // NOI18N
        btnResetPass.setForeground(new java.awt.Color(51, 51, 51));
        btnResetPass.setText("Forget password?");
        btnResetPass.setContentAreaFilled(false);
        btnResetPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResetPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPassActionPerformed(evt);
            }
        });

        labelWrongUser.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        labelWrongUser.setForeground(new java.awt.Color(255, 0, 51));
        labelWrongUser.setText("Incorrect email or password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelWrongUser)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnResetPass)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel4))
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(labelWrongUser)
                .addGap(40, 40, 40)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetPass)
                    .addComponent(jLabel4))
                .addGap(60, 60, 60)
                .addComponent(btnRegister)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String email, pass;
        email = txtEmail.getText();
        pass = txtPass.getText();

        if (pass.isEmpty() || email.isEmpty()) {
            labelWrongUser.setText("Please provide all needed information!");
            labelWrongUser.setVisible(true);
        } else {
            Ca4JDBCMaven dtb_query = new Ca4JDBCMaven();
            try {
                int id = dtb_query.loginUser(email, pass);
                if (id == -1) {
                    labelWrongUser.setText("Incorrect email or password!");
                    labelWrongUser.setVisible(true);
                } else {
                    labelWrongUser.setVisible(false);
                }
                // Jump to main screen
            } catch (SQLException ex) {
                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnResetPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetPassActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.NPLinkButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnResetPass;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelWrongUser;
    private swing.NPLinkTextField txtEmail;
    private swing.PasswordText txtPass;
    // End of variables declaration//GEN-END:variables
}