package main;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import model.SanPham;
import service.ProductService;

public class RunMain {

    Connection connection = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();

        int choice;

        while (true) {
            System.out.println("1. Hiện thị danh sách sản phẩm.");
            System.out.println("2. Thêm sản phẩm.");
            System.out.println("0. Thoát.");

            System.out.print("Lựa chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<SanPham> sanPhams = productService.getAllProducts();
                    for (SanPham sanPham : sanPhams) {
                        System.out.println(sanPham);
                    }
                    break;
                case 2:
                    int maSP;
                    String tenSP;
                    String nhaSanXuat;
                    int maLoaiSP;
                    String tenLoaiSP;

                    System.out.print("Nhập mã loại sản phẩm: ");
                    maLoaiSP = scanner.nextInt();
                    System.out.print("Nhập tên loại sản phẩm: ");
                    scanner.nextLine();
                    tenLoaiSP = scanner.nextLine();

                    System.out.print("Nhập mã sản phẩm: ");
                    maSP = scanner.nextInt();
                    System.out.print("Nhập tên sản phẩm: ");
                    scanner.nextLine();
                    tenSP = scanner.nextLine();
                    System.out.print("Nhập nhà sản xuất: ");
                    nhaSanXuat = scanner.nextLine();

                    SanPham sanPham = new SanPham(maSP, tenSP, nhaSanXuat, maLoaiSP, tenLoaiSP);
                    if (productService.createNewProduct(sanPham)) {
                        System.out.println("Thêm thành công.");
                    } else {
                        System.out.println("Thêm thất bại.");
                    }

                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
