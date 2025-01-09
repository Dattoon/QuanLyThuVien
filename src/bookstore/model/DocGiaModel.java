package bookstore.model;

import java.sql.Date;

public class DocGiaModel {
    private int maDG;
    private String tenDG;
    private Date ngaySinh;
    private String diaChiDG;
    private String dienThoai;
    private String maThe;
    private Date ngayHetHan;

    public DocGiaModel(int maDG, String tenDG, Date ngaySinh, String diaChiDG, String dienThoai, String maThe, Date ngayHetHan) {
        this.maDG = maDG;
        this.tenDG = tenDG;
        this.ngaySinh = ngaySinh;
        this.diaChiDG = diaChiDG;
        this.dienThoai = dienThoai;
        this.maThe = maThe;
        this.ngayHetHan = ngayHetHan;
    }

    // Getters and setters
    public int getMaDG() {
        return maDG;
    }

    public void setMaDG(int maDG) {
        this.maDG = maDG;
    }

    public String getTenDG() {
        return tenDG;
    }

    public void setTenDG(String tenDG) {
        this.tenDG = tenDG;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChiDG() {
        return diaChiDG;
    }

    public void setDiaChiDG(String diaChiDG) {
        this.diaChiDG = diaChiDG;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
}
