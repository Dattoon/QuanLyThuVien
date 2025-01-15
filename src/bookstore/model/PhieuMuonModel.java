package bookstore.model;

import java.sql.Date;

public class PhieuMuonModel {

    private int maMuon;
    private int maDG;
    private Date ngayMuon;
    private Date ngayHetHan;
    private int maSach;

    public PhieuMuonModel(int maMuon, Date ngayMuon, Date ngayHetHan, int maDG, int maSach) {
        this.maMuon = maMuon;
        this.maDG = maDG;
        this.ngayMuon = ngayMuon;
        this.ngayHetHan = ngayHetHan;
        this.maSach = maSach;
    }

    // Getters and Setters
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
}
