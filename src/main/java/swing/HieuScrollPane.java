/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;

/**
 *
 * @author hieut
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HieuScrollPane extends JScrollPane {

    private JPanel allPanel = new JPanel();
    private Dimension dimension = new Dimension(300, 30);

    public HieuScrollPane() {
        initComponents();
        setViewportView(allPanel);
    }

    public JPanel getAllPanel() {
        return allPanel;
    }

    public void setPanelDimension(int width, int length) {
        dimension = new Dimension(width, length);
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void addPanel(JPanel newPanel) {
        allPanel.add(newPanel);
        this.setViewportView(this.getAllPanel());
    }

    // cái chính
    public void addPanel(JLabel labelInfo, int type) {
        // panel find worker: 2 ngăn, 1 ngăn: Label (thông tin), 1 ngăn: button: view chi tiếts. type = 0
        // panel update service: 2 ngăn, 1 ngăn: Label (thông tin), 1 ngăn: button: xóa. type = 1
        // panel current order: 2 ngăn: 1 ngăn Label thông tin đơn, 1 ngăn: button: xem chi tiết (trỏ đến giao diện có nút đồng ý, hủy). type = 2
        // panel history: 2 ngăn, 1 ngăn label, 1 ngăn button: view chi tiết. type = 3
        // panel feedback cho người dùng chưa feedback: 2 ngăn: 1 ngăn: Label lưu thông tin đơn, 1 ngăn: button feedback. type = 4
        // panel feedback cho người dùng xem lịch sử feedback/ Thợ xem lịch sử feedback: 1 ngăn: Label lưu thông tin đơn và feedback. type = 5
        // panel thông báo: cho người dùng / thợ / admin xem thông báo: 1 ngăn Label. type = 6

        labelInfo.setFont(new java.awt.Font("Liberation Sans", 0, 20));
        // panel with only label
        if (type == 5 || type == 6) {
            JPanel temp = new JPanel();
            temp.add(labelInfo);
            temp.setPreferredSize(dimension);
            allPanel.add(temp);
        } // panel with label and button
        else {
            JPanel temp = new JPanel(new GridLayout(1, 2));
            NPLinkButton viewBtn = new NPLinkButton("more");
            NPLinkButton deleteBtn = new NPLinkButton("delete");
            NPLinkButton fbBtn = new NPLinkButton("feedback");

            switch (type) {
                case 0: {
                    buttonPressed(viewBtn, type);
                    temp.add(labelInfo);
                    temp.add(viewBtn);
                    temp.setPreferredSize(dimension);
                    ((GridLayout) temp.getLayout()).setHgap(50);
                    allPanel.add(temp);
                    break;
                }
                case 2: {
                    buttonPressed(viewBtn, type);
                    temp.add(labelInfo);
                    temp.add(viewBtn);
                    temp.setPreferredSize(dimension);
                    ((GridLayout) temp.getLayout()).setHgap(50);
                    allPanel.add(temp);
                    break;
                }
                case 3: {
                    buttonPressed(viewBtn, type);
                    temp.add(labelInfo);
                    temp.add(viewBtn);
                    temp.setPreferredSize(dimension);
                    ((GridLayout) temp.getLayout()).setHgap(50);
                    allPanel.add(temp);
                    break;
                }
                case 1: {
                    buttonPressed(deleteBtn, type);
                    temp.add(labelInfo);
                    temp.add(deleteBtn);
                    temp.setPreferredSize(dimension);
                    ((GridLayout) temp.getLayout()).setHgap(50);
                    allPanel.add(temp);
                    break;
                }
                case 4: {
                    buttonPressed(fbBtn, type);
                    temp.add(labelInfo);
                    temp.add(fbBtn);
                    temp.setPreferredSize(dimension);
                    ((GridLayout) temp.getLayout()).setHgap(50);
                    allPanel.add(temp);
                    break;
                }
                // in case: type is not processed
                default: {
                    temp.add(labelInfo);
                    temp.add(labelInfo);
                    temp.setPreferredSize(dimension);
                    ((GridLayout) temp.getLayout()).setHgap(50);
                    allPanel.add(temp);
                }
            }
        }
        this.setViewportView(this.getAllPanel());
    }

    /* actionListener for button created
    khi ấn button, gọi giao diện hiển thị thông tin chi tiết thợ với type = 0
    khi ấn button, xóa dịch vụ và hiển thị thông báo với type = 1
    khi ấn button, gọi giao diện hiển thị thông tin chi tiết đơn hàng với type = 2
    khi ấn button, gọi giao diện hiển thị thông tin chi tiết lịch sử với type = 3
    khi ấn button, gọi giao diện hiển thị giao diện feedback với type = 4
     */
    public void buttonPressed(JButton pressedBtn, int type) {
        switch (type) {
            case 0:
                pressedBtn.addActionListener((ActionEvent ae) -> {
                    System.out.println("Change interface to worker's detailed information GUI");
                    // code to change interface here
//                    Login LoginFrame = new Login();
//                    LoginFrame.setVisible(true);
//                    LoginFrame.pack(); //cause Window be sized to fix layout size
//                    LoginFrame.setLocationRelativeTo(null);
                });
                break;
            case 1:
                pressedBtn.addActionListener((ActionEvent ae) -> {
                    System.out.println("update service information and inform user");
                    // code to handle here
                });
                break;
            case 2:
                pressedBtn.addActionListener((ActionEvent ae) -> {
                    System.out.println("Change interface to bill's detailed information GUI");
                    // code to change interface here
                });
                break;
            case 3:
                pressedBtn.addActionListener((ActionEvent ae) -> {
                    System.out.println("Change interface to history's detailed information GUI");
                    // code to change interface here
                });
                break;
            case 4:
                pressedBtn.addActionListener((ActionEvent ae) -> {
                    System.out.println("Change interface to feeback GUI");
                    // code to change interface here
                });
                break;
            default: {
            }
        }
    }

    public void addPanel(NPLinkButton first, NPLinkButton second) {
        JPanel temp = new JPanel(new GridLayout(1, 2));
        temp.add(first);
        temp.add(second);
        temp.setPreferredSize(dimension);

        ((GridLayout) temp.getLayout()).setHgap(50);
        allPanel.add(temp);
        this.setViewportView(this.getAllPanel());
    }

    private void initComponents() {

        // set width and height of each panel in scrollpane
        setPanelDimension(30, 30);

//        TEST PURPOSE
        JPanel test = new JPanel();
        test.add(new JLabel("Hiiii"));
        NPLinkButton a = new NPLinkButton("hieu");
        NPLinkButton b = new NPLinkButton("dz");
        JLabel labelworker = new JLabel("some Worker infomation");
        JLabel labelService = new JLabel("some service infomation");
        JLabel labelFeedback = new JLabel("some feedback infomation");
        JLabel labelHistory = new JLabel("you use fix toilet service");
        addPanel(labelworker, 2);
        addPanel(labelService, 1);
        addPanel(labelFeedback, 4);
        addPanel(labelHistory, 6);
        addPanel(a, b);
        addPanel(test);
        allPanel.setLayout(new BoxLayout(allPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical layout
    }
}
