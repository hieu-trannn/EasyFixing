/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import accountManagement.AccountManagement;
import accountManagement.AuthenticatePassword;
import accountManagement.ChangePassword;
import dashboard.SamplePanel;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import login.LoginPanel;
import ultis.Ca4JDBCMaven;
import ultis.EventMenuSelected;

/**
 *
 * @author delini
 */
public class DashboardAdmin extends javax.swing.JFrame {

    /**
     * Creates new form DashboardAdmin
     */
    // Declare Panel here
    private int userId;
    private SamplePanel panel1, panel2, panel3, panel4, panel5;
    private AccountManagement panelAccMana;
    private AuthenticatePassword panelAuthen = new AuthenticatePassword("");
    private ChangePassword panelChangePass;

    public DashboardAdmin(int userId) {
        initComponents();
        setUserId(userId);
//        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(1440, 900);

        panel1 = new SamplePanel("1");
        panel2 = new SamplePanel("2");
        panel3 = new SamplePanel("3");
        panel4 = new SamplePanel("4");
        panel5 = new SamplePanel("5");
        panelAccMana = new AccountManagement(getUserId());
        panelChangePass = new ChangePassword(getUserId());
        
        menu.initMoving(DashboardAdmin.this);

        menu.addEventMenuSelected(
                new EventMenuSelected() {
            @Override
            public void selected(int index
            ) {
                switch (index) {
                    case 1:
                        setPanel(panel1);
                        break;
                    case 2:
                        setPanel(panel2);
                        break;
                    case 3:
                        setPanel(panel3);
                        break;
                    case 4:
                        setPanel(panel4);
                        break;
                    case 7:
                        setPanel(panelAccMana);
                    default:
                        break;
                }
//            System.out.println("Selected: " + index);
            }
        }
        );

        panelAccMana.addEventChangePass((ActionEvent ae) -> {
            Ca4JDBCMaven dtb_query = new Ca4JDBCMaven();
            try {
                String referencePass = dtb_query.getPassword(panelAccMana.getUserID());
                panelAuthen.setReferencePass(referencePass);
                setPanel(panelAuthen);
            } catch (SQLException ex) {
                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        panelAuthen.addEventConfirm((ActionEvent ae) -> {
            System.out.println("Pressed confirn button");
            String userPass = panelAuthen.getUserPass();
                        System.out.println("Referrence: " + panelAuthen.getReferencePass() + ", Input: " + userPass);
                        System.out.println(userPass.equals(panelAuthen.getReferencePass()));
            if (userPass.isEmpty()) {
            } else {
                if ((panelAuthen.getReferencePass() != null) && (userPass.equals(panelAuthen.getReferencePass()))) {
                    panelAuthen.setLabelWrongPass("", false);
                    setPanel(panelChangePass);
                } else {
                    panelAuthen.setLabelWrongPass("Incorect password!", true);
                }
            }
        });
        
        setPanel(panel1);
    }

    private void setPanel(JComponent com) {
        bodyPanel.removeAll();
        bodyPanel.add(com);
        bodyPanel.repaint();
        bodyPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        menu = new dashboard.MenuAdmin();
        search = new dashboard.HeaderBar();
        bodyPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setRadius(15);

        menu.setBotColor(new java.awt.Color(247, 225, 173));
        menu.setTopColor(new java.awt.Color(247, 186, 45));

        bodyPanel.setOpaque(false);
        bodyPanel.setLayout(new java.awt.BorderLayout());

        panelBorder1.setLayer(menu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelBorder1.setLayer(search, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelBorder1.setLayer(bodyPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private dashboard.MenuAdmin menu;
    private swing.PanelBorder panelBorder1;
    private dashboard.HeaderBar search;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
