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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class Database {

    public static String ConnectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=EasyFixing;user=sa;password=130902";

    public void main(String[] args) throws ParseException {
        try (Connection con = DriverManager.getConnection(ConnectionUrl); Statement stmt = con.createStatement();) {
            System.out.println("oke");
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

    public String getPassword(int id) throws SQLException {
        String query = "SELECT MatKhau FROM NguoiDung WHERE IDNguoiDung = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("MatKhau");
            } else {
                return null;
            }
        }
    }

    public String getName(int id) throws SQLException {
        String query = "SELECT * FROM NguoiDung WHERE IDNguoiDung = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("HoTen");
            } else {
                return null;
            }
        }
    }

    public String getServiceName(int idService) throws SQLException {
        String query = "SELECT * FROM LoaiDichVu WHERE IDLoaiDichVu = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idService);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("TenDichVu");
            } else {
                return null;
            }
        }
    }

    public Vector getListOrder(int idRepairer) throws SQLException {
        String query = "SELECT * FROM DonSuaChua WHERE IDTho = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idRepairer);
            ResultSet resultSet = preparedStatement.executeQuery();
            Vector<Vector> data = new Vector();
            while (resultSet.next()) {
                if (resultSet.getInt("TrangThai") == 0) {
                    Vector row = new Vector();
                    int idCustomer = resultSet.getInt("IDKhachHang");
                    int idService = resultSet.getInt("IDDichVu");
                    row.add(getName(idCustomer));   //0
                    row.add(getServiceName(idService)); //1
                    row.add(resultSet.getInt("TongTien"));  //2
                    row.add(resultSet.getInt("IDDonHang")); //3
                    data.add(row);
                }
            }
            return data;
        }
    }

    public void updateStateOrder(int idOrder, int state) throws SQLException {
        String updatePasswordQuery = "UPDATE DonSuaChua SET TrangThai = ? WHERE IDDonHang = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement updatePasswordStatement = con.prepareStatement(updatePasswordQuery)) {
            updatePasswordStatement.setInt(1, state);
            updatePasswordStatement.setInt(2, idOrder);
            updatePasswordStatement.executeUpdate();
        }
    }

    // for update password with userid
    public void updatePassword(int userid, String newPassword) throws SQLException {
        String updatePasswordQuery = "UPDATE NguoiDung SET MatKhau = ? WHERE IDNguoiDung = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement updatePasswordStatement = con.prepareStatement(updatePasswordQuery)) {
            updatePasswordStatement.setString(1, newPassword);
            updatePasswordStatement.setInt(2, userid);
            updatePasswordStatement.executeUpdate();
        }
    }

    // delete worker 
    public void deleteWorker(int workerid) throws SQLException {
        String deleteWorkerAble = "DELETE FROM CoTheLam WHERE IDTho = ?";
        String deleteWorkerBill = "DELETE FROM DonSuaChua WHERE IDTho = ?";
        String deleteWorkerFb = "DELETE FROM PhanHoi WHERE IDTho = ?";
        String deleteWorkerTable = "DELETE FROM Tho WHERE IDTho = ?";
        String deleteUserNotice = "DELETE FROM ThongBao WHERE IDNguoiDung = ?";
        String deleteWorkerUser = "DELETE FROM NguoiDung WHERE IDNguoiDung = ?";

        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement deleteNoticeStatement = con.prepareStatement(deleteUserNotice); PreparedStatement deleteUserStatement = con.prepareStatement(deleteWorkerUser); PreparedStatement deleteAbleStatement = con.prepareStatement(deleteWorkerAble); PreparedStatement deleteBillStatement = con.prepareStatement(deleteWorkerBill); PreparedStatement deleteFbStatement = con.prepareStatement(deleteWorkerFb); PreparedStatement deleteTableStatement = con.prepareStatement(deleteWorkerTable)) {
            deleteAbleStatement.setInt(1, workerid);
            deleteBillStatement.setInt(1, workerid);
            deleteFbStatement.setInt(1, workerid);
            deleteTableStatement.setInt(1, workerid);
            deleteNoticeStatement.setInt(1, worker2UserID(workerid));
            deleteUserStatement.setInt(1, worker2UserID(workerid));
//            System.out.println("1-");
            deleteAbleStatement.executeUpdate();
            deleteBillStatement.executeUpdate();
            deleteFbStatement.executeUpdate();
            deleteTableStatement.executeUpdate();
            deleteNoticeStatement.executeUpdate();
            deleteUserStatement.execute();
        }
    }

    // delete Customer
    public void deleteCustomer(int workerid) throws SQLException {
        String deleteWorkerBill = "DELETE FROM DonSuaChua WHERE IDKhachHang = ?";
        String deleteWorkerFb = "DELETE FROM PhanHoi WHERE IDKhachHang = ?";
        String deleteWorkerTable = "DELETE FROM KhachHang WHERE IDKhachHang = ?";
        String deleteUserNotice = "DELETE FROM ThongBao WHERE IDNguoiDung = ?";
        String deleteWorkerUser = "DELETE FROM NguoiDung WHERE IDNguoiDung = ?";

        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement deleteNoticeStatement = con.prepareStatement(deleteUserNotice); PreparedStatement deleteUserStatement = con.prepareStatement(deleteWorkerUser); PreparedStatement deleteBillStatement = con.prepareStatement(deleteWorkerBill); PreparedStatement deleteFbStatement = con.prepareStatement(deleteWorkerFb); PreparedStatement deleteTableStatement = con.prepareStatement(deleteWorkerTable)) {
            deleteBillStatement.setInt(1, workerid);
            deleteFbStatement.setInt(1, workerid);
            deleteTableStatement.setInt(1, workerid);
            deleteNoticeStatement.setInt(1, customer2UserID(workerid));
            deleteUserStatement.setInt(1, customer2UserID(workerid));
//            System.out.println("1-");
            deleteBillStatement.executeUpdate();
            deleteFbStatement.executeUpdate();
            deleteTableStatement.executeUpdate();
            deleteNoticeStatement.executeUpdate();
            deleteUserStatement.execute();
        }
    }

    // delete Admin
    public void deleteAdmin(int workerid) throws SQLException {
        String deleteWorkerTable = "DELETE FROM NguoiQuanLy WHERE IDQuanLy = ?";
        String deleteUserNotice = "DELETE FROM ThongBao WHERE IDNguoiDung = ?";
        String deleteWorkerUser = "DELETE FROM NguoiDung WHERE IDNguoiDung = ?";

        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement deleteNoticeStatement = con.prepareStatement(deleteUserNotice); PreparedStatement deleteUserStatement = con.prepareStatement(deleteWorkerUser); PreparedStatement deleteTableStatement = con.prepareStatement(deleteWorkerTable)) {
            deleteTableStatement.setInt(1, workerid);
            deleteNoticeStatement.setInt(1, admin2UserID(workerid));
            deleteUserStatement.setInt(1, admin2UserID(workerid));
            deleteTableStatement.executeUpdate();
            deleteNoticeStatement.executeUpdate();
            deleteUserStatement.execute();
        }
    }

