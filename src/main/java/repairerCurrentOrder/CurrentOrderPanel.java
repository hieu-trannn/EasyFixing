/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package repairerCurrentOrder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import ultis.Database;

/**
 *
 * @author delini
 */
public class CurrentOrderPanel extends javax.swing.JPanel {

    private int UserID;
    private int idOrder;

    /**
     * Creates new form CurrentOrder
     */
    public CurrentOrderPanel(int userid) {
        setUserID(userid);
        initComponents();
        initTable();
    }

    public void initTable() {
        setHeader();

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onAccept(int row) {
//                System.out.println("Pressed Accept");
                int id = (int) tableOrder.getValueAt(tableOrder.getSelectedRow(), 4);
                Database dtb_query = new Database();
                try {
                    dtb_query.updateStateOrder(id, 2);
                } catch (SQLException ex) {
                    Logger.getLogger(CurrentOrderPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
                model.removeRow(row);
            }

            @Override
            public void onRefuse(int row) {
//                System.out.println("Pressed Refuse");
                if (tableOrder.isEditing()) {
                    tableOrder.getCellEditor().stopCellEditing();
                }
                int id = (int) tableOrder.getValueAt(tableOrder.getSelectedRow(), 4);
                Database dtb_query = new Database();
                try {
                    dtb_query.updateStateOrder(id, 1);
                } catch (SQLException ex) {
                    Logger.getLogger(CurrentOrderPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
                model.removeRow(row);
            }
        };

        Database dtb_query = new Database();
        try {
            Vector<Vector> data = dtb_query.getListOrder(getUserID());
            for (Vector rowData : data) {
                DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
                model.addRow(new Object[]{rowData.get(0), rowData.get(1), rowData.get(2), "Placeholder", (int) rowData.get(3)});
            }

        } catch (SQLException ex) {
            Logger.getLogger(CurrentOrderPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Set the ID as an invisible column
        tableOrder.getColumn("ID").setMaxWidth(0);
        tableOrder.getColumn("ID").setMinWidth(0);
        tableOrder.getColumn("ID").setPreferredWidth(0);
        tableOrder.getColumn("ID").setWidth(0);

        tableOrder.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        tableOrder.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));

        tableOrder.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
//                    int selectedRow = tableOrder.getSelectedRow();
                    int selectedColumn = tableOrder.getSelectedColumn();

                    if (selectedColumn != 3) {
                        setIdOrder((int) tableOrder.getValueAt(tableOrder.getSelectedRow(), 4));
                        btnHiden.doClick();
                    }
                }
            }
        });
    }

    public void setHeader() {
        JTableHeader header = tableOrder.getTableHeader();
        header.setFont(new Font("Liberation Sans", Font.BOLD, 22));

        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tableOrder.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
    }

    public void addEventShowOrder(ActionListener event) {
        btnHiden.addActionListener(event);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHiden = new javax.swing.JButton();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();

        btnHiden.setText("jButton1");

        setBackground(new java.awt.Color(255, 255, 255));

        panelBorder1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 55)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Current Order");

        tableOrder.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer", "Service", "Price", "Status", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOrder.setGridColor(new java.awt.Color(255, 255, 255));
        tableOrder.setRowHeight(50);
        tableOrder.setSelectionBackground(new java.awt.Color(250, 233, 190));
        tableOrder.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tableOrder.setShowGrid(false);
        tableOrder.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableOrder);
        if (tableOrder.getColumnModel().getColumnCount() > 0) {
            tableOrder.getColumnModel().getColumn(3).setResizable(false);
            tableOrder.getColumnModel().getColumn(4).setResizable(false);
            tableOrder.getColumnModel().getColumn(4).setPreferredWidth(0);
        }

        panelBorder1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelBorder1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHiden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JTable tableOrder;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the UserID
     */
    public int getUserID() {
        return UserID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    /**
     * @return the idOrder
     */
    public int getIdOrder() {
        return idOrder;
    }

    /**
     * @param idOrder the idOrder to set
     */
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
}
