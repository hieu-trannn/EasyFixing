/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import ultis.database;

/**
 *
 * @author delini
 */
public class ForgetPassPanel extends javax.swing.JPanel {

    /**
     * @return the counterValue
     */
    public int getCounterValue() {
        return counterValue;
    }

    /**
     * @param counterValue the counterValue to set
     */
    public void setCounterValue(int counterValue) {
        this.counterValue = counterValue;
    }

    /**
     * @return the stopTimer
     */
    public boolean isStopTimer() {
        return stopTimer;
    }

    /**
     * @param stopTimer the stopTimer to set
     */
    public void setStopTimer(boolean stopTimer) {
        this.stopTimer = stopTimer;
    }

    /**
     * @return the codeReference
     */
    public int getCodeReference() {
        return codeReference;
    }

    /**
     * @param codeReference the codeReference to set
     */
    public void setCodeReference(int codeReference) {
        this.codeReference = codeReference;
    }

    private int codeReference = 0;
    private String userEmail;
    private int counterValue = 60;
    private boolean stopTimer = false;

    /**
     * Creates new form LoginPanel
     */
    public ForgetPassPanel() {
        initComponents();
    }

    public void resetPass(String email) {
        setStopTimer(false);
        txtCode.grabFocus();
        setUserEmail(email);
        labelEmail.setText(email);
        labelWrongCode.setVisible(false);
        txtPass.setVisible(false);
        setCounterValue(60);
        startCounter();
    }

    public void addEventBackLogin(ActionListener event) {
        btnBackLogin.addActionListener(event);
    }

    private void startCounter() {
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            labelCounter.setText("Time left: 00:" + counterValue);
            if (counterValue > 0) {
                counterValue--;
                if (stopTimer) {
                    ((Timer) (e.getSource())).stop();
                }
            } else {
                showNoti("Out of Time. Please try again!");
                ((Timer) (e.getSource())).stop();
                btnBackLogin.doClick();
            }
        });
        timer.start();
    }

    private void showNoti(String noti) {
        JOptionPane.showMessageDialog(this, noti);
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
        labelEmail = new javax.swing.JLabel();
        labelAsk = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSubmit = new swing.NPLinkButton();
        btnBackLogin = new javax.swing.JButton();
        labelWrongCode = new javax.swing.JLabel();
        labelInstruction = new javax.swing.JLabel();
        txtCode = new swing.NPLinkTextField();
        txtPass = new swing.PasswordText();
        labelCounter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        labelEmail.setFont(new java.awt.Font("Liberation Sans", 3, 20)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(236, 129, 22));
        labelEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmail.setText("email@gmail.com");

        labelAsk.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        labelAsk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAsk.setText("Your code is");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 50)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reset Password");

        btnSubmit.setText("Submit");
        btnSubmit.setBorderColor(new java.awt.Color(247, 205, 139));
        btnSubmit.setColor(new java.awt.Color(250, 229, 199));
        btnSubmit.setColorClick(new java.awt.Color(250, 229, 199));
        btnSubmit.setColorOver(new java.awt.Color(247, 205, 139));
        btnSubmit.setFont(new java.awt.Font("Liberation Sans", 0, 30)); // NOI18N
        btnSubmit.setRadius(37);
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnBackLogin.setFont(new java.awt.Font("Liberation Sans", 1, 27)); // NOI18N
        btnBackLogin.setForeground(new java.awt.Color(232, 158, 39));
        btnBackLogin.setText("Back to Login");
        btnBackLogin.setContentAreaFilled(false);
        btnBackLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackLoginActionPerformed(evt);
            }
        });

        labelWrongCode.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        labelWrongCode.setForeground(new java.awt.Color(255, 0, 51));
        labelWrongCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWrongCode.setText("Incorrect authentication code!");

        labelInstruction.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        labelInstruction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelInstruction.setText("Your code (6 digits) is sent to");

        txtCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCode.setBorderFocus(new java.awt.Color(232, 158, 39));
        txtCode.setBorderOff(new java.awt.Color(204, 204, 204));
        txtCode.setFont(new java.awt.Font("Liberation Sans", 1, 30)); // NOI18N
        txtCode.setIconGap(0);
        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });

        txtPass.setBorderFocus(new java.awt.Color(232, 158, 39));
        txtPass.setBorderOff(new java.awt.Color(204, 204, 204));
        txtPass.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtPass.setPrefixIcon(new javax.swing.ImageIcon("/home/delini/NetBeansProjects/OOAD_maven/src/main/java/icon/pass.png")); // NOI18N

        labelCounter.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        labelCounter.setForeground(new java.awt.Color(255, 0, 51));
        labelCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCounter.setText("Time left:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelCounter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(labelAsk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelInstruction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(btnBackLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelWrongCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(75, 75, 75)
                .addComponent(labelInstruction)
                .addGap(0, 0, 0)
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCounter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAsk)
                .addGap(0, 0, 0)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelWrongCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBackLogin)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        if (txtPass.getText().isEmpty()) {
            int userCode;
            try {
                userCode = Integer.parseInt(txtCode.getText());
            } catch (NumberFormatException e) {
                userCode = 0;
            }

            if ((getCodeReference() != 0) && (userCode == getCodeReference())) {
                stopTimer = true;
                labelWrongCode.setText("Please provide your new password!");
                labelWrongCode.setVisible(true);
                txtCode.setFocusable(false);
                txtPass.setVisible(true);
            } else {
                labelWrongCode.setText("Incorrect authentication code!");
                labelWrongCode.setVisible(true);
                txtPass.setVisible(false);
                txtCode.setText("");
            }
        } else {
            String pass = txtPass.getText();
            database dtb_query = new database();
            try {
                dtb_query.updatePassword(getUserEmail(), pass);
                showNoti("Password updated successfully!");
                btnBackLogin.doClick();
            } catch (SQLException ex) {
                Logger.getLogger(ForgetPassPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackLoginActionPerformed

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackLogin;
    private swing.NPLinkButton btnSubmit;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelAsk;
    private javax.swing.JLabel labelCounter;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelInstruction;
    private javax.swing.JLabel labelWrongCode;
    private swing.NPLinkTextField txtCode;
    private swing.PasswordText txtPass;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
