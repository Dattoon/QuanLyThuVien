package bookstore.model;


public class PhieuMuonModel {
    private String maMuon;
    private String maDG;
    private String maSach;
    private String ngayMuon;
    private String ngayHetHan;

    // Constructor
    public PhieuMuonModel(String maMuon, String maDG, String maSach, String ngayMuon, String ngayHetHan) {
        this.maMuon = maMuon;
        this.maDG = maDG;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.ngayHetHan = ngayHetHan;
    }

    // Getters and setters
    public String getMaMuon() {
        return maMuon;
    }

    public void setMaMuon(String maMuon) {
        this.maMuon = maMuon;
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
}
