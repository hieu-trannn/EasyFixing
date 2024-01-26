/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.easyfixing;

/**
 *
 * @author hieut
 */
public class EasyFixing {

    public static void main(String[] args) {
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack(); //cause Window be sized to fix layout size
        LoginFrame.setLocationRelativeTo(null);
    }
}
