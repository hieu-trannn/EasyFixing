/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import accountManagement.AccountManagement;
import accountManagement.AuthenticatePassword;
import accountManagement.ChangePassword;
import accountManagement.UpdateInformation;
import dashboard.SamplePanel;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import login.LoginPanel;
import ultis.database;
import ultis.EventMenuSelected;

/**
 *
 * @author delini
 */
public class DashboardCustomer extends javax.swing.JFrame {

    /**
     * Creates new form DashboardAdmin
     */
    // Declare Panel here
    private SamplePanel panel1, panel2, panel3, panel4, panel5;
    private int userId;
    private AccountManagement panelAccMana;
    private UpdateInformation panelUpdInfo;
    private AuthenticatePassword panelAuthen = new AuthenticatePassword(0);
    private ChangePassword panelChangePass;

    public DashboardCustomer(int userId) throws SQLException {
        initComponents();
//        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setUserId(userId);
        setSize(1440, 900);

        panel1 = new SamplePanel("1");
        panel2 = new SamplePanel("2");
        panel3 = new SamplePanel("3");
        panel4 = new SamplePanel("4");
        panel5 = new SamplePanel("5");
        panelAccMana = new AccountManagement(getUserId());
        panelChangePass = new ChangePassword(getUserId());
        panelUpdInfo = new UpdateInformation(getUserId());
        
        menu.initMoving(DashboardCustomer.this);

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
                    case 8:
                        setPanel(panelAccMana);
                        break;
                    case 9:
                        LoginMainFrame loginFrame = new LoginMainFrame();
                        loginFrame.setVisible(true);
                        setVisible(false);
                        break;
                    default:
                        break;
                }
//            System.out.println("Selected: " + index);
            }
        }
        );
        panelAccMana.addEventChangePass((ActionEvent ae) -> {
            panelAuthen.setServiceType(1);
            database dtb_query = new database();
            try {
                String referencePass = dtb_query.getPassword(panelAccMana.getUserID());
                panelAuthen.setReferencePass(referencePass);
                setPanel(panelAuthen);
            } catch (SQLException ex) {
                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        panelAuthen.addEventConfirm((ActionEvent ae) -> {
//            System.out.println("Pressed confirn button");
            String userPass = panelAuthen.getUserPass();
            if (userPass.isEmpty()) {
//                JOptionPane.showMessageDialog(panelAccMana, "Please fill up your password");
                panelAuthen.setLabelWrongPass("Fill up your password!", true);
            } else {
                if (!userPass.isEmpty()&&userPass.equals(panelAuthen.getReferencePass())) {
                    // set label if wrong password
                    panelAuthen.setLabelWrongPass("", false);
                    // change panel
                    if (panelAuthen.getServiceType() == 0) {
                        setPanel(panelUpdInfo);
                    }
                    if (panelAuthen.getServiceType() == 1) {
                        setPanel(panelChangePass);
                    }
                    if (panelAuthen.getServiceType() == 2) {
                        // delete account
                        int result = JOptionPane.showConfirmDialog(panelAccMana, "Are you really want to delete account?", "Warning!!", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            // delete account and come back log in frame
                            database dtb = new database();
                            try {
                                dtb.deleteAccount(getUserId());
                                LoginMainFrame loginFr = new LoginMainFrame();
                                loginFr.setVisible(true);
                                setVisible(false);
                            } catch (SQLException ex) {
                                Logger.getLogger(DashboardAdmin.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            setPanel(panelAccMana);
                        }
                    }
                } else {
                    System.out.println("wrongpass");
                    panelAuthen.setLabelWrongPass("Incorect password!", true);
                }
            }
        });

        panelAccMana.addEventDeleteAccount((ActionEvent ae) -> {
            panelAuthen.setServiceType(2);
            database dtb_query = new database();
            try {
                String referencePass = dtb_query.getPassword(panelAccMana.getUserID());
                panelAuthen.setReferencePass(referencePass);
                setPanel(panelAuthen);
            } catch (SQLException ex) {
                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        panelChangePass.addEventConfirm((ActionEvent ae) -> {
            if ((panelChangePass.getNewPassword().equals(panelChangePass.getRepeatNewPassword())) && (!"".equals(panelChangePass.getNewPassword()))) {
                database dtb = new database();
                try {
                    // 
                    String newPassword = panelChangePass.getNewPassword();
                    dtb.updatePassword(panelChangePass.getUserID(), newPassword);
                    JOptionPane.showMessageDialog(panelAccMana, "Successfully update password");
                    panelChangePass.removeAll();
                    setPanel(panelAccMana);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                panelChangePass.setLabelWrongPass("Please check your confirmation password again!", true);
            }
        });
        panelAccMana.addEventUpdateInfo((ActionEvent ae) -> {
            panelAuthen.setServiceType(0);
            database dtb_query = new database();
            try {
                String referencePass = dtb_query.getPassword(panelAccMana.getUserID());
                panelAuthen.setReferencePass(referencePass);
                setPanel(panelAuthen);
            } catch (SQLException ex) {
                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        panelUpdInfo.addEventUpdateConfirm((ActionEvent ae) -> {
            try {
                if (panelUpdInfo.updateInformation()) {
//                    
                    setPanel(panelAccMana);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DashboardAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
        search = new dashboard.HeaderBar();
        bodyPanel = new javax.swing.JPanel();
        menu = new dashboard.MenuCustomer();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBorder1.setRadius(15);

        bodyPanel.setOpaque(false);
        bodyPanel.setLayout(new java.awt.BorderLayout());

        menu.setBotColor(new java.awt.Color(247, 225, 173));
        menu.setTopColor(new java.awt.Color(247, 186, 45));

        panelBorder1.setLayer(search, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelBorder1.setLayer(bodyPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelBorder1.setLayer(menu, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    private dashboard.MenuCustomer menu;
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
