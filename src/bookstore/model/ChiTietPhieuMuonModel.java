package bookstore.model;

public class ChiTietPhieuMuonModel {
    private int maChiTiet;
    private int maDK;
    private int maMuon;
    private int maSach;
    private String ngayTra;

    // Constructor
    public ChiTietPhieuMuonModel(int maChiTiet, int maDK, int maMuon, int maSach, String ngayTra) {
        this.maChiTiet = maChiTiet;
        this.maDK = maDK;
        this.maMuon = maMuon;
        this.maSach = maSach;
        this.ngayTra = ngayTra;
    }

    // Getters and setters
    public int getMaChiTiet() {
        return maChiTiet;
    }

    public void setMaChiTiet(int maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public int getMaDK() {
        return maDK;
    }

    public void setMaDK(int maDK) {
        this.maDK = maDK;
    }

    public int getMaMuon() {
        return maMuon;
    }

    public void setMaMuon(int maMuon) {
        this.maMuon = maMuon;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }
}
