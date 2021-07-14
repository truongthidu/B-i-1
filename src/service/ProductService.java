package service;

import csdl.CSDL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.SanPham;

public class ProductService {

    public List<SanPham> getAllProducts() {
        List<SanPham> sanPhams = new LinkedList<>();
        String sqlGetAllProducts = "SELECT SanPham.MaLoaiSP, TenLoaiSP, MaSP, TenSP, "
                + "NhaSanXuat FROM LoaiSanPham, SanPham WHERE LoaiSanPham.MaLoaiSP = SanPham.MaLoaiSP";
        try {

            Connection connection = CSDL.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetAllProducts);
            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaLoaiSP(resultSet.getInt("MaLoaiSP"));
                sanPham.setTenLoaiSP(resultSet.getString("TenLoaiSP"));
                sanPham.setMaSP(resultSet.getInt("MaSP"));
                sanPham.setTenSP(resultSet.getString("TenSP"));
                sanPham.setNhaSanXuat(resultSet.getString("NhaSanXuat"));
                sanPhams.add(sanPham);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sanPhams;
    }

    public Boolean createNewProduct(SanPham sanPham) {
        String sqlCreateLoaiSP = "INSERT INTO bai1.LoaiSanPham VALUES(?, ?)";
        String sqlCreateSP = "INSERT INTO bai1.SanPham VALUES(?, ?, ?, ?)";
        try {

            Connection connection = CSDL.getConnection();

            PreparedStatement preparedStatement1 = connection.prepareStatement(sqlCreateLoaiSP);
            preparedStatement1.setInt(1, sanPham.getMaLoaiSP());
            preparedStatement1.setString(2, sanPham.getTenLoaiSP());

            preparedStatement1.execute();

            PreparedStatement preparedStatement2 = connection.prepareStatement(sqlCreateSP);
            preparedStatement2.setInt(1, sanPham.getMaSP());
            preparedStatement2.setString(2, sanPham.getTenSP());
            preparedStatement2.setString(3, sanPham.getNhaSanXuat());
            preparedStatement2.setInt(4, sanPham.getMaLoaiSP());

            preparedStatement2.execute();
            preparedStatement1.close();
            preparedStatement2.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
