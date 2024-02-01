/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import login.AuthenPanel;
import login.LoginPanel;
import login.ForgetPassPanel;
import login.RegisterPanel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import ultis.database;
import ultis.JavaEmailSender;

/**
 *
 * @author delini
 */
public class LoginMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public LoginMainFrame() {
        initComponents();
//        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(1440, 900);
        LoginPanel login = new LoginPanel();
        RegisterPanel register = new RegisterPanel();
        ForgetPassPanel forgetPass = new ForgetPassPanel();
        AuthenPanel authen = new AuthenPanel();

        slide.init(login, register, forgetPass, authen);

        login.addEventRegister((ActionEvent ae) -> {
            slide.show(1);
            register.register();
        });

        login.addEventResetPass((ActionEvent ae) -> {
            if (login.checkEmail()) {
                String userEmail = login.getUserEmail();
                JavaEmailSender emailSender = new JavaEmailSender();
                try {
                    slide.show(2);
                    forgetPass.resetPass(userEmail);
                    forgetPass.setCodeReference(emailSender.sendForgetPass(userEmail));
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(LoginMainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        login.addEventLogin((ActionEvent ae) -> {
            String email, pass;
            email = login.getUserEmail();
            pass = login.getUserPass();

            if (pass.isEmpty() || email.isEmpty()) {
                login.setLabelWrongUser("Please provide all needed information!", true);
            } else {
                database dtb_query = new database();
                try {
                    int id = dtb_query.loginUser(email, pass);
                    if (id == -1) {
                        login.setLabelWrongUser("Incorrect email or password!", true);
                    } else {
                        login.setLabelWrongUser(" ", false);
                        if (dtb_query.isUserInRole(id, "NguoiQuanLy")) {
                            DashboardAdmin adminFrame = new DashboardAdmin(id);
                            adminFrame.setVisible(true);
                            this.dispose();
                        } else if (dtb_query.isUserInRole(id, "KhachHang")) {
                            DashboardCustomer customerFrame = new DashboardCustomer(id);
                            customerFrame.setVisible(true);
                            this.dispose();
                        } else if (dtb_query.isUserInRole(id, "Tho")) {
                            DashboardRepairer repairerFrame = new DashboardRepairer(id);
                            repairerFrame.setVisible(true);
                            this.dispose();
                        }
                    }
                    // Jump to main screen
                } catch (SQLException ex) {
                    Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        register.addEventBackLogin((ActionEvent ae) -> {
            slide.show(0);
            login.login();
        });

        register.addEventSignUp((ActionEvent ae) -> {
            Vector<String> data = register.checkInfor();
            if (data != null) {
                String userEmail = data.get(4);
                JavaEmailSender emailSender = new JavaEmailSender();
                try {
                    slide.show(3);
                    authen.authen(data);
                    authen.setCodeReference(emailSender.sendRegisterPass(userEmail));
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(LoginMainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        forgetPass.addEventBackLogin((ActionEvent ae) -> {
            forgetPass.setStopTimer(true);
            slide.show(0);
            login.login();
        });

        authen.addEventBackRegister((ActionEvent ae) -> {
            authen.setStopTimer(true);
            if (authen.isGoLogin()) {
                slide.show(0);
            } else {
                slide.show(1);
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

        panelGradient2 = new swing.PanelGradient();
        panelBorder1 = new swing.PanelBorder();
        slide = new swing.PanelSlide();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGradient2.setColorPrimario(new java.awt.Color(255, 214, 156));
        panelGradient2.setColorSecundario(new java.awt.Color(251, 243, 231));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        slide.setBackground(new java.awt.Color(255, 255, 255));
        slide.setAnimate(7);

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
        );

        panelBorder1.setLayer(slide, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelGradient2.setLayer(panelBorder1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelGradient2Layout = new javax.swing.GroupLayout(panelGradient2);
        panelGradient2.setLayout(panelGradient2Layout);
        panelGradient2Layout.setHorizontalGroup(
            panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient2Layout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(353, 353, 353))
        );
        panelGradient2Layout.setVerticalGroup(
            panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient2Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.PanelBorder panelBorder1;
    private swing.PanelGradient panelGradient2;
    private swing.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
