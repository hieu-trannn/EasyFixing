/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author delini
 */
public class AuthenPanel extends javax.swing.JPanel {

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
    private String userEmail, name, specifiedAddress, phone, pass, cccd, idWard, dobFormated;

    /**
     * Creates new form LoginPanel
     */
    public AuthenPanel() {
        initComponents();
        labelWrongCode.setVisible(false);
    }

    public void authen(Vector<String> data) {
        getTxtCode().grabFocus();
        setName(data.get(0));
        setSpecifiedAddress(data.get(1));
        setPhone(data.get(2));
        setPass(data.get(3));
        setUserEmail(data.get(4));
        setCccd(data.get(5));
        setIdWard(data.get(6));
        setDobFormated(data.get(7));
        getLabelEmail().setText(getUserEmail());
        getLabelWrongCode().setVisible(false);
    }

    public void addEventBackRegister(ActionListener event) {
        getBtnBackRegister().addActionListener(event);
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
        btnBackRegister = new javax.swing.JButton();
        labelWrongCode = new javax.swing.JLabel();
        labelInstruction = new javax.swing.JLabel();
        txtCode = new swing.NPLinkTextField();

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
        jLabel3.setText("Authentication");

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

        btnBackRegister.setFont(new java.awt.Font("Liberation Sans", 1, 27)); // NOI18N
        btnBackRegister.setForeground(new java.awt.Color(232, 158, 39));
        btnBackRegister.setText("Back to Register");
        btnBackRegister.setContentAreaFilled(false);
        btnBackRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackRegisterActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelInstruction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBackRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAsk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelWrongCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(90, 90, 90)
                .addComponent(labelInstruction)
                .addGap(0, 0, 0)
                .addComponent(labelEmail)
                .addGap(15, 15, 15)
                .addComponent(labelAsk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelWrongCode)
                .addGap(60, 60, 60)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBackRegister)
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        int userCode;
        userCode = Integer.parseInt(getTxtCode().getText());
        if ((getCodeReference() != 0) && (userCode == getCodeReference())) {
            Ca4JDBCMaven dtb_query = new Ca4JDBCMaven();
            try {
                dtb_query.addCustomer(getName(), getSpecifiedAddress(), getPhone(), getPass(), getUserEmail(), getCccd(), Integer.parseInt(getIdWard()), getDobFormated());
                //Successfull noti
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(AuthenPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            getLabelWrongCode().setText("Incorrect authentication code!");
            getLabelWrongCode().setVisible(true);
            getTxtCode().setText("");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackRegisterActionPerformed

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackRegister;
    private swing.NPLinkButton btnSubmit;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelAsk;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelInstruction;
    private javax.swing.JLabel labelWrongCode;
    private swing.NPLinkTextField txtCode;
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the specifiedAddress
     */
    public String getSpecifiedAddress() {
        return specifiedAddress;
    }

    /**
     * @param specifiedAddress the specifiedAddress to set
     */
    public void setSpecifiedAddress(String specifiedAddress) {
        this.specifiedAddress = specifiedAddress;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the cccd
     */
    public String getCccd() {
        return cccd;
    }

    /**
     * @param cccd the cccd to set
     */
    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    /**
     * @return the idWard
     */
    public String getIdWard() {
        return idWard;
    }

    /**
     * @param idWard the idWard to set
     */
    public void setIdWard(String idWard) {
        this.idWard = idWard;
    }

    /**
     * @return the dobFormated
     */
    public String getDobFormated() {
        return dobFormated;
    }

    /**
     * @param dobFormated the dobFormated to set
     */
    public void setDobFormated(String dobFormated) {
        this.dobFormated = dobFormated;
    }

    /**
     * @return the btnBackRegister
     */
    public javax.swing.JButton getBtnBackRegister() {
        return btnBackRegister;
    }

    /**
     * @param btnBackRegister the btnBackRegister to set
     */
    public void setBtnBackRegister(javax.swing.JButton btnBackRegister) {
        this.btnBackRegister = btnBackRegister;
    }

    /**
     * @return the btnSubmit
     */
    public swing.NPLinkButton getBtnSubmit() {
        return btnSubmit;
    }

    /**
     * @param btnSubmit the btnSubmit to set
     */
    public void setBtnSubmit(swing.NPLinkButton btnSubmit) {
        this.btnSubmit = btnSubmit;
    }

    /**
     * @return the jDateChooser1
     */
    public com.toedter.calendar.JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    /**
     * @param jDateChooser1 the jDateChooser1 to set
     */
    public void setjDateChooser1(com.toedter.calendar.JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }

    /**
     * @return the jLabel3
     */
    public javax.swing.JLabel getjLabel3() {
        return jLabel3;
    }

    /**
     * @param jLabel3 the jLabel3 to set
     */
    public void setjLabel3(javax.swing.JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    /**
     * @return the labelAsk
     */
    public javax.swing.JLabel getLabelAsk() {
        return labelAsk;
    }

    /**
     * @param labelAsk the labelAsk to set
     */
    public void setLabelAsk(javax.swing.JLabel labelAsk) {
        this.labelAsk = labelAsk;
    }

    /**
     * @return the labelEmail
     */
    public javax.swing.JLabel getLabelEmail() {
        return labelEmail;
    }

    /**
     * @param labelEmail the labelEmail to set
     */
    public void setLabelEmail(javax.swing.JLabel labelEmail) {
        this.labelEmail = labelEmail;
    }

    /**
     * @return the labelInstruction
     */
    public javax.swing.JLabel getLabelInstruction() {
        return labelInstruction;
    }

    /**
     * @param labelInstruction the labelInstruction to set
     */
    public void setLabelInstruction(javax.swing.JLabel labelInstruction) {
        this.labelInstruction = labelInstruction;
    }

    /**
     * @return the labelWrongCode
     */
    public javax.swing.JLabel getLabelWrongCode() {
        return labelWrongCode;
    }

    /**
     * @param labelWrongCode the labelWrongCode to set
     */
    public void setLabelWrongCode(javax.swing.JLabel labelWrongCode) {
        this.labelWrongCode = labelWrongCode;
    }

    /**
     * @return the txtCode
     */
    public swing.NPLinkTextField getTxtCode() {
        return txtCode;
    }

    /**
     * @param txtCode the txtCode to set
     */
    public void setTxtCode(swing.NPLinkTextField txtCode) {
        this.txtCode = txtCode;
    }
}
