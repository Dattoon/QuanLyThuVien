package bookstore.model;

import java.sql.Date;

public class PhieuMuonModel {
    private int maMuon;
    private Date ngayMuon;
    private Date ngayHetHan;
    private int maDK;

    public PhieuMuonModel(int maMuon, Date ngayMuon, Date ngayHetHan, int maDK) {
        this.maMuon = maMuon;
        this.ngayMuon = ngayMuon;
        this.ngayHetHan = ngayHetHan;
        this.maDK = maDK;
    }

    // Getters and setters
    public int getMaMuon() {
        return maMuon;
    }

    public void setMaMuon(int maMuon) {
        this.maMuon = maMuon;
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

    public int getMaDK() {
        return maDK;
    }

    public void setMaDK(int maDK) {
        this.maDK = maDK;
    }
}