//for delete account
    public void deleteAccount(int userid) throws SQLException {
        // Câu lệnh SQL kiểm tra xem ID có tồn tại không 
        String checkAdminSql = "SELECT 1 FROM NguoiQuanLy WHERE IDNguoiDung= ?";
        String checkCustomerSql = "SELECT 1 FROM KhachHang WHERE IDNguoiDung = ?";
        String checkWorkerSql = "SELECT 1 FROM Tho WHERE IDNguoiDung = ?";

        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement checkCustomerStatement = con.prepareStatement(checkCustomerSql); PreparedStatement checkAdminStatement = con.prepareStatement(checkAdminSql); PreparedStatement checkWorkerStatement = con.prepareStatement(checkWorkerSql)) {

            // Thiết lập giá trị cho tham số trong câu lệnh SQL cho cả hai bảng
            checkAdminStatement.setInt(1, userid);
            checkWorkerStatement.setInt(1, userid);
            checkCustomerStatement.setInt(1, userid);
            // Kiểm tra xem ID có tồn tại trong bảng khách hàng không
            try (ResultSet userResultSet = checkCustomerStatement.executeQuery()) {
                if (userResultSet.next()) {
                    // ID tồn tại trong bảng khách hàng, thực hiện xóa
                    int customerID = user2CustomerID(userid);
                    deleteCustomer(customerID);
                    return; // Kết thúc chương trình sau khi xóa
                }
            }
            // Kiểm tra xem ID có tồn tại trong bảng quản lý không
            try (ResultSet adminResultSet = checkAdminStatement.executeQuery()) {
                if (adminResultSet.next()) {
                    // ID tồn tại trong bảng quản lý, thực hiện xóa
                    int adminID = user2AdminID(userid);
                    deleteAdmin(adminID);
                    return; // Kết thúc chương trình sau khi xóa
                }
            }
            try (ResultSet workerResultSet = checkWorkerStatement.executeQuery()) {
                if (workerResultSet.next()) {
                    // ID tồn tại trong bảng quản lý, thực hiện xóa
                    int workerID = user2WorkerID(userid);
                    deleteWorker(workerID);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getEmail(int id) throws SQLException {
        String query = "SELECT Email FROM NguoiDung WHERE IDNguoiDung = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        System.out.println("userid:" + id);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
//                System.out.println(resultSet.getString("MatKhau"));
                return resultSet.getString("Email");
            } else {
                return null;
            }
        }
    }

    // update customer and admin
    public void updateCustomer(String HoTen, String DiaChiChiTiet, String SDT, String MatKhau, String email, String CCCD, int PhuongXa, String sNgaySinh, int userid) throws SQLException, ParseException {
        String query = "Update NguoiDung SET MatKhau = ?, HoTen = ?, NgaySinh = ?, SoCCCD = ?, Email = ?, SoDienThoai = ?, DiaChiChiTiet = ?, IDPhuongXa =? Where IDNguoiDung = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement updatePasswordStatement = con.prepareStatement(query)) {
            updatePasswordStatement.setString(1, MatKhau);
            updatePasswordStatement.setString(2, HoTen);
            updatePasswordStatement.setString(3, sNgaySinh);
            updatePasswordStatement.setString(4, CCCD);
            updatePasswordStatement.setString(5, email);
            updatePasswordStatement.setString(6, SDT);
            updatePasswordStatement.setString(7, DiaChiChiTiet);
            updatePasswordStatement.setInt(8, PhuongXa);
            updatePasswordStatement.setInt(9, userid);
            updatePasswordStatement.executeUpdate();
        }
    }

    public int customer2UserID(int idCustomer) throws SQLException {
        String query = "Select * FROM KhachHang Where IDKhachHang = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idCustomer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return (resultSet.getInt("IDNguoiDung"));
            } else {
                System.out.println("Không tìm thấy " + idCustomer);
                return 99;
            }
        }
    }

    // get userId from customerID
    public int user2CustomerID(int idCustomer) throws SQLException {
        String query = "Select * FROM KhachHang Where IDNguoiDung = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idCustomer);
            ResultSet resultSet = preparedStatement.executeQuery();
//            System.out.println(resultSet);
            if (resultSet.next()) {
                return (resultSet.getInt("IDKhachHang"));
            } else {
                System.out.println("Không tìm thấy " + idCustomer);
                return 99;
            }
//            return resultSet.getInt("IDKhachHang");
        }
    }

    // get userId from workerID
    public int worker2UserID(int idCustomer) throws SQLException {
        String query = "Select * FROM Tho Where IDTho= ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idCustomer);
            ResultSet resultSet = preparedStatement.executeQuery();
//            return resultSet.getInt("IDNguoiDung");
//            try (ResultSet resultSet = getUserIdStatement.executeQuery()) {
            if (resultSet.next()) {
                return (resultSet.getInt("IDNguoiDung"));
            } else {
                System.out.println("Không tìm thấy " + idCustomer);
                return 99;
            }

        }
    }

    // get userId from workerID
    public int user2WorkerID(int idCustomer) throws SQLException {
        String query = "Select * FROM Tho Where IDNguoiDung= ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idCustomer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return (resultSet.getInt("IDTho"));
            } else {
                System.out.println("Không tìm thấy " + idCustomer);
                return 99;
            }
        }
    }

    // get userId from adminID
    public int admin2UserID(int idCustomer) throws SQLException {
        String query = "Select * FROM NguoiQuanLy Where IDQuanLy= ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idCustomer);
            ResultSet resultSet = preparedStatement.executeQuery();
//            return resultSet.getInt("IDNguoiDung");
//            try (ResultSet resultSet = getUserIdStatement.executeQuery()) {
            if (resultSet.next()) {
                return (resultSet.getInt("IDNguoiDung"));
            } else {
                System.out.println("Không tìm thấy " + idCustomer);
                return 99;
            }

        }
    }

    // get admin id from user
    public int user2AdminID(int idCustomer) throws SQLException {
        String query = "Select * FROM NguoiQuanLy Where IDNguoiDung= ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idCustomer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return (resultSet.getInt("IDQuanLy"));
            } else {
                System.out.println("Không tìm thấy " + idCustomer);
                return 99;
            }
        }
    }

    //get Customer's feedbacks list
    public Vector getCustomerListFeedback(int idCustomer) throws SQLException {
        String query = "SELECT * FROM PhanHoi WHERE IDKhachHang = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idCustomer);
            ResultSet resultSet = preparedStatement.executeQuery();
            Vector<Vector> data = new Vector();
            while (resultSet.next()) {
                Vector row = new Vector();
                int idWorker = resultSet.getInt("IDTho");
                int idService = resultSet.getInt("IDDichVu");
                int userIdFromTho = worker2UserID(idWorker);
                row.add(getName(userIdFromTho));   //0
                row.add(getServiceName(idService)); //1
//                System.out.println("UseridFromTho"+userIdFromTho);
                row.add(resultSet.getString("DanhGiaTomTat"));  //2
//                System.out.println(row.get(2));
                row.add(resultSet.getString("ThoiGianPhanHoi")); //3
                row.add(resultSet.getInt("DiemDanhGia"));
                data.add(row);
            }
            return data;
        }
    }

    //get Customer's feedbacks list
    public Vector getWorkerListFeedback(int idWorker) throws SQLException {
        String query = "SELECT * FROM PhanHoi WHERE IDTho = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idWorker);
            ResultSet resultSet = preparedStatement.executeQuery();
            Vector<Vector> data = new Vector();
            while (resultSet.next()) {
                Vector row = new Vector();
                int idCustomer = resultSet.getInt("IDKhachHang");
                int idService = resultSet.getInt("IDDichVu");
                int userIdFromCustomer = customer2UserID(idCustomer);
                row.add(getName(userIdFromCustomer));   //0
                row.add(getServiceName(idService)); //1
//                System.out.println("UseridFromTho"+userIdFromTho);
                row.add(resultSet.getString("DanhGiaTomTat"));  //2
//                System.out.println(row.get(2));
                row.add(resultSet.getString("ThoiGianPhanHoi")); //3
                row.add(resultSet.getInt("DiemDanhGia"));
                data.add(row);
            }
            return data;
        }
    }

    // feedback for complete bill but not reply
    public Vector getRemainFeedbackList(int idCustomer) throws SQLException {
        String query = "SELECT * FROM DonSuaChua WHERE IDKhachHang = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idCustomer);
            ResultSet resultSet = preparedStatement.executeQuery();
            Vector<Vector> data = new Vector();
            while (resultSet.next()) {
                System.out.println("1");
                if (resultSet.getInt("TrangThai") == 5) {
                    Vector row = new Vector();
                    int idWorker = resultSet.getInt("IDTho");
                    int idService = resultSet.getInt("IDDichVu");
                    int workerUserId = worker2UserID(idWorker);
//                    System.out.println("2");
                    row.add(getName(workerUserId));   //0
//                    System.out.println(row.get(0));
                    row.add(getServiceName(idService)); //1
                    row.add(resultSet.getInt("TongTien"));  //2
                    row.add(resultSet.getString("ThoiGianThanhToan")); //3
                    // add worker id and service id
                    row.add(idWorker);
                    row.add(idService);
                    data.add(row);
                }
            }
            return data;
        }
    }

    // add Worker
    public void addWorker(String HoTen, String DiaChiChiTiet, String SDT, String MatKhau, String email, String CCCD, int PhuongXa, String sNgaySinh, String SoTaiKhoan, String KinhNghiem) throws SQLException, ParseException {
        int workerID = addUser(HoTen, DiaChiChiTiet, SDT, MatKhau, email, CCCD, PhuongXa, sNgaySinh);
        String query = "INSERT INTO Tho (IDNguoiDung,TrangThai, KinhNghiem, SoTaiKhoan  ) VALUES (?,?,?,?)";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, workerID);
            preparedStatement.setInt(2, 1); // set status: 1
            preparedStatement.setString(3, KinhNghiem);
            preparedStatement.setString(4, SoTaiKhoan);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected <= 0) {
                throw new SQLException("Failed to insert user.");
            }
        }
    }

    // update Worker
    public void updateWorker(int workerId, String HoTen, String DiaChiChiTiet, String SDT, String MatKhau, String email, String CCCD, int PhuongXa, String sNgaySinh, String SoTaiKhoan, String KinhNghiem) throws SQLException, ParseException {
        int userId = worker2UserID(workerId);
        updateCustomer(HoTen, DiaChiChiTiet, SDT, MatKhau, email, CCCD, PhuongXa, sNgaySinh, userId);
        String query = "Update Tho SET SoTaiKhoan = ?, KinhNghiem = ? Where IDTho = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, SoTaiKhoan);
            preparedStatement.setString(2, KinhNghiem);
            preparedStatement.setInt(3, workerId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected <= 0) {
                throw new SQLException("Failed to insert user.");
            }
        }
    }

    public Vector getOrderData(int idOrder) throws SQLException {
        String query = "SELECT * FROM DonSuaChua WHERE IDDonHang = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idOrder);
            ResultSet resultSet = preparedStatement.executeQuery();
            Vector data = new Vector();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("IDKhachHang");
                int idUser = customer2UserID(idCustomer);
                int idService = resultSet.getInt("IDDichVu");
                data.add(getName(idUser));   //0
                data.add(getServiceName(idService)); //1
                data.add(resultSet.getString("MoTaVanDe")); //2
                data.add(resultSet.getString("TongTien"));  //3
                data.add(resultSet.getInt("TrangThai")); //4
                Timestamp time = resultSet.getTimestamp("ThoiGianThanhToan");
                if (time != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
                    String formatedTime = dateFormat.format(time);
                    data.add(formatedTime); //4
                } else {
                    data.add("Haven't paid");
                }
            }

            return data;
        }
    }

    public Vector getListOrderCustomer(int idCustomerUser) throws SQLException {
        String query = "SELECT * FROM DonSuaChua WHERE IDKhachHang = ? AND TrangThai <> 5";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        int idCustomer = user2CustomerID(idCustomerUser);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idCustomer);
            ResultSet resultSet = preparedStatement.executeQuery();
            Vector<Vector> data = new Vector<Vector>();
            while (resultSet.next()) {
                Vector row = new Vector();
                int idWorker = resultSet.getInt("IDTho");
                int idUser = worker2UserID(idWorker);
                int idService = resultSet.getInt("IDDichVu");
                row.add(getServiceName(idService)); //0
                row.add(resultSet.getString("MoTaVanDe")); //1
                row.add(getName(idUser));   //2
                row.add(resultSet.getString("TongTien"));  //3
                row.add(resultSet.getInt("TrangThai")); //4
                row.add(resultSet.getInt("IDDonHang")); //5
                data.add(row);
            }
