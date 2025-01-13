package bookstore.model;

import java.sql.Date;

public class PhieuMuonModel {

    private int maMuon;
    private int maDG;
    private Date ngayMuon;
    private Date ngayHetHan;

    public PhieuMuonModel(int int1, Date date, Date date2, int int2) {
    	this.maMuon  = int1;
    	this.maDG =  int2;
    	this.ngayHetHan = date2;
    	this.ngayMuon = date;
    	
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
}
