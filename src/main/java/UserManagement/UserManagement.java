/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserManagement;

/**
 *
 * @author hieut
 */
public class UserManagement extends javax.swing.JPanel {
    private int UserID;
    /**
     * Creates new form UserManagement
     */
    public UserManagement(int userid) {
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

        btnSubmit = new swing.NPLinkButton();
        btnSubmit1 = new swing.NPLinkButton();
        btnSubmit2 = new swing.NPLinkButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1115, 841));

        btnSubmit.setText("Change Password");
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

        btnSubmit1.setText("Delete Account");
        btnSubmit1.setBorderColor(new java.awt.Color(247, 205, 139));
        btnSubmit1.setColor(new java.awt.Color(250, 229, 199));
        btnSubmit1.setColorClick(new java.awt.Color(250, 229, 199));
        btnSubmit1.setColorOver(new java.awt.Color(247, 205, 139));
        btnSubmit1.setFont(new java.awt.Font("Liberation Sans", 0, 30)); // NOI18N
        btnSubmit1.setRadius(37);
        btnSubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit1ActionPerformed(evt);
            }
        });

        btnSubmit2.setText("Update Information");
        btnSubmit2.setBorderColor(new java.awt.Color(247, 205, 139));
        btnSubmit2.setColor(new java.awt.Color(250, 229, 199));
        btnSubmit2.setColorClick(new java.awt.Color(250, 229, 199));
        btnSubmit2.setColorOver(new java.awt.Color(247, 205, 139));
        btnSubmit2.setFont(new java.awt.Font("Liberation Sans", 0, 30)); // NOI18N
        btnSubmit2.setRadius(37);
        btnSubmit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSubmit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSubmit2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
                .addGap(317, 317, 317))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(btnSubmit2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(btnSubmit1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnSubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmit1ActionPerformed

    private void btnSubmit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmit2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmit2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.NPLinkButton btnSubmit;
    private swing.NPLinkButton btnSubmit1;
    private swing.NPLinkButton btnSubmit2;
    // End of variables declaration//GEN-END:variables
}