//            for (Vector innerVector : data) {
//                for (int i = 0; i < innerVector.size(); i++) {
//                    System.out.print(innerVector.get(i)); // Print element
//                    if (i < innerVector.size() - 1) {
//                        System.out.print(", "); // Print comma after each element except the last
//                    }
//                }
//                System.out.println(); // Move to the next line after printing each inner vector
//            }
            return data;
        }
    }

    public void deleteOrder(int idOrder) throws SQLException {
        String query = "DELETE FROM DonSuaChua WHERE IDDonHang = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idOrder);
            preparedStatement.executeUpdate();
            System.out.print("Delete Order!");
        }
    }

    public boolean isWorkerExist(int workerId) throws SQLException {
        String checkWorkerSql = "SELECT 1 FROM Tho WHERE IDTho = ?";

        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement checkWorkerStatement = con.prepareStatement(checkWorkerSql)) {

            // Thiết lập giá trị cho tham số trong câu lệnh SQL cho cả hai bảng
            checkWorkerStatement.setInt(1, workerId);

            try (ResultSet workerResultSet = checkWorkerStatement.executeQuery()) {
                if (workerResultSet.next()) {
                    // ID tồn tại trong bảng quản lý, thực hiện xóa
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addCustomerFeedback(int idCustomer, String DiemDanhGia, String DanhGiaTomTat, int idWorker, int idService) throws SQLException {
        String query = "INSERT INTO PhanHoi (DiemDanhGia, DanhGiaTomTat, ThoiGianPhanHoi, IDKhachHang, IDTho, IDDichVu) VALUES (?, ?, ?, ?, ?, ?)";

        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            // Lấy thời gian hiện tại
            long currentTimeMillis = System.currentTimeMillis();
            Timestamp currentTimestamp = new Timestamp(currentTimeMillis);

            preparedStatement.setString(1, DiemDanhGia);
            preparedStatement.setString(2, DanhGiaTomTat);
            preparedStatement.setTimestamp(3, currentTimestamp);
            preparedStatement.setInt(4, idCustomer);
            preparedStatement.setInt(5, idWorker);
            preparedStatement.setInt(6, idService);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected <= 0) {
                // Handle the case where the insert did not succeed
                throw new SQLException("Failed to insert user.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // get service name lise
    public Vector getServiceList() throws SQLException {
        String query = "SELECT IDLoaiDichVu, TenDichVu FROM LoaiDichVu";
        Vector<Vector> ServiceInfo = new Vector<Vector>();

        try (Connection connection = DriverManager.getConnection(ConnectionUrl)) {

            // Thực hiện truy vấn
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                // Thực hiện truy vấn SELECT
                ResultSet resultSet = preparedStatement.executeQuery();

                // Xử lý kết quả
                while (resultSet.next()) {
                    Vector row = new Vector();
                    // Lấy dữ liệu từ ResultSet
                    int idService = resultSet.getInt("IDLoaiDichVu");
                    String serviceName = resultSet.getString("TenDichVu");
                    row.add(idService);
                    row.add(serviceName);
                    ServiceInfo.add(row);
                }
                return ServiceInfo;
            }
        }
    }

    public void addService(String serviceName) throws SQLException {
        String insertQuery = "INSERT INTO LoaiDichVu (TenDichVu) VALUES (?)";
        try (Connection connection = DriverManager.getConnection(ConnectionUrl)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Đặt giá trị tham số là tên dịch vụ mới
                preparedStatement.setString(1, serviceName);

                // Thực hiện lệnh INSERT
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Add successfully.");
                } else {
                    System.out.println("Add fail.");
                }
            } catch (SQLException e) {
            }
        }
    }

    // delete Service from table
    private static void deleteServiceFromTable(String tableName, int idDichVuToDelete) throws SQLException {
        String deleteQuery = "DELETE FROM " + tableName + " WHERE IDDichVu = ?";
        try (Connection connection = DriverManager.getConnection(ConnectionUrl)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                // Set the parameter for IDDichVu
                preparedStatement.setInt(1, idDichVuToDelete);

                // Execute the DELETE statement
                int rowsAffected = preparedStatement.executeUpdate();

                System.out.println("Deleted from " + tableName + ": " + rowsAffected + " rows affected.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteService(int serviceId) throws SQLException {
        String query = "DELETE FROM LoaiDichVu WHERE IDLoaiDichVu = ?";
        deleteServiceFromTable("CoTheLam", serviceId);
        deleteServiceFromTable("DonSuaChua", serviceId);
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, serviceId);
            preparedStatement.executeUpdate();
            System.out.print("Delete Service Successfully!");
        }
    }
        public String getCitizenNum(int id) throws SQLException {
        String query = "SELECT * FROM NguoiDung WHERE IDNguoiDung = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("SoCCCD");
            } else {
                return null;
            }
        }
    }
        public String getPhoneNum(int id) throws SQLException {
        String query = "SELECT * FROM NguoiDung WHERE IDNguoiDung = ?";
        Connection con = DriverManager.getConnection(ConnectionUrl);
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("SoDienThoai");
            } else {
                return null;
            }
        }
    }
}
