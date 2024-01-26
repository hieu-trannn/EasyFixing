package com.mycompany.easyfixing.mainFunctionalities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;


/**
 *
 * @author Admin
 */


public class database {
    public static String ConnectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=EasyFixing;user=sa;password=130902";
//    private static String command;
//    public database(String Qcommand) throws ParseException {
////        String ConnectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=easyfixing1;user=sa;password=12345678";
//        command = Qcommand;
//        try (Connection con = DriverManager.getConnection(ConnectionUrl); Statement stmt = con.createStatement();) {
////            // 1. Truy vấn các huyện từ tỉnh
//            if (Qcommand == "queryHuyenByTinh")
//            {queryHuyenByTinh(1);}
////          
////            // 2. Truy vấn các xã từ huyện
//            queryXaByHuyen(1);
////
////            // 3. Kiểm tra email hợp lệ
//            checkEmailExistence("nguoidung1@example.com");
//
//            // 4. Thêm dữ liệu tài khoản người dùng
//            addUser("John Doe", "123 Main St", "123456789", "password123", "john@example.com","12345678","1","2002-10-14");
//
////            // 5. Truy vấn đăng nhập và lấy UserID
//            int userId = loginUser("nguoidung1@example.com", "matkhau1");
//            System.out.println("Logged in UserID: " + userId);
////
////            // 6. Truy vấn quên mật khẩu và đặt mật khẩu mới
//            forgetPassword("nguoidung2@example.com", "newpassword456");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    public static void queryHuyenByTinh(int IDTinhThanh) throws SQLException {
        String query = "SELECT * FROM QuanHuyen WHERE IDTinhThanh = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, IDTinhThanh);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Xử lý kết quả
            while (resultSet.next()) {
                System.out.println("HuyenID: " + resultSet.getInt("IDQuanHuyen") + ", TenHuyen: " + resultSet.getString("TenQuanHuyen"));
            }
        }
    }

    public static void queryXaByHuyen(int IDQuanHuyen) throws SQLException {
        String query = "SELECT * FROM Phuongxa WHERE IDQuanHuyen = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, IDQuanHuyen);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Xử lý kết quả
            while (resultSet.next()) {
                System.out.println("XaID: " + resultSet.getInt("IDPhuongXa") + ", TenXa: " + resultSet.getString("TenPhuongXa"));
            }
        }
    }

    public static boolean checkEmailExistence(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM NguoiDung WHERE Email = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Xử lý kết quả
            resultSet.next();
            boolean count = resultSet.getBoolean(1);
            return count;
        }
    }
    public static void updatePassword(String email, String MatKhau) throws SQLException {
//        String query = "SELECT COUNT(*) FROM NguoiDung WHERE Email = ?";
        String query = "UPDATE NguoiDung SET MatKhau = ? WHERE Email = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, MatKhau);
            preparedStatement.setString(2, email);
        }
    }

    public static void addUser(int type, String HoTen, String DiaChiChiTiet, String SDT, String MatKhau, String email, String CCCD , String PhuongXa, String sNgaySinh) throws SQLException, ParseException {
        String query = "INSERT INTO NguoiDung (HoTen, DiaChiChiTiet, SoDienThoai, MatKhau, Email, SoCCCD, IDPhuongXa, NgaySinh ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            Date date = Date.valueOf(sNgaySinh);
            preparedStatement.setString(1, HoTen);
            preparedStatement.setString(2, DiaChiChiTiet);
            preparedStatement.setString(3, SDT);
            preparedStatement.setString(4, MatKhau);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, CCCD);
            preparedStatement.setString(7, PhuongXa);
            preparedStatement.setDate(8,  date);
//            int rowsAffected = preparedStatement.executeUpdate();
//            System.out.println("Rows affected: " + rowsAffected);
        }
        if (type == 0)
        {
            int userID = loginUser(email, MatKhau);
            addCustomer(userID);
        }
        if (type == 1)
        {
            // add worker
        }
        
    }
    
    public static void addCustomer(int Userid) throws SQLException, ParseException {
        String query = "INSERT INTO KhachHang (IDNguoiDung) VALUES (?)";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, Userid);
        } 
    }

