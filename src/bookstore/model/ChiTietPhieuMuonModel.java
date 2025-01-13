package bookstore.model;

import java.sql.Date;

public class ChiTietPhieuMuonModel {
    private int maChiTiet;
    private int maMuon;
    private int maSach;
    private Date ngayTra;
    private float tienPhat;

    public ChiTietPhieuMuonModel(int maChiTiet, int maMuon, int maSach, Date ngayTra, float tienPhat) {
        this.maChiTiet = maChiTiet;
        this.tienPhat = tienPhat;
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

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }
    public float getTienPhat()
    {
    	return tienPhat;
    }
    public void settienPhat(float tienPhat) {
    	this.tienPhat = tienPhat;
    }
    
}
