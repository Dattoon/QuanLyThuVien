package bookstore.model;

import java.sql.Date;

public class PhieuMuonModel {

    private int maMuon;
    private int maDG;
    private Date ngayMuon;
    private Date ngayHetHan;
    private int maSach;
    private String tuaSach;
    private String tenDG;

    // Constructor cho các phương thức thông thường
    public PhieuMuonModel(int maMuon, Date ngayMuon, Date ngayHetHan, int maDG, int maSach) {
        this.maMuon = maMuon;
        this.maDG = maDG;
        this.ngayMuon = ngayMuon;
        this.ngayHetHan = ngayHetHan;
        this.maSach = maSach;
    }

    // Constructor cho getPhieuMuonByMaDG
    public PhieuMuonModel(int maMuon, int maSach, String tuaSach, String tenDG, Date ngayMuon, Date ngayHetHan) {
        this.maMuon = maMuon;
        this.maSach = maSach;
        this.tuaSach = tuaSach;
        this.tenDG = tenDG;
        this.ngayMuon = ngayMuon;
        this.ngayHetHan = ngayHetHan;
    }

    // Getters and setters
    public int getMaMuon() {
        return maMuon;
    }

    public void setMaMuon(int maMuon) {
        this.maMuon = maMuon;
    }

    public int getMaDG() {
        return maDG;
    }

    public void setMaDG(int maDG) {
        this.maDG = maDG;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTuaSach() {
        return tuaSach;
    }

    public void setTuaSach(String tuaSach) {
        this.tuaSach = tuaSach;
    }

    public String getTenDG() {
        return tenDG;
    }

    public void setTenDG(String tenDG) {
        this.tenDG = tenDG;
    }

}
