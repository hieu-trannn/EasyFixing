/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package accountManagement;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import login.AuthenPanel;
import login.LoginPanel;
import ultis.Database;

/**
 *
 * @author hieut
 */
public class UpdateInformation extends javax.swing.JPanel {

    private int idWard;

    /**
     * Creates new form UpdateInformation
     * @throws java.sql.SQLException
     */
    public UpdateInformation(int userid) throws SQLException {
        UserID = userid;
        initComponents();
        getInformation();
        updateProvince();
        labelWarning.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void getInformation() throws SQLException
    {
        Database db = new Database();
        String email = db.getEmail(getUserID());
        fixEmail.setText(email);
        String name = db.getName(getUserID());
        txtName.setText(name);
        String pwd = db.getPassword(getUserID());
        txtPass.setText(pwd);
        String citizenNum = db.getCitizenNum(getUserID());
        txtCCCD.setText(citizenNum);
        String phoneNum = db.getPhoneNum(getUserID());
        txtPhone.setText(phoneNum);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new swing.NPLinkTextField();
        btnUpdate = new swing.NPLinkButton();
        jLabel5 = new javax.swing.JLabel();
        txtCCCD = new swing.NPLinkTextField();
        jDateDoB = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new swing.NPLinkTextField();
        jLabel7 = new javax.swing.JLabel();
        boxProvince = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        boxDistrict = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        boxWard = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtSpecifiedAddress = new swing.NPLinkTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPass = new swing.NPLinkTextField();
        jLabel12 = new javax.swing.JLabel();
        labelWarning = new javax.swing.JLabel();
        fixEmail = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1115, 841));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setText("Full Name");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel2.setText("Date of Birth");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 65)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("UPDATE INFORMATION");

        txtName.setBorderFocus(new java.awt.Color(232, 158, 39));
        txtName.setBorderOff(new java.awt.Color(204, 204, 204));
        txtName.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setBorderColor(new java.awt.Color(247, 205, 139));
        btnUpdate.setColor(new java.awt.Color(250, 229, 199));
        btnUpdate.setColorClick(new java.awt.Color(250, 229, 199));
        btnUpdate.setColorOver(new java.awt.Color(247, 205, 139));
        btnUpdate.setFont(new java.awt.Font("Liberation Sans", 0, 30)); // NOI18N
        btnUpdate.setRadius(37);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel5.setText("Citizen number");

        txtCCCD.setBorderFocus(new java.awt.Color(232, 158, 39));
        txtCCCD.setBorderOff(new java.awt.Color(204, 204, 204));
        txtCCCD.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCCDActionPerformed(evt);
            }
        });

        jDateDoB.setBackground(new java.awt.Color(255, 255, 255));
        jDateDoB.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jDateDoB.setMaxSelectableDate(new java.util.Date(253370743263000L));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel6.setText("Phone number");

        txtPhone.setBorderFocus(new java.awt.Color(232, 158, 39));
        txtPhone.setBorderOff(new java.awt.Color(204, 204, 204));
        txtPhone.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel7.setText("Address:");

        boxProvince.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        boxProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxProvinceActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel8.setText("Province");

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel9.setText("District");

        boxDistrict.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        boxDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDistrictActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel10.setText("Ward");

        boxWard.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        boxWard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxWardActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel11.setText("Specified");

        txtSpecifiedAddress.setBorderFocus(new java.awt.Color(232, 158, 39));
        txtSpecifiedAddress.setBorderOff(new java.awt.Color(204, 204, 204));
        txtSpecifiedAddress.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtSpecifiedAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSpecifiedAddressActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel4.setText("Email");

        txtPass.setBorderFocus(new java.awt.Color(232, 158, 39));
        txtPass.setBorderOff(new java.awt.Color(204, 204, 204));
        txtPass.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel12.setText("Pass");

        labelWarning.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        labelWarning.setForeground(new java.awt.Color(255, 0, 51));
        labelWarning.setText("Please provide all nedded information!");

        fixEmail.setBackground(new java.awt.Color(204, 204, 204));
        fixEmail.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        fixEmail.setForeground(new java.awt.Color(255, 51, 51));
        fixEmail.setText("<user fixed email>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateDoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(fixEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxDistrict, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boxProvince, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boxWard, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSpecifiedAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelWarning)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(0, 0, 0)
                        .addComponent(jDateDoB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(fixEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(boxProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxWard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSpecifiedAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelWarning)
                .addGap(20, 20, 20)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtCCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCCDActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed
    public void addEventUpdateConfirm(ActionListener event) {
        btnUpdate.addActionListener(event);
    }

    public boolean checkInfor() throws SQLException {
        String name, cccd, phone, pass, specifiedAddress;
        Date dob;

        name = txtName.getText();
        cccd = txtCCCD.getText();
        phone = txtPhone.getText();
        dob = jDateDoB.getDate();
//        email = txtEmail.getText();
        pass = txtPass.getText();
        specifiedAddress = txtSpecifiedAddress.getText();

        if (name.isEmpty() || cccd.isEmpty() || phone.isEmpty() || (dob == null) || pass.isEmpty() || specifiedAddress.isEmpty() || (boxWard.getSelectedIndex() == -1)) {
            labelWarning.setText("Please provide all needed information correctly!");
            labelWarning.setVisible(true);
            return false;
        } else {
            return true;
        }
    }

    public boolean updateInformation() throws SQLException {
        if (checkInfor()) {
            Database dtb_query = new Database();
            SimpleDateFormat dateFormated = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtb_query.updateCustomer(txtName.getText(), txtSpecifiedAddress.getText(), txtPhone.getText(),txtPass.getText(), fixEmail.getText(), txtCCCD.getText(), idWard,  dateFormated.format(jDateDoB.getDate()), getUserID());
                JOptionPane.showMessageDialog(this, "Update information successfully");
                return true;
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(AuthenPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return false;
        }
        return false;
    }

    private void updateProvince() {
        Database dtb_query = new Database();
        try {
            Vector provinceData = dtb_query.getProvince();
            boxProvince.setModel(new DefaultComboBoxModel(provinceData));
        } catch (SQLException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateDistrict(String province) {
        Database dtb_query = new Database();
        try {
            Vector districtData = dtb_query.getDistrict(province);
            boxDistrict.setModel(new DefaultComboBoxModel(districtData));
        } catch (SQLException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateWard(String district) {
        Database dtb_query = new Database();
        try {
            Vector wardData = dtb_query.getWard(district);
            boxWard.setModel(new DefaultComboBoxModel(wardData));
        } catch (SQLException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void boxProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxProvinceActionPerformed
        // TODO add your handling code here:
        String selectedProvince = (String) boxProvince.getSelectedItem();
        updateDistrict(selectedProvince);
    }//GEN-LAST:event_boxProvinceActionPerformed

    private void boxDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDistrictActionPerformed
        // TODO add your handling code here:
        String selectedDistrict = (String) boxDistrict.getSelectedItem();
        updateWard(selectedDistrict);
    }//GEN-LAST:event_boxDistrictActionPerformed

    private void boxWardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxWardActionPerformed
        // TODO add your handling code here:
        String selectedWard = (String) boxWard.getSelectedItem();
        Database dtb_query = new Database();
        try {
            idWard = dtb_query.getWardID(selectedWard);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_boxWardActionPerformed

    private void txtSpecifiedAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpecifiedAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSpecifiedAddressActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    public int getUserID() {
        return this.UserID;
    }

    public void setUserID(int userid) {
        this.UserID = userid;
    }

    private int UserID;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxDistrict;
    private javax.swing.JComboBox boxProvince;
    private javax.swing.JComboBox<String> boxWard;
    private swing.NPLinkButton btnUpdate;
    private javax.swing.JLabel fixEmail;
    private com.toedter.calendar.JDateChooser jDateDoB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelWarning;
    private swing.NPLinkTextField txtCCCD;
    private swing.NPLinkTextField txtName;
    private swing.NPLinkTextField txtPass;
    private swing.NPLinkTextField txtPhone;
    private swing.NPLinkTextField txtSpecifiedAddress;
    // End of variables declaration//GEN-END:variables
}
