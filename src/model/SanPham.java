package model;

public class SanPham extends LoaiSanPham {

    private int maSP;
    private String tenSP;
    private String nhaSanXuat;

    public SanPham() {
    }

    public SanPham(int maSP, String tenSP, String nhaSanXuat) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.nhaSanXuat = nhaSanXuat;
    }

    public SanPham(int maSP, String tenSP, String nhaSanXuat, int maLoaiSP, String tenLoaiSP) {
        super(maLoaiSP, tenLoaiSP);
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return "SanPham{" + super.toString() + ", maSP=" + maSP + ", tenSP=" + tenSP + ", nhaSanXuat=" + nhaSanXuat + '}';
    }

}
