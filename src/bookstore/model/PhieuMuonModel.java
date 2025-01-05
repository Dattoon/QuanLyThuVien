package bookstore.model;

public class PhieuMuonModel {
    private int maMuon;
    private String ngayMuon;
    private String ngayHetHan;
    private int maDK;

    // Constructor
    public PhieuMuonModel(int maMuon, String ngayMuon, String ngayHetHan, int maDK) {
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

    public int getMaDK() {
        return maDK;
    }

    public void setMaDK(int maDK) {
        this.maDK = maDK;
    }
}
