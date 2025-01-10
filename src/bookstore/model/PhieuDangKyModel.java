package bookstore.model;

import java.sql.Date;

public class PhieuDangKyModel {
    private int maDK;
    private int maDG;
    private Date ngayDK;

    public PhieuDangKyModel(int maDK, int maDG, Date ngayDK) {
        this.maDK = maDK;
        this.maDG = maDG;
        this.ngayDK = ngayDK;
    }

    // Getters and setters
    public int getMaDK() {
        return maDK;
    }

    public void setMaDK(int maDK) {
        this.maDK = maDK;
    }

    public int getMaDG() {
        return maDG;
    }

    public void setMaDG(int maDocGia) {
        this.maDG = maDocGia;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }
}
