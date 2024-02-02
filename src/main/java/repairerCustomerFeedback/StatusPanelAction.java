/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package repairerCustomerFeedback;

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
    }
    public void addEventCusDoneFb(ActionListener event) {
        btnAccept.addActionListener(event);
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

        setBackground(new java.awt.Color(255, 255, 255));

        btnAccept.setText("View");
        btnAccept.setBorderColor(new java.awt.Color(87, 173, 97));
        btnAccept.setColorClick(new java.awt.Color(134, 219, 145));
        btnAccept.setColorOver(new java.awt.Color(212, 250, 217));
        btnAccept.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        btnAccept.setRadius(20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAccept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.NPLinkButton btnAccept;
    // End of variables declaration//GEN-END:variables
}