//    public static void addWorker(int Userid) throws SQLException, ParseException {
//        String query = "INSERT INTO KhachHang (IDNguoiDung) VALUES (?)";
//        Connection con = DriverManager.getConnection(ConnectionUrl);
//        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
//            preparedStatement.setInt(1, Userid);
//        } 
//    }
    
    

    public static int loginUser(String email, String password) throws SQLException {
        String query = "SELECT IDNguoiDung FROM NguoiDung WHERE Email = ? AND MatKhau = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Xử lý kết quả
            if (resultSet.next()) {
                return resultSet.getInt("IDNguoiDung");
            } else {
                return -1; // Không tìm thấy người dùng
            }
        }
    }

    public static void forgetPassword(String email, String newPassword) throws SQLException {
        // Kiểm tra email tồn tại trong CSDL

        String checkEmailQuery = "SELECT COUNT(*) FROM NguoiDung WHERE Email = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement checkEmailStatement = con.prepareStatement(checkEmailQuery)) {
            checkEmailStatement.setString(1, email);
            ResultSet emailResult = checkEmailStatement.executeQuery();
            emailResult.next();
            int emailCount = emailResult.getInt(1);

            if (emailCount > 0) {
                // Đặt mật khẩu mới
                String updatePasswordQuery = "UPDATE NguoiDung SET MatKhau = ? WHERE Email = ?";               
                try (PreparedStatement updatePasswordStatement = con.prepareStatement(updatePasswordQuery)) {
                    updatePasswordStatement.setString(1, newPassword);
                    updatePasswordStatement.setString(2, email);
                    int rowsAffected = updatePasswordStatement.executeUpdate();
                    System.out.println("Rows affected: " + rowsAffected);
                }
            } else {
                System.out.println("Email not found in the database.");
            }
        }
    }
   
    private static boolean isUserInTable(String tableName, String userID) {
        try {
            String query = "SELECT COUNT(*) FROM " + tableName + " WHERE IDNguoiDung = ?";
            Connection con = DriverManager.getConnection(ConnectionUrl);
            try (PreparedStatement statement = con.prepareStatement(query)) {
                statement.setString(1, userID);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static int getUserRole(String userID) {
        if (isUserInTable("NguoiQuanLy", userID)) {
            return 0; // Admin
        } else if (isUserInTable("Tho", userID)) {
            return 1; // Thợ
        } else if (isUserInTable("KhachHang", userID)) {
            return 2; // Khách hàng
        } else {
            return -1; // Không tìm thấy trong bất kỳ bảng nào
        }
    }
    private static void deleteUser(String userID) {
        try {
            // Xóa thông báo của người dùng
            String deleteNotificationQuery = "DELETE FROM ThongBao WHERE IDNguoiDung = ?";
            Connection con = DriverManager.getConnection(ConnectionUrl);
            try (PreparedStatement deleteNotificationStatement = con.prepareStatement(deleteNotificationQuery)) {
                deleteNotificationStatement.setString(1, userID);
                deleteNotificationStatement.executeUpdate();
            }

            // Xóa người quản lý
            String deleteAdminQuery = "DELETE FROM NguoiQuanLy WHERE IDNguoiDung = ?";
            try (PreparedStatement deleteAdminStatement = con.prepareStatement(deleteAdminQuery)) {
                deleteAdminStatement.setString(1, userID);
                deleteAdminStatement.executeUpdate();
            }

            // Xóa thợ
            String deleteWorkerQuery = "DELETE FROM Tho WHERE IDNguoiDung = ?";
            try (PreparedStatement deleteWorkerStatement = con.prepareStatement(deleteWorkerQuery)) {
                deleteWorkerStatement.setString(1, userID);
                deleteWorkerStatement.executeUpdate();
            }

            // Xóa khách hàng
            String deleteCustomerQuery = "DELETE FROM KhachHang WHERE IDNguoiDung = ?";
            try (PreparedStatement deleteCustomerStatement = con.prepareStatement(deleteCustomerQuery)) {
                deleteCustomerStatement.setString(1, userID);
                deleteCustomerStatement.executeUpdate();
            }

            // Xóa người dùng
            String deleteUserQuery = "DELETE FROM NguoiDung WHERE IDNguoiDung = ?";
            try (PreparedStatement deleteUserStatement = con.prepareStatement(deleteUserQuery)) {
                deleteUserStatement.setString(1, userID);
                deleteUserStatement.executeUpdate();
                System.out.println("Người dùng đã bị xóa khỏi cơ sở dữ liệu.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



