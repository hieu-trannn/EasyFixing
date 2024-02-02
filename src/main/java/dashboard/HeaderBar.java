/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dashboard;

import Notifications.DefaultLayoutCallBack;
import Notifications.DefaultOption;
import Notifications.GlassPanePopup;
import Notifications.NotificationUser;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;

/**
 *
 * @author delini
 */
public class HeaderBar extends javax.swing.JPanel {

    /**
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    private int radius = 15;

    /**
     * Creates new form HeaderBar
     */
    public HeaderBar() {
        initComponents();
        setOpaque(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelSearchIcon = new javax.swing.JLabel();
        hintSearchText1 = new swing.HintSearchText();
        cmd = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        hintSearchText1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        hintSearchText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintSearchText1ActionPerformed(evt);
            }
        });

        cmd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/notification.png"))); // NOI18N
        cmd.setBorder(null);
        cmd.setBorderPainted(false);
        cmd.setContentAreaFilled(false);
        cmd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(labelSearchIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hintSearchText1, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSearchIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(hintSearchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hintSearchText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hintSearchText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hintSearchText1ActionPerformed

    private void cmdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActionPerformed
        // TODO add your handling code here:
        GlassPanePopup.showPopup(new NotificationUser(1), new DefaultOption(){
            @Override
            public float opacity(){
                return 0;
            }

            @Override
            public LayoutCallback getLayoutCallback(Component parent) {
                return new DefaultLayoutCallBack(parent){
                    @Override
                    public void correctBounds(ComponentWrapper cw){
                        if (getParent().isVisible()){
                            Point pl = parent.getLocationOnScreen();
                            Point bl = cmd.getLocationOnScreen();
                            int x = bl.x - pl.x;
                            int y = bl.y - pl.y;
                            y += (1f- getAnimate()) * 10f;
                            cw.setBounds(x- cw.getWidth() + cmd.getWidth(), y + cmd.getHeight(), cw.getWidth(), cw.getHeight());
                        }
                        else{
                            super.correctBounds(cw);
                        }
                       
                    }
                };
            }
            
            
        });
    }//GEN-LAST:event_cmdActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), getRadius(), getRadius());
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd;
    private swing.HintSearchText hintSearchText1;
    private javax.swing.JLabel labelSearchIcon;
    // End of variables declaration//GEN-END:variables
}
