/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import dashboardAdmin.SamplePanel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JComponent;
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

    public DashboardCustomer() {
        initComponents();
//        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(1440, 900);
        setBackground(new Color(0, 0, 0, 0));

    panel1 = new SamplePanel("1");
    panel2 = new SamplePanel("2");
    panel3 = new SamplePanel("3");
    panel4 = new SamplePanel("4");
    panel5 = new SamplePanel("5");

    menu.initMoving (DashboardCustomer.this);

    menu.addEventMenuSelected ( 
        new EventMenuSelected() {
            @Override
        public void selected
        (int index
        
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
                    setPanel(panel5);
                default:
                    break;
            }
//            System.out.println("Selected: " + index);
        }
    }

    );
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
        search = new dashboardAdmin.HeaderBar();
        bodyPanel = new javax.swing.JPanel();
        menu = new dashboardCustomer.MenuCustomer();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setRadius(15);

        bodyPanel.setName(""); // NOI18N
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
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(DashboardCustomer.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardCustomer.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardCustomer.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardCustomer.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private dashboardCustomer.MenuCustomer menu;
    private swing.PanelBorder panelBorder1;
    private dashboardAdmin.HeaderBar search;
    // End of variables declaration//GEN-END:variables
}
