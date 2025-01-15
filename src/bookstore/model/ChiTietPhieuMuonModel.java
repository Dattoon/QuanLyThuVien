package bookstore.model;

import java.sql.Date;

public class ChiTietPhieuMuonModel {
    private int maChiTiet;
    private int maMuon;
    private Date ngayTra;
    private Float tienPhat;

    public ChiTietPhieuMuonModel(int maChiTiet, int maMuon, Date ngayTra, Float tienPhat) {
        this.maChiTiet = maChiTiet;
        this.maMuon = maMuon;
        this.ngayTra = ngayTra;
        this.tienPhat = tienPhat;
    }

    // Getters and Setters
    public int getMaChiTiet() {
        return maChiTiet;
    }

    public void setMaChiTiet(int maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public int getMaMuon() {
        return maMuon;
    }

    public void setMaMuon(int maMuon) {
        this.maMuon = maMuon;
    }


    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Float getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(Float tienPhat) {
        this.tienPhat = tienPhat;
    }
}
