/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ultis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class Ca4JDBCMaven {

    public static String ConnectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=TestDB;user=sa;password=NPLink1612";

    public void main(String[] args) throws ParseException {
//        String ConnectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=easyfixing1;user=sa;password=12345678";
        try (Connection con = DriverManager.getConnection(ConnectionUrl); Statement stmt = con.createStatement();) {
            System.out.println("oke");

////            // 1. Truy vấn các huyện từ tỉnh
//            queryHuyenByTinh(1);
////
////            // 2. Truy vấn các xã từ huyện
//            queryXaByHuyen(1);
////
////            // 3. Kiểm tra email hợp lệ
//            System.out.println(checkEmailExistence("hehe@example.com"));
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vector getDistrict(String province) throws SQLException {
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatementProvince = con.prepareStatement("SELECT * FROM TinhThanh WHERE TenTinhThanh = N'" + province + "'")) {
            ResultSet resultSet = preparedStatementProvince.executeQuery();
            resultSet.next();
            int provinceID = resultSet.getInt("IDTinhThanh");

            PreparedStatement preparedStatementDistrict = con.prepareStatement("SELECT TenQuanHuyen FROM QuanHuyen WHERE IDTinhThanh = ?");
            preparedStatementDistrict.setInt(1, provinceID);
            resultSet = preparedStatementDistrict.executeQuery();
            Vector data = new Vector();
            while (resultSet.next()) {
                data.add(resultSet.getString("TenQuanHuyen"));
            }
            return data;
        }
    }

    public Vector getWard(String district) throws SQLException {
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatementDistrict = con.prepareStatement("SELECT * FROM QuanHuyen WHERE TenQuanHuyen = N'" + district + "'")) {
            ResultSet resultSet = preparedStatementDistrict.executeQuery();
            resultSet.next();
            int districtID = resultSet.getInt("IDQuanHuyen");

            PreparedStatement preparedStatementWard = con.prepareStatement("SELECT TenPhuongXa FROM PhuongXa WHERE IDQuanHuyen = ?");
            preparedStatementWard.setInt(1, districtID);
            resultSet = preparedStatementWard.executeQuery();
            Vector data = new Vector();
            while (resultSet.next()) {
                data.add(resultSet.getString("TenPhuongXa"));
            }
            return data;
        }
    }

    public boolean checkEmailExistence(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM NguoiDung WHERE Email = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Xử lý kết quả
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count == 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public int addUser(String HoTen, String DiaChiChiTiet, String SDT, String MatKhau, String email, String CCCD, int PhuongXa, String sNgaySinh) throws SQLException, ParseException {
        String query = "INSERT INTO NguoiDung (HoTen, DiaChiChiTiet, SoDienThoai, MatKhau, Email, SoCCCD, IDPhuongXa, NgaySinh ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            Date date = Date.valueOf(sNgaySinh);
            preparedStatement.setString(1, HoTen);
            preparedStatement.setString(2, DiaChiChiTiet);
            preparedStatement.setString(3, SDT);
            preparedStatement.setString(4, MatKhau);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, CCCD);
            preparedStatement.setInt(7, PhuongXa);
            preparedStatement.setDate(8, date);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // Retrieve the generated keys (in this case, just one key)
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedID = generatedKeys.getInt(1);
                        return generatedID;
                    } else {
                        // Handle the case where no keys were generated
                        throw new SQLException("Failed to retrieve generated key.");
                    }
                }
            } else {
                // Handle the case where the insert did not succeed
                throw new SQLException("Failed to insert user.");
            }
        }
    }

    public void addCustomer(String HoTen, String DiaChiChiTiet, String SDT, String MatKhau, String email, String CCCD, int PhuongXa, String sNgaySinh) throws SQLException, ParseException {
        int customerID = addUser(HoTen, DiaChiChiTiet, SDT, MatKhau, email, CCCD, PhuongXa, sNgaySinh);
        String query = "INSERT INTO KhachHang (IDNguoiDung) VALUES (?)";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, customerID);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected <= 0) {
                throw new SQLException("Failed to insert user.");
            }
        }
    }

    public int getWardID(String ward) throws SQLException {
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM PhuongXa WHERE TenPhuongXa = N'" + ward + "'")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int wardID = resultSet.getInt("IDPhuongXa");
            return wardID;
        }
    }

    public int loginUser(String email, String password) throws SQLException {
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

    public Boolean isUserInRole(int id, String roleTable) throws SQLException {
        String query = "SELECT IDNguoiDung FROM " + roleTable + " WHERE IDNguoiDung = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }

    public Vector getProvince() throws SQLException {
        String query = "SELECT TenTinhThanh FROM TinhThanh";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            Vector data = new Vector();
            while (resultSet.next()) {
                data.add(resultSet.getString("TenTinhThanh"));
            }
            return data;
        }
    }

    public void updatePassword(String email, String newPassword) throws SQLException {
        String updatePasswordQuery = "UPDATE NguoiDung SET MatKhau = ? WHERE Email = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement updatePasswordStatement = con.prepareStatement(updatePasswordQuery)) {
            updatePasswordStatement.setString(1, newPassword);
            updatePasswordStatement.setString(2, email);
            updatePasswordStatement.executeUpdate();
        }
    }
}
