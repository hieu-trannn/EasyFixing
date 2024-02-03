/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package repairerCustomerFeedback;

//import repairerCurrentOrder.*;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
//import repairerCurrentOrder.TableActionCellEditor;
//import repairerCurrentOrder.TableActionCellRender;
//import repairerCurrentOrder.TableActionEvent;
import ultis.Database;

/**
 *
 * @author delini
 */
public class CustomerFeedback extends javax.swing.JPanel {

    private int UserID;
    private Vector<Integer> workerIDList = new Vector<>();
    private Vector<Integer> serviceIDList = new Vector<>();

    /**
     * Creates new form CurrentOrder
     */
    public CustomerFeedback(int userid) throws SQLException {
        setUserID(userid);
        initComponents();
        initTable();

    }

    public void initTable() throws SQLException {
        setHeader();

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onAccept(int row) {
                int workerId = workerIDList.get(row);
                int serviceId = serviceIDList.get(row);
                try {
                    showFeedbackDialog(workerId, serviceId, row);
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerFeedback.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Database dtb_query = new Database();
        int idCustomer = dtb_query.user2CustomerID(getUserID());
        try {
            Vector<Vector> data = dtb_query.getRemainFeedbackList(idCustomer);

//            System.out.println(data);
            for (Vector rowData : data) {
                DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
                model.addRow(new Object[]{rowData.get(0), rowData.get(1), rowData.get(2), rowData.get(3), "temp"});
//                Integer a = Integer.valueOf(rowData.get(4));
                int workerId = ((Number)rowData.get(4)).intValue();
                int serviceId = ((Number)rowData.get(5)).intValue();
                System.out.println("Worker id get from list: " + workerId);
                workerIDList.add(workerId);
                serviceIDList.add(serviceId);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerFeedback.class.getName()).log(Level.SEVERE, null, ex);
        }

        tableOrder.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        tableOrder.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
    }

    public void setHeader() {
        JTableHeader header = tableOrder.getTableHeader();
        header.setFont(new Font("Liberation Sans", Font.BOLD, 22));

        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tableOrder.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        panelBorder1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 55)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Feedback");

        tableOrder.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Worker", "Service", "Price", "Time Pay", "Feedback"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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

    public void showFeedbackDialog(int workerId, int serviceId, int row) throws SQLException {
        JTextField textField = new JTextField();
        JTextField textFieldPoint = new JTextField();
        textFieldPoint.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("In range 0-5")) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("In range 0-5");
                }
            }
        });
        Object[] messageArray = {"Customer Feedback", textFieldPoint, "Point", textField};

        int option = JOptionPane.showConfirmDialog(
                null,
                messageArray,
                "Customer Feedback Service",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (option == JOptionPane.OK_OPTION) {
            if ("".equals(textField.getText()) || "".equals(textFieldPoint.getText())) {
                JOptionPane.showMessageDialog(null, "Please fill up all information!");
                showFeedbackDialog(workerId,serviceId, row);
            } else {
                Database dtb = new Database();
                System.out.println("User iD: " + getUserID());
                int idCustomer = dtb.user2CustomerID(getUserID());
                System.out.println("Customer iD: " + idCustomer);
                dtb.addCustomerFeedback(idCustomer,textField.getText() ,textFieldPoint.getText(), workerId, serviceId);
                System.out.println("Feedback success");
                DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
                model.removeRow(row);
            }
        } else {
            System.out.println("cancel feedback");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
}
