/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package repairerCurrentOrder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author delini
 */
public class StatusPanelAction extends javax.swing.JPanel {

    /**
     * Creates new form StatusPanelAction
     */
    public StatusPanelAction() {
        initComponents();
    }

    public void initEvent(TableActionEvent event, int row) {
        btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onAccept(row);
            }
        });
        
        btnRefuse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onRefuse(row);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAccept = new swing.NPLinkButton();
        btnRefuse = new swing.NPLinkButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnAccept.setText("Accept");
        btnAccept.setBorderColor(new java.awt.Color(87, 173, 97));
        btnAccept.setColorClick(new java.awt.Color(134, 219, 145));
        btnAccept.setColorOver(new java.awt.Color(212, 250, 217));
        btnAccept.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        btnAccept.setRadius(20);

        btnRefuse.setText("Reject");
        btnRefuse.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        btnRefuse.setRadius(20);
        btnRefuse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefuseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnRefuse, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefuse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefuseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefuseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefuseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.NPLinkButton btnAccept;
    private swing.NPLinkButton btnRefuse;
    // End of variables declaration//GEN-END:variables
}
